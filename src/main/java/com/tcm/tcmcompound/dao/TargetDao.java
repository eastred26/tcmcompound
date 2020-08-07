package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.IngredientSimple;
import com.tcm.tcmcompound.pojo.Prescription;
import com.tcm.tcmcompound.pojo.Target;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface TargetDao {
    @Select("SELECT * FROM target")
    List<Target> findAll();
    @Select("SELECT * FROM target WHERE ID=${id}")
    Target findById(Integer id);
    @Select("SELECT omim_id FROM ingredient_targets_disease_drug WHERE target_id=${id} LIMIT 0,1")
    String findOmimById(Integer id);
    @Select("SELECT drugbank_id FROM ingredient_targets_disease_drug WHERE target_id=${id} LIMIT 0,1")
    String findDrugbankById(Integer id);
    @Select("SELECT Name FROM target WHERE ID=${id}")
    String findNameById(Integer id);
    @Select("SELECT ingredient_name,ingredient_id FROM ingredient_targets_disease_drug WHERE target_id='${tid}'")
    List<IngredientSimple> getIngredientsById(Integer tid);
}
