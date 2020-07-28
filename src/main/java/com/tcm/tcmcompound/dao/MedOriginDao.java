package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.MedOrigin;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedOriginDao extends JpaRepository<MedOrigin, String> {
    List<MedOrigin> findAll();
    List<MedOrigin> findByPinyinLikeOrderByPinyin(String alphabet);
    List<MedOrigin> findByNameContaining(String name);
    MedOrigin findByName(String name);
    MedOrigin findById(Integer id);
}
