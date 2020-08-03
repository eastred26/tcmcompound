package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.Drug;
import com.tcm.tcmcompound.pojo.Ingredient;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.service.DrugService;
import com.tcm.tcmcompound.service.IngredientService;
import com.tcm.tcmcompound.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DrugController {
    @Autowired
    private DrugService drugService;


    @RequestMapping("/drug/{id}")
    String home(Model model, @PathVariable int id) {
        Drug drug = drugService.getById(id);
        String drugbank=drug.getDrugbank_Access_No();
        model.addAttribute("name", drug.getName());
        model.addAttribute("drugbank", drugbank);
        model.addAttribute("type", drug.getDrug_Type());
        return "drug";
    }
}
