package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.HerbDao;
import com.tcm.tcmcompound.dao.IngredientDao;
import com.tcm.tcmcompound.dao.PrescriptionDao;
import com.tcm.tcmcompound.pojo.HerbName;
import com.tcm.tcmcompound.pojo.Med;
import com.tcm.tcmcompound.pojo.MedOriginRelate;
import com.tcm.tcmcompound.pojo.Prescription;
import com.tcm.tcmcompound.service.PrescriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class PrescriptionServiceImpl implements PrescriptionService {
    @Autowired
    private PrescriptionDao prescriptionDao;
    @Autowired
    private HerbDao herbDao;
    @Autowired
    private IngredientDao ingredientDao;

    @Override
    public List<String> getAllName(){
        List<Prescription> listMed = prescriptionDao.findAll();
        List<String> allName = new ArrayList<>();
        for(Prescription item:listMed)
            allName.add(item.getChinese_name());
        return allName;
    }
    @Override
    public Map<Integer, String> getHerbById(Integer id){
        Map<Integer, String> allName = new LinkedHashMap<>();
        String ss=prescriptionDao.findHerbById(id);
        if(ss==null)return allName;
        String []hids = ss.trim().split("\\s+");
        for(String item:hids){
            int hid=Integer.parseInt(item);
            HerbName herbName=herbDao.getHerbName(hid);
            allName.put(hid,herbName.getName());
        }
        return allName;
    }
    @Override
    public Map<Integer, String> getIngredientById(Integer id){
        Map<Integer, String> allName = new LinkedHashMap<>();
        String ss=prescriptionDao.findIngredientsById(id);
        if(ss==null)return allName;
        String []iids=ss.trim().split("\\s+");
        for(String item:iids){
            int iid=Integer.parseInt(item);
            String name=ingredientDao.getIngredientName(iid);
            allName.put(iid,name);
        }
        return allName;
    }

    @Override
    public String getHerbStringById(Integer id){
        return prescriptionDao.findHerbById(id);
    }

    @Override
    public Map<Integer, String> getAllName(String alphabet){
        String str = "^"+alphabet;
        List<Prescription> listMed = prescriptionDao.findByPinyinLikeOrderByPinyin(str);
        Map<Integer, String> allName = new LinkedHashMap<>();
        for(Prescription item:listMed) {
            allName.put(item.getId(), item.getChinese_name());
        }
        return allName;
    }

    @Override
    public String getNameById(Integer id){
        return prescriptionDao.findNameById(id);
    }

    @Override
    public Prescription getByName(String name) {
        return prescriptionDao.findByName(name);
    }

    @Override
    public Prescription getById(Integer id) {
        return prescriptionDao.findById(id);
    }

    @Override
    public List<Prescription> getAll() {
        return prescriptionDao.findAll();
    }

    @Override
    public List<Prescription> getByContainName(String name) {
        return prescriptionDao.findByNameContaining(name);
    }

}
