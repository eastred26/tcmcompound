package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.MedOrigin;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MedOriginDao {
    @Select("SELECT * FROM origin")
    List<MedOrigin> findAll();
    @Select("SELECT * FROM origin WHERE pinyin REGEXP #{alphabet}")
    List<MedOrigin> findByPinyinLikeOrderByPinyin(String alphabet);
    @Select("SELECT * FROM origin WHERE name REGEXP #{name}")
    List<MedOrigin> findByNameContaining(String name);
    @Select("SELECT * FROM origin WHERE name=#{name}")
    MedOrigin findByName(String name);
    @Select("SELECT * FROM origin WHERE id=${id}")
    MedOrigin findById(Integer id);
    @Select("SELECT name FROM origin WHERE id=${id}")
    String findNameById(Integer id);
}
