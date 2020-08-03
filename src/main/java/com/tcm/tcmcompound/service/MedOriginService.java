package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.pojo.MedOrigin;
import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;

import java.util.List;
import java.util.Map;

public interface MedOriginService {
    Map<Integer, String> getAllName(String alphabet);
    List<MedOrigin> getAll();
    List<MedOrigin> getByNameContaining(String name);
    List<String> getMedByName(String name);
    Map<Integer, String> getMedById(Integer id);
    Map<Integer, String> getCompoundById(Integer id);
    MedOrigin getByName(String name);
    MedOrigin getById(Integer id);
    List<MedOriginCompoundRelate> getRelateByOrigin(String name);
    List<MedOriginCompoundRelate> getRelateByOriginId(Integer id);
    String getNameById(Integer id);
    Map<Integer, String> getGraphMedById(Integer id);
}
