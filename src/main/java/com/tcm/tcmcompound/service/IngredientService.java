package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.pojo.Ingredient;
import org.springframework.stereotype.Service;

import java.util.Map;

public interface IngredientService {
    String getNamebyId(int id);
    Ingredient getIngredientById(int id);
    Map<Integer, String> getTargetsByName(String name);
    String getCompound(String pubchem_id);
}
