package com.tcm.tcmcompound.dao;
import com.tcm.tcmcompound.pojo.MedOriginRelate;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface MedOriginRelateDao  {
    @Select("SELECT * FROM medicine_origin_map")
    List<MedOriginRelate> findAll();
    @Select("SELECT * FROM medicine_origin_map WHERE medicine_name=#{medicineName}")
    List<MedOriginRelate> findByMedicineName(String medicineName);
    @Select("SELECT * FROM medicine_origin_map WHERE medicine_id=#{medicineId}")
    List<MedOriginRelate> findByMedicineId(Integer medicineId);
    @Select("SELECT * FROM medicine_origin_map WHERE origin_name_zh=#{name}")
    List<MedOriginRelate> findByOriginNameZh(String name);
    @Select("SELECT * FROM medicine_origin_map WHERE origin_id=${id}")
    List<MedOriginRelate> findById(Integer id);
}
