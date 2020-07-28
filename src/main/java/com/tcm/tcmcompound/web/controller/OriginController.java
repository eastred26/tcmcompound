package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.MedOrigin;
import com.tcm.tcmcompound.service.MedOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.lang.*;

@Controller
public class OriginController {
    private final MedOriginService medOriginService;

    @Autowired
    public OriginController(MedOriginService medOriginService){
        this.medOriginService = medOriginService;
    }

    @RequestMapping("/origin/{id}")
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
        model.addAttribute("meds", medOriginService.getMedById(id));
        return "origin";
    }
}
