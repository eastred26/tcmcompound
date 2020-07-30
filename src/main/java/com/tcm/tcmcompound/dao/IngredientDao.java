package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Ingredient;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface IngredientDao {
    @Select("SELECT Name FROM ingredient WHERE ID=#{id}")
    String getIngredientName(Integer id);
    @Select("SELECT * FROM ingredient WHERE ID=#{id}")
    Ingredient getIngredientById(Integer id);
}
