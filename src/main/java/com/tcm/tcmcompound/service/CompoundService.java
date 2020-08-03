package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.pojo.Compound;

import java.util.List;
import java.util.Map;

public interface CompoundService {
    List<Compound> getAll();
    Compound getByName(String compoundName);
    Compound getById(Integer id);
    List<String> getMedsByName(String compoundName);
    List<String> getOriginsByName(String compoundName);
    String getIngredient(Integer id);
    Map<Integer, String> getMedsById(Integer id);
    Map<Integer, String> getOriginsById(Integer id);
    List<String> getAllStructureName();
}
