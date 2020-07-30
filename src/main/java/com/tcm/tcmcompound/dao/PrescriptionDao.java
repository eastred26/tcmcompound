package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.MedOrigin;
import com.tcm.tcmcompound.pojo.Prescription;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface PrescriptionDao {
    @Select("SELECT * FROM prescription")
    List<Prescription> findAll();
    @Select("SELECT * FROM prescription WHERE pinyin_name REGEXP #{alphabet}")
    List<Prescription> findByPinyinLikeOrderByPinyin(String alphabet);
    @Select("SELECT * FROM prescription WHERE chinese_name REGEXP #{name}")
    List<Prescription> findByNameContaining(String name);
    @Select("SELECT * FROM prescription WHERE chinese_name=#{name}")
    Prescription findByName(String name);
    @Select("SELECT * FROM prescription WHERE id=${id}")
    Prescription findById(Integer id);
    @Select("SELECT Herb_ID FROM prescription_herb WHERE ID=${id}")
    String findHerbById(Integer id);

    @Select("SELECT ingredients FROM prescription_ingredient WHERE ID=${id}")
    String findIngredientsById(Integer id);
    @Select("SELECT chinese_name FROM prescription WHERE id=${id}")
    String findNameById(Integer id);
}
