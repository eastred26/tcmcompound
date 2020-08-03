package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Drug;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface DrugDao {
    @Select("SELECT * FROM drug WHERE Drugbank_Access_No='${id}'")
    Drug getByDrugbank(String id);
    @Select("SELECT * FROM drug WHERE ID=#{id}")
    Drug getById(Integer id);
}
