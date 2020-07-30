package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.MedOriginCompoundRelateDao;
import com.tcm.tcmcompound.dao.MedOriginDao;
import com.tcm.tcmcompound.dao.MedOriginRelateDao;
import com.tcm.tcmcompound.pojo.MedOrigin;
import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import com.tcm.tcmcompound.pojo.MedOriginRelate;
import com.tcm.tcmcompound.service.MedOriginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class MedOriginServiceImpl implements MedOriginService {
    @Autowired
    private  MedOriginDao medOriginDao;
    @Autowired
    private  MedOriginRelateDao medOriginRelateDao;
    @Autowired
    private  MedOriginCompoundRelateDao medOriginCompoundRelateDao;

    @Override
    public Map<Integer, String> getAllName(String alphabet) {
        String str = "^"+alphabet;
        List<MedOrigin> medOriginList = medOriginDao.findByPinyinLikeOrderByPinyin(str);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for(MedOrigin item:medOriginList) {
            allName.put(item.getId(), item.getName());
        }
        return allName;
    }

    @Override
    public List<MedOrigin> getAll() {
        return medOriginDao.findAll();
    }

    @Override
    public List<MedOrigin> getByNameContaining(String name) {
        return medOriginDao.findByNameContaining(name);
    }

    @Override
    public MedOrigin getByName(String medName) {
        return medOriginDao.findByName(medName);
    }

    @Override
    public MedOrigin getById(Integer id) {
        return medOriginDao.findById(id);
    }

    @Override
    public List<String> getMedByName(String name){
        List<MedOriginRelate> listMedOriginRelate = medOriginRelateDao.findByOriginNameZh(name);
        List<String> allName = new ArrayList<>();
        for (MedOriginRelate item:listMedOriginRelate) {
            allName.add(item.getMedicine_name());
        }
        return allName;
    }

    @Override
    public Map<Integer, String> getMedById(Integer id){
        List<MedOriginRelate> listMedOriginRelate = medOriginRelateDao.findById(id);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for (MedOriginRelate item:listMedOriginRelate) {
            allName.put(item.getMedicine_id(), item.getMedicine_name());
        }
        return allName;
    }

    @Override
    public List<MedOriginCompoundRelate> getRelateByOrigin(String name){
        return new ArrayList<>(medOriginCompoundRelateDao.findByOriginName(name));
    }

    @Override
    public List<MedOriginCompoundRelate> getRelateByOriginId(Integer id){
        return new ArrayList<>(medOriginCompoundRelateDao.findByOriginId(id));
    }
}
