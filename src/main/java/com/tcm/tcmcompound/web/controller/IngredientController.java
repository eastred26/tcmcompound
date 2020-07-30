package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.Ingredient;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.service.IngredientService;
import com.tcm.tcmcompound.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class IngredientController {
    @Autowired
    private IngredientService ingredientService;


    @RequestMapping("/ingredient/{id}")
    String home(Model model, @PathVariable int id) {
        Ingredient ingredient = ingredientService.getIngredientById(id);
        model.addAttribute("Name", ingredient.getName());
        model.addAttribute("Formula", ingredient.getFormula());
        model.addAttribute("Pubchem_ID", ingredient.getPubChem_ID());
        model.addAttribute("SMILE", ingredient.getSMILE());
        return "ingredient";
    }
}
