package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.CompoundDao;
import com.tcm.tcmcompound.dao.HerbDao;
import com.tcm.tcmcompound.dao.IngredientDao;
import com.tcm.tcmcompound.dao.TargetDao;
import com.tcm.tcmcompound.pojo.Ingredient;
import com.tcm.tcmcompound.service.IngredientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Service
public class IngredientServiceImpl implements IngredientService {
    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private TargetDao targetDao;
    @Autowired
    private HerbDao herbDao;
    @Override
    public String getNamebyId(int id){
        return ingredientDao.getIngredientName(id);
    }
    @Override
    public Ingredient getIngredientById(int id){
        return ingredientDao.getIngredientById(id);
    }
    @Override
    public String getCompound(String pubchem_id){
        if(pubchem_id.equals("NA"))return null;
        return ingredientDao.getCompound(pubchem_id);
    }
    @Override
    public Map<Integer, String> getTargetsByName(String name){
        Map<Integer, String> allName = new LinkedHashMap<>();
        List<String> list=ingredientDao.getTargetsByName(name);
        for(String item:list){
            if(item.equals("NA"))continue;
            Integer tid=Integer.parseInt(item);
            allName.put(tid,targetDao.findNameById(Integer.parseInt(item)));
        }
        if(allName.isEmpty())return null;
        return allName;
    }
    @Override
    public Map<Integer,String> getHerbsById(Integer iid){
        Map<Integer, String> allName = new LinkedHashMap<>();
        List<Integer> list = ingredientDao.getHerbsByName(iid);
        for(int item:list){
            allName.put(item,herbDao.getHerbName(item).getName());
        }
        if(allName.isEmpty())return  null;
        return allName;
    }
}
