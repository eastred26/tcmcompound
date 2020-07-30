package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.pojo.Ingredient;
import org.springframework.stereotype.Service;

public interface IngredientService {
    String getNamebyId(int id);
    Ingredient getIngredientById(int id);
}
