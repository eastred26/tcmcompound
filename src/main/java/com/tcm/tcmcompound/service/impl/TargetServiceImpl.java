package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.*;
import com.tcm.tcmcompound.pojo.Disease;
import com.tcm.tcmcompound.pojo.Drug;
import com.tcm.tcmcompound.pojo.IngredientSimple;
import com.tcm.tcmcompound.pojo.Target;
import com.tcm.tcmcompound.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class TargetServiceImpl implements TargetService {
    @Autowired
    private TargetDao targetDao;

    @Autowired
    private DiseaseDao diseaseDao;
    @Autowired
    private DrugDao drugDao;

    @Autowired
    private IngredientDao ingredientDao;
    @Autowired
    private HerbDao herbDao;

    @Override
    public Target getById(Integer id){
        return targetDao.findById(id);
    }
    @Override
    public Map<Integer, String> getDiseaseById(Integer id){
        Map<Integer, String> allName = new LinkedHashMap<>();
        String s=targetDao.findOmimById(id);
        //System.out.println(s);
        if(!s.equals("NA")){
            String []items=s.split(";");
            for(String item:items){
                Disease disease=diseaseDao.getByOMIM(item);
                allName.put(disease.getID(),disease.getName());
            }
        }
        if(allName.isEmpty())return null;
        return allName;
    }
    @Override
    public Map<Integer, String> getDrugById(Integer id){
        Map<Integer, String> allName = new LinkedHashMap<>();
        String s=targetDao.findDrugbankById(id);
        if(!s.equals("NA")){
            String []items=s.split(";");
            for(String item:items){
                Drug drug=drugDao.getByDrugbank(item);
                allName.put(drug.getID(),drug.getName());
            }
        }
        if(allName.isEmpty())return null;
        return allName;
    }
    @Override
    public Map<Integer, String> getIngredientsById(Integer tid){
        Map<Integer, String> allName = new LinkedHashMap<>();
        List<IngredientSimple> list= targetDao.getIngredientsById(tid);
        for(IngredientSimple item:list){
            allName.put(item.getIngredient_id(),item.getIngredient_name());
        }
        if(allName.isEmpty())return null;
        return allName;
    }
    @Override
    public Map<Integer, String> getHerbsById(Integer tid){
        List<IngredientSimple> list= targetDao.getIngredientsById(tid);
        Map<Integer, String> allName = new LinkedHashMap<>();
        Set<Integer> set=new HashSet<>();
        for(IngredientSimple item:list){
            List<Integer> list1=ingredientDao.getHerbsByName(item.getIngredient_id());
            for(int item1:list1){
                if(set.contains(item1))continue;
                set.add(item1);
                allName.put(item1,herbDao.getHerbName(item1).getName());
            }
        }
        if(allName.isEmpty())return null;
        return allName;
    }
}
