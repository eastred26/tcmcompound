package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Disease;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface DiseaseDao {
    @Select("SELECT * FROM disease WHERE OMIM_ID='${id}'")
    Disease getByOMIM(String id);
    @Select("SELECT * FROM disease WHERE ID=#{id}")
    Disease getById(Integer id);
}
