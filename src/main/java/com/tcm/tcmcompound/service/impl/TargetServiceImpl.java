package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.DiseaseDao;
import com.tcm.tcmcompound.dao.DrugDao;
import com.tcm.tcmcompound.dao.TargetDao;
import com.tcm.tcmcompound.pojo.Disease;
import com.tcm.tcmcompound.pojo.Drug;
import com.tcm.tcmcompound.pojo.Target;
import com.tcm.tcmcompound.service.TargetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashMap;
import java.util.Map;

@Service
public class TargetServiceImpl implements TargetService {
    @Autowired
    private TargetDao targetDao;

    @Autowired
    private DiseaseDao diseaseDao;
    @Autowired
    private DrugDao drugDao;

    @Override
    public Target getById(Integer id){
        return targetDao.findById(id);
    }
    @Override
    public Map<Integer, String> getDiseaseById(Integer id){
        Map<Integer, String> allName = new LinkedHashMap<>();
        String s=targetDao.findOmimById(id);
        System.out.println(s);
        if(!s.equals("NA")){
            String []items=s.split(";");
            for(String item:items){
                Disease disease=diseaseDao.getByOMIM(item);
                allName.put(disease.getID(),disease.getName());
            }
        }
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
        return allName;
    }
}
