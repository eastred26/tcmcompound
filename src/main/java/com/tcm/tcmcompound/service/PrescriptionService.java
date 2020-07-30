package com.tcm.tcmcompound.service;

import com.tcm.tcmcompound.dao.PrescriptionDao;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.pojo.Prescription;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

public interface PrescriptionService {
    List<String> getAllName();
    Map<Integer, String> getAllName(String alphabet);
    Prescription getByName(String name);
    Prescription getById(Integer id);
    List<Prescription> getAll();
    List<Prescription> getByContainName(String name);
    Map<Integer, String> getHerbById(Integer id);
    String getNameById(Integer id);
    String getHerbStringById(Integer id);
    Map<Integer, String> getIngredientById(Integer id);
}
