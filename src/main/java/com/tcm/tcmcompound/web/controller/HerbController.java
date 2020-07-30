package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.GEdge;
import com.tcm.tcmcompound.pojo.GNode;
import com.tcm.tcmcompound.dao.HerbDao;
import com.tcm.tcmcompound.pojo.Herb;
import com.tcm.tcmcompound.pojo.Prescription;
import com.tcm.tcmcompound.service.HerbService;
import com.tcm.tcmcompound.service.IngredientService;
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
    private IngredientService ingredientService;

    @ResponseBody
    @RequestMapping(value = "/graph",method = RequestMethod.GET)
    public HashMap<String, Object> SeePrescriptionGraph(String hidName){
        String hid_s=hidName.split("_")[1];
        int hid=Integer.parseInt(hid_s);
        System.out.println(hid);
        HashMap<String, Object> map = new HashMap<String, Object>();
        ArrayList<GNode> NodeList = new ArrayList<GNode>();
        ArrayList<GEdge> EdgeList = new ArrayList<GEdge>();

        Map<Integer,String> mmap=herbService.getIngredientById(hid);
        if(!mmap.isEmpty()){
            for(Map.Entry<Integer,String> entry:mmap.entrySet()){
                String iidName="i_"+hid+"_"+entry.getKey();
                GNode gNode1 = new GNode(iidName, entry.getValue(),"i",true);
                GEdge gLink1 = new GEdge("hi_"+iidName+hidName, hidName,iidName);
                NodeList.add(gNode1);
                EdgeList.add(gLink1);
            }
        }

        map.put("nodes", NodeList);
        map.put("edges", EdgeList);
        return map;
    }

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
        return "herb";
    }
}
