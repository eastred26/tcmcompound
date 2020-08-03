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
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MedServiceImpl implements MedService {
    @Autowired
    private  MedDao medDao;
    @Autowired
    private  MedOriginRelateDao medOriginRelateDao;
    @Autowired
    private  MedOriginCompoundRelateDao medOriginCompoundRelateDao;

    @Override
    public String getPinyinById(Integer id){
        return medDao.findPinyinById(id);
    }
    @Override
    public Integer getHerbById(Integer id){
        return medDao.findHerbById(id);
    }
    @Override
    public List<String> getAllName(){
        List<Med> listMed = medDao.findAll();
        List<String> allName = new ArrayList<>();
        for(Med item:listMed)
            allName.add(item.getMed_name_zh());
        return allName;
    }

    @Override
    public Map<Integer, String> getAllName(String alphabet){
        String str = "^"+alphabet;
        List<Med> listMed = medDao.findByPinyinLikeOrderByPinyin(str);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for(Med item:listMed) {
            allName.put(item.getId(), item.getMed_name_zh());
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
            allName.add(item.getOrigin_name_zh());
        }
        return allName;
    }

    @Override
    public Map<Integer, String> getOriginById(Integer id){
        List<MedOriginRelate> listMedOriginRelate = medOriginRelateDao.findByMedicineId(id);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for (MedOriginRelate item:listMedOriginRelate) {
            allName.put(item.getOrigin_id(), item.getOrigin_name_zh());
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
