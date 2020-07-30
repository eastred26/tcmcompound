package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.CompoundDao;
import com.tcm.tcmcompound.dao.MedOriginCompoundRelateDao;
import com.tcm.tcmcompound.pojo.Compound;
import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import com.tcm.tcmcompound.service.CompoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CompoundServiceImpl implements CompoundService {
    @Autowired
    private  CompoundDao compoundDao;
    @Autowired
    private  MedOriginCompoundRelateDao medOriginCompoundRelateDao;


    @Override
    public List<Compound> getAll() {
        return compoundDao.findAll();
    }

    @Override
    public Compound getByName(String compoundName) {
        return compoundDao.findByCompoundName(compoundName);
    }

    @Override
    public Compound getById(Integer id) {
        return compoundDao.findById(id);
    }

    @Override
    public List<String> getMedsByName(String compoundName){
        List<MedOriginCompoundRelate> listMedOriginCompoundRelate = medOriginCompoundRelateDao.findByCompoundName(compoundName);
        List<String> allName = new ArrayList<>();
        for (MedOriginCompoundRelate item:listMedOriginCompoundRelate) {
            allName.add(item.getMedicine_name());
        }
        List newList = allName.stream().distinct().collect(Collectors.toList());
        return newList;
    }

    @Override
    public List<String> getOriginsByName(String compoundName){
        List<MedOriginCompoundRelate> listMedOriginCompoundRelate = medOriginCompoundRelateDao.findByCompoundName(compoundName);
        List<String> allName = new ArrayList<>();
        for (MedOriginCompoundRelate item:listMedOriginCompoundRelate) {
            allName.add(item.getOrigin_name());
        }
        List newList = allName.stream().distinct().collect(Collectors.toList());
        return newList;
    }

    @Override
    public Map<Integer, String> getMedsById(Integer id) {
        List<MedOriginCompoundRelate> listMedOriginCompoundRelate = medOriginCompoundRelateDao.findByCompoundId(id);
        Map<Integer, String> allMeds = new LinkedHashMap<>();
        for (MedOriginCompoundRelate item : listMedOriginCompoundRelate) {
            allMeds.put(item.getMedicine_id(), item.getMedicine_name());
        }
        return allMeds;
    }

    @Override
    public Map<Integer, String> getOriginsById(Integer id){
        List<MedOriginCompoundRelate> listMedOriginCompoundRelate = medOriginCompoundRelateDao.findByCompoundId(id);
        Map<Integer, String> allMeds = new LinkedHashMap<>();
        for (MedOriginCompoundRelate item:listMedOriginCompoundRelate) {
            allMeds.put(item.getOrigin_id(), item.getOrigin_name());
        }
        return  allMeds;
    }

    @Override
    public List<String> getAllStructureName(){
        return compoundDao.findAllStructureName();
    }
}
