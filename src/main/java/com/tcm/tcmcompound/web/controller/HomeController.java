package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.service.CompoundService;
import com.tcm.tcmcompound.service.MedOriginService;
import com.tcm.tcmcompound.service.MedService;
import com.tcm.tcmcompound.service.PrescriptionService;
import com.tcm.tcmcompound.utils.ChineseCharacterUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

@Controller
public class HomeController {
    @Autowired
    private  MedService medService;
    @Autowired
    private  MedOriginService medOriginService;
    @Autowired
    private  CompoundService compoundService;
    @Autowired
    private PrescriptionService prescriptionService;

    @RequestMapping("/")
    String root() {
        return "redirect:/home";
    }

    @RequestMapping("/home")
    String home(Model model){
        Map<String, Map<Integer, String>> medMap = new LinkedHashMap<>();
        Map<String, Map<Integer, String>> medOriginMap = new LinkedHashMap<>();
        Map<String, Map<Integer, String>> prescriptionMap = new LinkedHashMap<>();
        Map<Integer, String> medNameMap;
        Map<Integer, String> originNameMap;
        Map<Integer, String> prescriptionNameMap;
        Map<String, List<String>> structureNameMap = new HashMap<>();
        String firstchar;
        for(char a = 'A'; a <= 'Z'; a++){
            medNameMap = medService.getAllName(String.valueOf(a));
            if(!medNameMap.isEmpty()){
                medMap.put(String.valueOf(a), medNameMap);
            }
            originNameMap = medOriginService.getAllName(String.valueOf(a));
            if (!originNameMap.isEmpty()){
                medOriginMap.put(String.valueOf(a), originNameMap);
            }
            prescriptionNameMap=prescriptionService.getAllName(String.valueOf(a));
            if(prescriptionNameMap!=null&&!prescriptionNameMap.isEmpty()){
                prescriptionMap.put(String.valueOf(a),prescriptionNameMap);
            }
        }
        List<String> structureName = compoundService.getAllStructureName();
        for (String name: structureName){
            firstchar = ChineseCharacterUtil.getUpperCase(name, false).substring(0, 1);
            if(structureNameMap.containsKey(firstchar)){
                structureNameMap.get(firstchar).add(name);
            } else {
                List<String> names = new ArrayList<>();
                names.add(name);
                structureNameMap.put(firstchar, names);
            }
        }
        model.addAttribute("medMap",medMap);
        model.addAttribute("medOriginMap",medOriginMap);
        model.addAttribute("prescriptionMap",prescriptionMap);
        model.addAttribute("structureNameMap", structureNameMap);
        return "home";
    }

    @RequestMapping("/home_old")
    String home_old(Model model){
        Map<String, Map<Integer, String>> medMap = new LinkedHashMap<>();
        Map<String, Map<Integer, String>> medOriginMap = new LinkedHashMap<>();
        Map<Integer, String> medNameMap;
        Map<Integer, String> originNameMap;
        Map<String, List<String>> structureNameMap = new HashMap<>();
        String firstchar;
        for(char a = 'A'; a <= 'Z'; a++){
            medNameMap = medService.getAllName(String.valueOf(a));
            if(!medNameMap.isEmpty()){
                medMap.put(String.valueOf(a), medNameMap);
            }
            originNameMap = medOriginService.getAllName(String.valueOf(a));
            if (!originNameMap.isEmpty()){
                medOriginMap.put(String.valueOf(a), originNameMap);
            }
        }
        List<String> structureName = compoundService.getAllStructureName();
        for (String name: structureName){
            firstchar = ChineseCharacterUtil.getUpperCase(name, false).substring(0, 1);
            if(structureNameMap.containsKey(firstchar)){
                structureNameMap.get(firstchar).add(name);
            } else {
                List<String> names = new ArrayList<>();
                names.add(name);
                structureNameMap.put(firstchar, names);
            }
        }
        model.addAttribute("medMap",medMap);
        model.addAttribute("medOriginMap",medOriginMap);
        model.addAttribute("structureNameMap", structureNameMap);
        return "home_old";
    }
}
