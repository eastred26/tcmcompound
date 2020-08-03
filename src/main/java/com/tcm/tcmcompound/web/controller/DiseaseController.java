package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.Disease;
import com.tcm.tcmcompound.pojo.Ingredient;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.service.DiseaseService;
import com.tcm.tcmcompound.service.IngredientService;
import com.tcm.tcmcompound.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;


    @RequestMapping("/disease/{id}")
    String home(Model model, @PathVariable int id) {
        Disease disease = diseaseService.getById(id);
        model.addAttribute("name", disease.getName());
        model.addAttribute("OMIM_ID", disease.getOMIM_ID());
        model.addAttribute("alternative_name", disease.getAlternative_Name());
        return "disease";
    }
}
