package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.pojo.Compound;
import com.tcm.tcmcompound.service.CompoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.swing.plaf.basic.ComboPopup;

@Controller
public class CompoundController {
    private final CompoundService compoundService;

    @Autowired
    public CompoundController(CompoundService compoundService) {
        this.compoundService = compoundService;
    }

    @RequestMapping("/compound/{id}")
    String home(Model model, @PathVariable Integer id) {
        Compound compound = compoundService.getById(id);
        model.addAttribute("name", compound.getCompoundName());
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
        return "compound";
    }
}
