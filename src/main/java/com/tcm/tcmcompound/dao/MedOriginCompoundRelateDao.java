package com.tcm.tcmcompound.dao;
import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public interface MedOriginCompoundRelateDao {
    @Select("SELECT * FROM medicine_origin_compound_map")
    List<MedOriginCompoundRelate> findAll();
    @Select("SELECT * FROM medicine_origin_compound_map WHERE compound_name=#{name}")
    List<MedOriginCompoundRelate> findByCompoundName(String name);
    @Select("SELECT * FROM medicine_origin_compound_map WHERE compound_id=${id}")
    List<MedOriginCompoundRelate> findByCompoundId(Integer id);
    @Select("SELECT * FROM medicine_origin_compound_map WHERE origin_id=${id}")
    List<MedOriginCompoundRelate> findByOriginId(Integer id);
    @Select("SELECT * FROM medicine_origin_compound_map WHERE medicine_id=${id}")
    List<MedOriginCompoundRelate> findByMedicineId(Integer id);
    @Select("SELECT * FROM medicine_origin_compound_map WHERE medicine_name=#{name}")
    List<MedOriginCompoundRelate> findByMedicineName(String name);
    @Select("SELECT * FROM medicine_origin_compound_map WHERE origin_name=#{name}")
    List<MedOriginCompoundRelate> findByOriginName(String name);
}
