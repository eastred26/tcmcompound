package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.pojo.Target;

import java.util.Map;

public interface TargetService {
    Target getById(Integer id);
    Map<Integer, String> getDrugById(Integer id);
    Map<Integer, String> getDiseaseById(Integer id);
}
