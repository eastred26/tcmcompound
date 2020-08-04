package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.GEdge;
import com.tcm.tcmcompound.pojo.GNode;
import com.tcm.tcmcompound.pojo.Ingredient;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.service.IngredientService;
import com.tcm.tcmcompound.service.MedService;
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
@RequestMapping("/ingredient")
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;


    @RequestMapping("/{id}")
    String home(Model model, @PathVariable int id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        String pubchem_id=ingredient.getPubChem_ID();
        String compound_s=ingredientService.getCompound(pubchem_id);
        if(compound_s!=null)return "redirect:/compound/"+compound_s;
        String name=ingredient.getName();
        model.addAttribute("Name", name);
        model.addAttribute("Formula", ingredient.getFormula());
        model.addAttribute("Pubchem_ID", pubchem_id);
        model.addAttribute("SMILE", ingredient.getSMILE());
        model.addAttribute("compound",compound_s);
        model.addAttribute("targets",ingredientService.getTargetsByName(name));
        return "ingredient";
    }
    @ResponseBody
    @RequestMapping(value = "/graph",method = RequestMethod.GET)
    public HashMap<String, Object> findTargetsGraph(String idName){
        String iid_s=idName.split("_")[1];
        int iid=Integer.parseInt(iid_s);
        //System.out.println(iid);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();
        int num=0;
        Map<Integer,String> mmap=ingredientService.getTargetsByName(ingredientService.getNamebyId(iid));
        if(!mmap.isEmpty()){
            num=mmap.keySet().size();
            if(num<120){
                for(Map.Entry<Integer,String> entry:mmap.entrySet()){
                    String tidName="t_"+entry.getKey()+"_"+iid;
                    GNode gNode1 = new GNode(tidName, entry.getValue(),"t",true);
                    GEdge gLink1 = new GEdge("it"+tidName+idName, tidName,idName);
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
