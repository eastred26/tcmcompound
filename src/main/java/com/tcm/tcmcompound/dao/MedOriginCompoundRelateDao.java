package com.tcm.tcmcompound.dao;
import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
public interface MedOriginCompoundRelateDao extends JpaRepository<MedOriginCompoundRelate, String> {
    List<MedOriginCompoundRelate> findAll();
    List<MedOriginCompoundRelate> findByCompoundName(String name);
    List<MedOriginCompoundRelate> findByCompoundId(Integer id);
    List<MedOriginCompoundRelate> findByOriginId(Integer id);
    List<MedOriginCompoundRelate> findByMedicineId(Integer id);
    List<MedOriginCompoundRelate> findByMedicineName(String name);
    List<MedOriginCompoundRelate> findByOriginName(String name);
}
