package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.pojo.CompoundSimple;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import com.tcm.tcmcompound.pojo.MedOriginRelate;

import java.util.List;
import java.util.Map;

public interface MedService {
    List<String> getAllName();
    Map<Integer, String> getAllName(String alphabet);
    Med getByName(String name);
    Med getById(Integer id);
    List<Med> getAll();
    List<Med> getByContainName(String name);
    List<String> getOriginByName(String name);
    Map<Integer, String> getOriginById(Integer id);
    List<MedOriginCompoundRelate> getRelateByMed(String name);
    List<MedOriginCompoundRelate> getRelateByMedId(Integer id);
    String getPinyinById(Integer id);
    Integer getHerbById(Integer id);
    List<CompoundSimple> getCompoundByMedId(Integer id);
    String getNameById(Integer id);
}
