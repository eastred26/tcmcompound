package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.dao.IngredientDao;
import com.tcm.tcmcompound.pojo.Compound;
import com.tcm.tcmcompound.pojo.Ingredient;
import com.tcm.tcmcompound.service.CompoundService;
import com.tcm.tcmcompound.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.basic.ComboPopup;

@Controller
public class CompoundController {
    @Autowired
    private CompoundService compoundService;
    @Autowired
    private IngredientService ingredientService;

    @RequestMapping("/compound/{id}")
    String home(Model model, @PathVariable Integer id) {
        Compound compound = compoundService.getById(id);
        String ingredient_id_s=compoundService.getIngredient(id);
        if(ingredient_id_s!=null){
            int ingredient_id=Integer.parseInt(ingredient_id_s);
            Ingredient ingredient = ingredientService.getIngredientById(ingredient_id);
            model.addAttribute("Pubchem_ID",ingredient.getPubChem_ID());
            model.addAttribute("SMILE", ingredient.getSMILE());
            model.addAttribute("targets",ingredientService.getTargetsByName(ingredient.getName()));
        }
        model.addAttribute("name", compound.getCompound_name());
        model.addAttribute("synonym", compound.getSynonym());
        model.addAttribute("CAS", compound.getCAS());
        model.addAttribute("compound_id", compound.getCompound_id());
        model.addAttribute("structure", compound.getStructure());
        model.addAttribute("formula", compound.getFormula());
        model.addAttribute("molecular_weight", compound.getMolecular_weight());
        model.addAttribute("H_bond_donnor", compound.getH_bond_donnor());
        model.addAttribute("H_bond_acceptor", compound.getH_bond_acceptor());
        model.addAttribute("rotable_bonds", compound.getRotable_bonds());
        model.addAttribute("hydrophobic_alogp", compound.getHydrophobic_alogp());
        model.addAttribute("atoms", compound.getAtoms());
        model.addAttribute("heavy_atoms", compound.getHeavy_atoms());
        model.addAttribute("H_atoms", compound.getH_atoms());
        model.addAttribute("C_atoms", compound.getC_atoms());
        model.addAttribute("bonds", compound.getBonds());
        model.addAttribute("non_H_bonds", compound.getNon_H_bonds());
        model.addAttribute("rings", compound.getRings());
        model.addAttribute("se_sum", compound.getSe_sum());
        model.addAttribute("absolute_atomic_charge", compound.getAbsolute_atomic_charge());
        model.addAttribute("squared_atomic_charge", compound.getSquared_atomic_charge());
        model.addAttribute("meds", compoundService.getMedsById(id));
        model.addAttribute("origins", compoundService.getOriginsById(id));
        model.addAttribute("ingredient",ingredient_id_s);
        return "compound";
    }
}
