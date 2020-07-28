package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Med;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface MedDao extends JpaRepository<Med, String> {
    List<Med> findAll();
    List<Med> findByPinyinLikeOrderByPinyin(String alphabet);
    List<Med> findByNameContaining(String name);
    Med findByName(String name);
    Med findById(Integer id);
}
