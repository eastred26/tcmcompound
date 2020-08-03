package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.DrugDao;
import com.tcm.tcmcompound.pojo.Drug;
import com.tcm.tcmcompound.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DrugServiceImpl implements DrugService {

    @Autowired
    private DrugDao drugDao;

    @Override
    public Drug getById(int id){
        return drugDao.getById(id);
    }
}
