package com.tcm.tcmcompound.dao;
import com.tcm.tcmcompound.pojo.MedOriginRelate;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedOriginRelateDao extends JpaRepository<MedOriginRelate, String> {
    List<MedOriginRelate> findAll();
    List<MedOriginRelate> findByMedicineName(String medicineName);
    List<MedOriginRelate> findByMedicineId(Integer medicineId);
    List<MedOriginRelate> findByOriginNameZh(String name);
    List<MedOriginRelate> findById(Integer id);
}
