package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Med;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MedDao {
    @Select("SELECT * FROM med_yaodian")
    List<Med> findAll();
    @Select("SELECT * FROM med_yaodian WHERE med_name_pinyin REGEXP #{alphabet} ORDER BY med_name_pinyin")
    List<Med> findByPinyinLikeOrderByPinyin(String alphabet);
    @Select("SELECT * FROM med_yaodian WHERE med_name_zh REGEXP #{name} ORDER BY med_name_pinyin")
    List<Med> findByNameContaining(String name);
    @Select("SELECT * FROM med_yaodian WHERE med_name_zh=#{name}")
    Med findByName(String name);
    @Select("SELECT * FROM med_yaodian WHERE id=${id}")
    Med findById(Integer id);
    @Select("SELECT med_name_pinyin FROM med_yaodian WHERE id=${id}")
    String findPinyinById(Integer id);
    @Select("SELECT med_name_zh FROM med_yaodian WHERE id=${id}")
    String findNameById(Integer id);
    @Select("SELECT Herb_ID FROM herb_med WHERE Med_ID=${id}")
    Integer findHerbById(Integer id);
}
