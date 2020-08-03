package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.GEdge;
import com.tcm.tcmcompound.pojo.GNode;
import com.tcm.tcmcompound.pojo.MedOrigin;
import com.tcm.tcmcompound.service.MedOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/origin")
public class OriginController {
    @Autowired
    private MedOriginService medOriginService;

    @RequestMapping("/{id}")
    String home(Model model, @PathVariable Integer id) {
        MedOrigin medOrigin = medOriginService.getById(id);
        model.addAttribute("name", medOrigin.getName());
        model.addAttribute("latin_name", medOrigin.getLatin_name());
        model.addAttribute("appearance", medOrigin.getAppearance());
        model.addAttribute("location", medOrigin.getLocation());
        model.addAttribute("plant_id", medOrigin.getPlant_id());

        String gethierarchy = medOrigin.getHierarchy();
        StringBuffer origin_phylum = new StringBuffer();
        StringBuffer origin_class = new StringBuffer();
        StringBuffer origin_order = new StringBuffer();
        StringBuffer origin_family = new StringBuffer();
        StringBuffer origin_genus = new StringBuffer();
        if(gethierarchy != null){
            String[] hierarchy = gethierarchy.split("->");
            for(int i = 0; i < hierarchy.length; i++){
                if(hierarchy[i].contains("门")){
                    origin_phylum.append(hierarchy[i]);
                }
                if(hierarchy[i].contains("纲")){
                    origin_class.append(hierarchy[i]);
                }
                if(hierarchy[i].contains("目")){
                    origin_order.append(hierarchy[i]);
                }
                if(hierarchy[i].contains("科")){
                    origin_family.append(hierarchy[i]);
                }
                if(hierarchy[i].contains("属")){
                    origin_genus.append(hierarchy[i]);
                }
            }
        }
        model.addAttribute("origin_phylum", origin_phylum);
        model.addAttribute("origin_class", origin_class);
        model.addAttribute("origin_order", origin_order);
        model.addAttribute("origin_family", origin_family);
        model.addAttribute("origin_genus", origin_genus);
        model.addAttribute("ID", id);
        model.addAttribute("meds", medOriginService.getMedById(id));
        return "origin";
    }

    @RequestMapping(value = "/graph/{OID}")
    public String SeePrescription(@PathVariable("OID") Integer OID, Model model){
        model.addAttribute("OID",OID);
        return "OriginGraph";
    }

    //graph是请求节点的子项，并添加进map中
    //graph_init 初始化图。除了请求子项，还有初始点的设置。
    @ResponseBody
    @RequestMapping(value = "/graph_init",method = RequestMethod.GET)
    public HashMap<String, Object> GraphInit(int OID){
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        String name=medOriginService.getNameById(OID);
        String oidName="o_"+OID;
        GNode gNode = new GNode(oidName, name,"o",false);
        NodeList.add(gNode);
        Map<Integer,String> ohMap=medOriginService.getGraphMedById(OID);
        if(!ohMap.isEmpty()){
            for(Map.Entry<Integer,String> entry:ohMap.entrySet()){
                int mid=entry.getKey();
                if(mid>0){
                    String hidName="h_"+entry.getKey()+"_"+OID;
                    GNode gNode1 = new GNode(hidName, entry.getValue(),"h",true);
                    GEdge gLink1 = new GEdge("oh"+hidName+oidName, oidName,hidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
                else{
                    String hidName="m_"+entry.getKey()+"_"+OID;
                    GNode gNode1 = new GNode(hidName, entry.getValue(),"m",true);
                    GEdge gLink1 = new GEdge("om"+hidName+oidName, oidName,hidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        Map<Integer,String> oiMap=medOriginService.getCompoundById(OID);
        if(!oiMap.isEmpty()){
            for(Map.Entry<Integer,String> entry:oiMap.entrySet()){
                String iidName="i_"+entry.getKey()+"_"+OID;
                GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                GEdge gLink1 = new GEdge("oi"+iidName+oidName, oidName,iidName);
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
        int oid_num=Integer.parseInt(idName.split("_")[1]);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> oiMap=medOriginService.getCompoundById(oid_num);
        if(!oiMap.isEmpty()){
            num=oiMap.keySet().size();
            if(num<120){
                for(Map.Entry<Integer,String> entry:oiMap.entrySet()){
                    String iidName="i_"+entry.getKey()+"_"+oid_num;
                    GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                    GEdge gLink1 = new GEdge("oi"+iidName+idName, idName,iidName);
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
    @ResponseBody
    @RequestMapping(value = "/graph_hi",method = RequestMethod.GET)
    public HashMap<String, Object> findHerbAndIngredientGraph(String idName){
        int oid_num=Integer.parseInt(idName.split("_")[1]);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> oiMap=medOriginService.getCompoundById(oid_num);
        Map<Integer,String> ohMap=medOriginService.getGraphMedById(oid_num);
        num=oiMap.keySet().size()+ohMap.keySet().size();
        if(!oiMap.isEmpty()){
            if(num<120){
                for(Map.Entry<Integer,String> entry:oiMap.entrySet()){
                    String iidName="i_"+entry.getKey()+"_"+oid_num;
                    GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                    GEdge gLink1 = new GEdge("oi"+iidName+idName, idName,iidName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        if(!ohMap.isEmpty()){
            if(num<120){
                for(Map.Entry<Integer,String> entry:ohMap.entrySet()){
                    String iidName="h_"+entry.getKey()+"_"+oid_num;
                    GNode gNode1 = new GNode(iidName, entry.getValue(),"h",true);
                    GEdge gLink1 = new GEdge("oh"+iidName+idName, idName,iidName);
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
