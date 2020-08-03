package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.*;
import com.tcm.tcmcompound.pojo.MedOrigin;
import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import com.tcm.tcmcompound.pojo.MedOriginRelate;
import com.tcm.tcmcompound.service.CompoundService;
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
    private MedDao medDao;
    @Autowired
    private CompoundService compoundService;
    @Autowired
    private  MedOriginRelateDao medOriginRelateDao;
    @Autowired
    private  MedOriginCompoundRelateDao medOriginCompoundRelateDao;
    @Autowired
    private IngredientDao ingredientDao;

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
    public Map<Integer, String> getGraphMedById(Integer id){
        List<MedOriginRelate> listMedOriginRelate = medOriginRelateDao.findById(id);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for (MedOriginRelate item:listMedOriginRelate) {
            int mid=item.getMedicine_id();
            Integer hid=medDao.findHerbById(mid);
            if(hid!=null){
                allName.put(hid.intValue(), item.getMedicine_name());
            }
            else
            allName.put(-mid, item.getMedicine_name());
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
    @Override
    public String getNameById(Integer id){
        return medOriginDao.findNameById(id);
    }
    @Override
    public Map<Integer, String> getCompoundById(Integer id){
        List<MedOriginCompoundRelate> listMedOriginCompoundRelate=medOriginCompoundRelateDao.findByOriginId(id);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for (MedOriginCompoundRelate item:listMedOriginCompoundRelate) {
            int cid=item.getCompound_id();
            String iid_s=compoundService.getIngredient(cid);
            if(iid_s==null)allName.put(-cid, item.getCompound_name());
            else {
                int iid=Integer.parseInt(iid_s);
                allName.put(iid,ingredientDao.getIngredientName(iid));
            }
        }
        return allName;
    }
}
