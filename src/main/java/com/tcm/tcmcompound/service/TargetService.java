package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.pojo.Target;

import java.util.List;
import java.util.Map;

public interface TargetService {
    Target getById(Integer id);
    Map<Integer, String> getDrugById(Integer id);
    Map<Integer, String> getDiseaseById(Integer id);
    Map<Integer, String> getIngredientsById(Integer tid);
    Map<Integer, String> getHerbsById(Integer tid);
}
