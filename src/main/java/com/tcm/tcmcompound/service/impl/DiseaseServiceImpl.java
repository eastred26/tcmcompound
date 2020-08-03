package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.dao.DiseaseDao;
import com.tcm.tcmcompound.pojo.Disease;
import com.tcm.tcmcompound.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DiseaseServiceImpl implements DiseaseService {
    @Autowired
    private DiseaseDao diseaseDao;

    @Override
    public Disease getById(int id){
        return diseaseDao.getById(id);
    }
}
