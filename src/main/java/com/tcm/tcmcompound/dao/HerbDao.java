package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Herb;
import com.tcm.tcmcompound.pojo.HerbName;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface HerbDao {
    @Select("SELECT pinyin_name,chinese_name,latin_name,english_name FROM herb WHERE ID=#{id}")
    @Results({
            @Result(property = "pinyinName", column = "pinyin_name"),
            @Result(property = "chineseName", column = "chinese_name"),
            @Result(property = "latinName", column = "latin_name"),
            @Result(property = "englishName", column = "english_name")
    })
    HerbName getHerbName(Integer id);

    @Select("SELECT Ingredient_ID FROM herb_ingredient WHERE ID=#{id}")
    String getIngredients(Integer id);
    @Select("SELECT * FROM herb WHERE ID=${id}")
    Herb findById(Integer id);
    @Select("SELECT pinyin_name FROM herb WHERE ID=${id}")
    String findPinyinById(Integer id);
    @Select("SELECT Med_ID FROM herb_med WHERE Herb_ID=${id}")
    Integer findMedById(Integer id);
    @Select("SELECT Prescription_ID FROM prescription_herb_item WHERE Herb_ID=${id}")
    List<Integer> findPrescriptionById(Integer id);
    @Select(("SELECT tcm_id FROM herb_tcm WHERE herb_id=${id}"))
    Integer getTcmIdById(Integer id);
}
