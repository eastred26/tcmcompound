package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.GEdge;
import com.tcm.tcmcompound.pojo.GNode;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.pojo.Target;
import com.tcm.tcmcompound.service.MedService;
import com.tcm.tcmcompound.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Controller
public class TargetController {
    @Autowired
    private TargetService targetService;

    @RequestMapping("/target/{id}")
    String home(Model model, @PathVariable int id) {
        Target target = targetService.getById(id);
        model.addAttribute("name",target.getName());
        model.addAttribute("gene_name",target.getGene_Name());
        model.addAttribute("drugs",targetService.getDrugById(id));
        model.addAttribute("diseases",targetService.getDiseaseById(id));
        return "target";
    }
    @ResponseBody
    @RequestMapping(value = "/target/graph",method = RequestMethod.GET)
    public HashMap<String, Object> findDiseasesGraph(String idName){
        String tid_s=idName.split("_")[1];
        int tid=Integer.parseInt(tid_s);
        System.out.println(tid);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> mmap=targetService.getDiseaseById(tid);
        Map<Integer,String> mmap2=targetService.getDrugById(tid);
        num=mmap.keySet().size()+mmap2.keySet().size();
        if(!mmap.isEmpty()){
            if(num<100){
                for(Map.Entry<Integer,String> entry:mmap.entrySet()){
                    String didName="disease_"+entry.getKey()+"_"+tid;
                    GNode gNode1 = new GNode(didName, entry.getValue(),"disease",true);
                    GEdge gLink1 = new GEdge("td"+didName+idName, didName,idName);
                    NodeList.add(gNode1);
                    EdgeList.add(gLink1);
                }
            }
        }
        if(!mmap2.isEmpty()){
            if(num<100){
                for(Map.Entry<Integer,String> entry:mmap2.entrySet()){
                    String didName="drug_"+entry.getKey()+"_"+tid;
                    GNode gNode1 = new GNode(didName, entry.getValue(),"drug",true);
                    GEdge gLink1 = new GEdge("td"+didName+idName, didName,idName);
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

}
