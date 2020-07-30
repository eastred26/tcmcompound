package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.pojo.Herb;

import java.util.Map;

public interface HerbService {
    public String getNamebyId(int id);
    public String getIngredientsbyId(int id);
    public Map<Integer, String> getIngredientById(Integer id);
    public Herb getById(int id);
}
