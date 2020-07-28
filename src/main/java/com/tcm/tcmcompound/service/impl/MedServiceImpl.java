package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.MedDao;
import com.tcm.tcmcompound.dao.MedOriginCompoundRelateDao;
import com.tcm.tcmcompound.dao.MedOriginRelateDao;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import com.tcm.tcmcompound.pojo.MedOriginRelate;
import com.tcm.tcmcompound.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MedServiceImpl implements MedService {
    private final MedDao medDao;
    private final MedOriginRelateDao medOriginRelateDao;
    private final MedOriginCompoundRelateDao medOriginCompoundRelateDao;

    @Autowired
    public MedServiceImpl(MedDao medDao, MedOriginRelateDao medOriginRelateDao, MedOriginCompoundRelateDao medOriginCompoundRelateDao){
        this.medDao = medDao;
        this.medOriginRelateDao = medOriginRelateDao;
        this.medOriginCompoundRelateDao = medOriginCompoundRelateDao;
    }

    @Override
    public List<String> getAllName(){
        List<Med> listMed = medDao.findAll();
        List<String> allName = new ArrayList<>();
        for(Med item:listMed)
            allName.add(item.getName());
        return allName;
    }

    @Override
    public Map<Integer, String> getAllName(String alphabet){
        String str = alphabet + '%';
        List<Med> listMed = medDao.findByPinyinLikeOrderByPinyin(str);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for(Med item:listMed) {
            allName.put(item.getId(), item.getName());
        }
        return allName;
    }

    @Override
    public Med getByName(String name) {
        return medDao.findByName(name);
    }

    @Override
    public Med getById(Integer id) {
        return medDao.findById(id);
    }

    @Override
    public List<Med> getAll() {
        return medDao.findAll();
    }

    @Override
    public List<Med> getByContainName(String name) {
        return medDao.findByNameContaining(name);
    }

    @Override
    public List<String> getOriginByName(String name){
        List<MedOriginRelate> listMedOriginRelate = medOriginRelateDao.findByMedicineName(name);
        List<String> allName = new ArrayList<>();
        for (MedOriginRelate item:listMedOriginRelate) {
            allName.add(item.getOriginNameZh());
        }
        return allName;
    }

    @Override
    public Map<Integer, String> getOriginById(Integer id){
        List<MedOriginRelate> listMedOriginRelate = medOriginRelateDao.findByMedicineId(id);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for (MedOriginRelate item:listMedOriginRelate) {
            allName.put(item.getOriginId(), item.getOriginNameZh());
        }
        return allName;
    }

    @Override
    public List<MedOriginCompoundRelate> getRelateByMed(String name){
        return new ArrayList<>(medOriginCompoundRelateDao.findByMedicineName(name));
    }

    @Override
    public List<MedOriginCompoundRelate> getRelateByMedId(Integer id){
        return new ArrayList<>(medOriginCompoundRelateDao.findByMedicineId(id));
    }
}
