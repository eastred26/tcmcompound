package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Target;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface UtilDao {
    @Select("SELECT med_name_zh FROM med_basic WHERE med_id=${id}")
     String finds(Integer id);
}
