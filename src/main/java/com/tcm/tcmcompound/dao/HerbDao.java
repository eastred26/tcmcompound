package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Herb;
import com.tcm.tcmcompound.pojo.HerbName;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

@Component
public interface HerbDao {
    @Select("SELECT pinyin_name,chinese_name,latin_name FROM herb WHERE ID=#{id}")
    @Results({
            @Result(property = "pinyinName", column = "pinyin_name"),
            @Result(property = "chineseName", column = "chinese_name"),
            @Result(property = "latinName", column = "latin_name")
    })
    HerbName getHerbName(Integer id);

    @Select("SELECT Ingredient_ID FROM herb_ingredient WHERE ID=#{id}")
    String getIngredients(Integer id);
    @Select("SELECT * FROM herb WHERE ID=${id}")
    Herb findById(Integer id);
}
