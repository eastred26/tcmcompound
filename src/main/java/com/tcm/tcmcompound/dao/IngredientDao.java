package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Ingredient;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface IngredientDao {
    @Select("SELECT Name FROM ingredient WHERE ID=#{id}")
    String getIngredientName(Integer id);
    @Select("SELECT * FROM ingredient WHERE ID=#{id}")
    Ingredient getIngredientById(Integer id);
    @Select("SELECT Compound_ID FROM cas_pubchem WHERE Pubchem_ID=#{pubchem_id} LIMIT 0,1")
    String getCompound(String pubchem_id);
    @Select("SELECT ID FROM ingredient WHERE Pubchem_ID=${id} LIMIT 0,1")
    String getIdBypubchem(String id);
    @Select("SELECT target_id FROM ingredient_targets_disease_drug WHERE ingredient_name=#{name}")
    List<String> getTargetsByName(String name);
}
