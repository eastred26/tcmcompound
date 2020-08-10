package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.HerbDao;
import com.tcm.tcmcompound.dao.IngredientDao;
import com.tcm.tcmcompound.dao.PrescriptionDao;
import com.tcm.tcmcompound.dao.TargetDao;
import com.tcm.tcmcompound.pojo.Herb;
import com.tcm.tcmcompound.pojo.HerbName;
import com.tcm.tcmcompound.pojo.Ingredient;
import com.tcm.tcmcompound.service.HerbService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class HerbServiceImpl implements HerbService {
    @Autowired
    private HerbDao herbDao;
    @Autowired
    private IngredientDao ingredientDao;

    @Autowired
    private PrescriptionDao prescriptionDao;
    @Autowired
    private TargetDao targetDao;
    @Override
    public String getNamebyId(int id){
        HerbName herbName=herbDao.getHerbName(id);
        return herbName.getName();
    }
    @Override
    public String getIngredientsbyId(int id){
        return herbDao.getIngredients(id);
    }

    @Override
    public Integer getMedById(Integer id){
        return herbDao.findMedById(id);
    }

    @Override
    public Herb getById(int id){
        return herbDao.findById(id);
    }
    @Override
    public Integer getTcmIdById(Integer id){
        return herbDao.getTcmIdById(id);
    }
    @Override
    public Map<Integer, String> getIngredientById(Integer id){
        Map<Integer, String> allName = new LinkedHashMap<>();
        String ss=herbDao.getIngredients(id);
        if(ss==null)return allName;
        String []iids=ss.trim().split("\\s+");
        for(String item:iids){
            int iid=Integer.parseInt(item);
            String name=ingredientDao.getIngredientName(iid);
            allName.put(iid,name);
        }
        if(allName.isEmpty())return null;
        return allName;
    }
    @Override
    public Map<Integer, String> getTargetById(Integer id){
        Map<Integer, String> allName = new LinkedHashMap<>();
        String ss=herbDao.getIngredients(id);
        if(ss==null)return allName;
        String []iids=ss.trim().split("\\s+");
        Set<String> set=new HashSet<>();
        for(String item:iids){
            int iid=Integer.parseInt(item);
            String name=ingredientDao.getIngredientName(iid);
            List<String> list=ingredientDao.getTargetsByName(name);
            for(String item1:list){
                if(set.contains(item1))continue;
                else set.add(item1);
                if(item1.equals("NA"))continue;
                Integer tid=Integer.parseInt(item1);
                allName.put(tid,targetDao.findNameById(tid));
            }
        }
        if(allName.isEmpty())return  null;
        return allName;
    }
    @Override
    public String getPinyinById(int id){
        return herbDao.findPinyinById(id);
    }
    @Override
    public Map<Integer, String> findPrescriptionById(Integer id){
        Map<Integer, String> allName = new LinkedHashMap<>();
        List<Integer> ss=herbDao.findPrescriptionById(id);
        for(int item:ss){
            String name=prescriptionDao.findNameById(item);
            allName.put(item,name);
        }
        if(allName.isEmpty())return  null;
        return allName;
    }
}
