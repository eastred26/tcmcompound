package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.HerbName;
import com.tcm.tcmcompound.pojo.Prescription;
import com.tcm.tcmcompound.service.HerbService;
import com.tcm.tcmcompound.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import com.tcm.tcmcompound.pojo.GNode;
import com.tcm.tcmcompound.pojo.GEdge;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping(value = "/prescription")
public class PrescriptionController {
    @Autowired
    private PrescriptionService prescriptionService;
    @Autowired
    private HerbService herbService;

    @RequestMapping("/{id}")
    String home(Model model, @PathVariable int id) {
        Prescription prescription = prescriptionService.getById(id);
        model.addAttribute("ID", prescription.getId());
        model.addAttribute("name", prescription.getChinese_name());
        model.addAttribute("composition", prescription.getComposition());
        model.addAttribute("indication", prescription.getIndication());
        model.addAttribute("reference", prescription.getReference());
        model.addAttribute("use_method", prescription.getUse_method());
        model.addAttribute("herbs", prescriptionService.getHerbById(id));
        model.addAttribute("ingredients", prescriptionService.getIngredientById(id));
        return "prescription";
    }

    @RequestMapping(value = "/graph/{PID}")
    public String SeePrescription(@PathVariable("PID") Integer PID, Model model){
        model.addAttribute("PID",PID);
        return "prescriptionGraph";
    }

    //graph是请求节点的子项，并添加进map中
    //graph_init 初始化图。除了请求子项，还有初始点的设置。
    @ResponseBody
    @RequestMapping(value = "/graph_init",method = RequestMethod.GET)
    public HashMap<String, Object> GraphInit(int PID){
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        String name=prescriptionService.getNameById(PID);
        String pidName="p_"+PID;
        GNode gNode = new GNode(pidName, name,"p",false);
        NodeList.add(gNode);
        Map<Integer,String> phMap=prescriptionService.getHerbById(PID);
        if(!phMap.isEmpty()){
            for(Map.Entry<Integer,String> entry:phMap.entrySet()){
                String hidName="h_"+entry.getKey()+"_"+PID;
                GNode gNode1 = new GNode(hidName, entry.getValue(),"h",true);
                GEdge gLink1 = new GEdge("ph"+hidName+pidName, pidName,hidName);
                NodeList.add(gNode1);
                EdgeList.add(gLink1);
            }
        }
        Map<Integer,String> piMap=prescriptionService.getIngredientById(PID);
        if(!piMap.isEmpty()){
            for(Map.Entry<Integer,String> entry:piMap.entrySet()){
                String iidName="i_"+entry.getKey()+"_"+PID;
                GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                GEdge gLink1 = new GEdge("pi"+iidName+pidName, pidName,iidName);
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
    public HashMap<String, Object> findHerbGraph(String idName){
        int pid_num=Integer.parseInt(idName.split("_")[1]);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> phMap=prescriptionService.getHerbById(pid_num);
        if(!phMap.isEmpty()){
            num=phMap.keySet().size();
            for(Map.Entry<Integer,String> entry:phMap.entrySet()){
                String hidName="h_"+entry.getKey()+"_"+pid_num;
                GNode gNode1 = new GNode(hidName, entry.getValue(),"h",true);
                GEdge gLink1 = new GEdge("ph"+hidName+idName, idName,hidName);
                NodeList.add(gNode1);
                EdgeList.add(gLink1);
            }
        }
        map.put("NodeNum", num);
        map.put("nodes", NodeList);
        map.put("edges", EdgeList);
        return map;
    }

    @ResponseBody
    @RequestMapping(value = "/graph_hi",method = RequestMethod.GET)
    public HashMap<String, Object> findHerbAndIngredientGraph(String idName){
        int pid_num=Integer.parseInt(idName.split("_")[1]);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> phMap=prescriptionService.getHerbById(pid_num);
        Map<Integer,String> piMap=prescriptionService.getIngredientById(pid_num);
        num=phMap.keySet().size()+piMap.keySet().size();
        if(num<120){
            if(!phMap.isEmpty()){
                for(Map.Entry<Integer,String> entry:phMap.entrySet()){
                    String hidName="h_"+entry.getKey()+"_"+pid_num;
                    GNode gNode1 = new GNode(hidName, entry.getValue(),"h",true);
                    GEdge gLink1 = new GEdge("ph"+hidName+idName, idName,hidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
            if(!piMap.isEmpty()){
                for(Map.Entry<Integer,String> entry:piMap.entrySet()){
                    String hidName="i_"+entry.getKey()+"_"+pid_num;
                    GNode gNode1 = new GNode(hidName, entry.getValue(),"i",true);
                    GEdge gLink1 = new GEdge("pi"+hidName+idName, idName,hidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        map.put("NodeNum", num);
        map.put("nodes", NodeList);
        map.put("edges", EdgeList);
        return map;
    }
}
