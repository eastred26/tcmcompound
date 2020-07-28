package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MedicineController {
    private final MedService medService;

    @Autowired
    public MedicineController(MedService medService) {
        this.medService = medService;
    }

    @RequestMapping("/medicine/{id}")
    String home(Model model, @PathVariable int id) {
        Med med = medService.getById(id);
        model.addAttribute("name", med.getName());
        model.addAttribute("latin_name", med.getLatin_name());
        model.addAttribute("med_function", med.getMed_function());
        model.addAttribute("med_property", med.getMed_property());
        model.addAttribute("med_tropisw", med.getMed_tropisw());
        model.addAttribute("med_origin", med.getMed_origin());
        model.addAttribute("origins", medService.getOriginById(id));
        model.addAttribute("tcm_id", med.getTcm_id());
        model.addAttribute("tcm_name", med.getTcm_name());
        return "medicine";
    }
}
