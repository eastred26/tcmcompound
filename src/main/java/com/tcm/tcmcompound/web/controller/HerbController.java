package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.GEdge;
import com.tcm.tcmcompound.pojo.GNode;
import com.tcm.tcmcompound.dao.HerbDao;
import com.tcm.tcmcompound.pojo.Herb;
import com.tcm.tcmcompound.pojo.Prescription;
import com.tcm.tcmcompound.service.HerbService;
import com.tcm.tcmcompound.service.IngredientService;
import com.tcm.tcmcompound.service.MedService;
import com.tcm.tcmcompound.service.PrescriptionService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.ui.Model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import com.tcm.tcmcompound.dao.PrescriptionDao;


@Controller
@RequestMapping(value = "/herb")
public class HerbController {

    @Autowired
    private HerbService herbService;

    @Autowired
    private MedService medService;

    @RequestMapping("/{id}")
    String home(Model model, @PathVariable int id) {
        Herb herb = herbService.getById(id);
        String name=herbService.getNamebyId(id);
        model.addAttribute("name", name);
        model.addAttribute("latin_name", herb.getLatin_name());
        model.addAttribute("chinese_name", herb.getChinese_name());
        model.addAttribute("english_name", herb.getEnglish_name());
        model.addAttribute("indication", herb.getIndication());
        model.addAttribute("effect", herb.getEffect());
        model.addAttribute("meridians", herb.getMeridians());
        model.addAttribute("properties", herb.getProperties());
        model.addAttribute("use_part", herb.getUse_part());
        model.addAttribute("ingredients", herbService.getIngredientById(id));
        model.addAttribute("medicine",herbService.getMedById(id));
        model.addAttribute("ID", id);
        return "herb";
    }

    //graph是请求节点的子项，并添加进map中
    //graph_init 初始化图。除了请求子项，还有初始点的设置。
    @ResponseBody
    @RequestMapping(value = "/graph_init",method = RequestMethod.GET)
    public HashMap<String, Object> GraphInit(int HID){
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        String name=herbService.getNamebyId(HID);
        Integer med=herbService.getMedById(HID);
        String pidName="h_"+HID;
        GNode gNode = new GNode(pidName, name,"h",false);
        NodeList.add(gNode);
        Map<Integer,String> mmap=herbService.getIngredientById(HID);
        if(med!=null){
            Map<Integer,String> mmap2=medService.getOriginById(med);
            if(!mmap2.isEmpty()){
                for(Map.Entry<Integer,String> entry:mmap2.entrySet()){
                    String iidName="o_"+entry.getKey()+"_"+HID;
                    GNode gNode1 = new GNode(iidName, entry.getValue(),"o",true);
                    GEdge gLink1 = new GEdge("ho"+iidName+pidName, pidName,iidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        if(!mmap.isEmpty()){
            for(Map.Entry<Integer,String> entry:mmap.entrySet()){
                String iidName="i_"+entry.getKey()+"_"+HID;
                GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                GEdge gLink1 = new GEdge("hi"+iidName+pidName, pidName,iidName);
                NodeList.add(gNode1);
                EdgeList.add(gLink1);
            }
        }

        map.put("nodes", NodeList);
        map.put("edges", EdgeList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/graph",method = RequestMethod.GET)
    public HashMap<String, Object> findIngredientGraph(String idName){
        String hid_s=idName.split("_")[1];
        int hid=Integer.parseInt(hid_s);
        //System.out.println(hid);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> mmap=herbService.getIngredientById(hid);
        if(!mmap.isEmpty()){
            num=mmap.keySet().size();
            if(num<120){
                for(Map.Entry<Integer,String> entry:mmap.entrySet()){
                    String iidName="i_"+entry.getKey()+"_"+hid;
                    GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                    GEdge gLink1 = new GEdge("hi"+iidName+idName, idName,iidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        map.put("NodeNum",num);
        map.put("nodes", NodeList);
        map.put("edges", EdgeList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/graph_oi",method = RequestMethod.GET)
    public HashMap<String, Object> findIngredientAndOriginGraph(String idName){
        String hid_s=idName.split("_")[1];
        int hid=Integer.parseInt(hid_s);
        //System.out.println(hid);
        Integer med=herbService.getMedById(hid);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> mmap=herbService.getIngredientById(hid);
        if(med!=null){
            Map<Integer,String> mmap2=medService.getOriginById(med);
            if(!mmap2.isEmpty()){
                num=mmap2.keySet().size()+mmap.keySet().size();;
                if(num<100){
                    for(Map.Entry<Integer,String> entry:mmap2.entrySet()){
                        String iidName="o_"+entry.getKey()+"_"+hid;
                        GNode gNode1 = new GNode(iidName, entry.getValue(),"o",true);
                        GEdge gLink1 = new GEdge("ho"+iidName+idName, idName,iidName);
                        NodeList.add(gNode1);
                        EdgeList.add(gLink1);
                    }
                }
            }
        }
        if(!mmap.isEmpty()){
            if(num<120){
                for(Map.Entry<Integer,String> entry:mmap.entrySet()){
                    String iidName="i_"+entry.getKey()+"_"+hid;
                    GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                    GEdge gLink1 = new GEdge("hi"+iidName+idName, idName,iidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        map.put("NodeNum",num);
        map.put("nodes", NodeList);
        map.put("edges", EdgeList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/graph_pi",method = RequestMethod.GET)
    public HashMap<String, Object> findIngredientAndPrescriptionGraph(String idName){
        String hid_s=idName.split("_")[1];
        int hid=Integer.parseInt(hid_s);
        //System.out.println(hid);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> mmap=herbService.getIngredientById(hid);
        Map<Integer,String> mmap2=herbService.findPrescriptionById(hid);
        num=mmap.keySet().size()+mmap2.keySet().size();
        if(!mmap.isEmpty()){
            if(num<120){
                for(Map.Entry<Integer,String> entry:mmap.entrySet()){
                    String iidName="i_"+entry.getKey()+"_"+hid;
                    GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                    GEdge gLink1 = new GEdge("hi"+iidName+idName, idName,iidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        if(!mmap2.isEmpty()){
            if(num<120){
                for(Map.Entry<Integer,String> entry:mmap.entrySet()){
                    String iidName="p_"+entry.getKey()+"_"+hid;
                    GNode gNode1 = new GNode(iidName, entry.getValue(),"p",true);
                    GEdge gLink1 = new GEdge("hp"+iidName+idName, idName,iidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        map.put("NodeNum",num);
        map.put("nodes", NodeList);
        map.put("edges", EdgeList);
        return map;
    }

    @RequestMapping(value = "/graph/{HID}")
    public String SeePrescription(@PathVariable("HID") Integer HID, Model model){
        model.addAttribute("HID",HID);
        return "herbGraph";
    }


}
