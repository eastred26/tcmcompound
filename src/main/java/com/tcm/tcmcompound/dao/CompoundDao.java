package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Compound;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CompoundDao extends JpaRepository<Compound, String> {
    List<Compound> findAll();
    Compound findByCompoundName(String name);
    Compound findById(Integer id);
    @Query(nativeQuery = true, value = "select distinct structure from compound where structure != '' ORDER BY CONVERT(structure using gbk)")
    List<String> findAllStructureName();
}
