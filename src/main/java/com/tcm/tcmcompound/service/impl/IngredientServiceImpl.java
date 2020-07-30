package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.IngredientDao;
import com.tcm.tcmcompound.pojo.Ingredient;
import com.tcm.tcmcompound.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientDao ingredientDao;
    @Override
    public String getNamebyId(int id){
        return ingredientDao.getIngredientName(id);
    }
    @Override
    public Ingredient getIngredientById(int id){
        return ingredientDao.getIngredientById(id);
    }
}
