package com.tcm.tcmcompound.dao;

import com.tcm.tcmcompound.pojo.Compound;
import org.apache.ibatis.annotations.Select;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CompoundDao{
    @Select("SELECT * FROM compound")
    List<Compound> findAll();
    @Select("SELECT * FROM compound WHERE compound_name=#{name}")
    Compound findByCompoundName(String name);
    @Select("SELECT * FROM compound WHERE id=${id}")
    Compound findById(Integer id);
    @Select("select distinct structure from compound where structure != '' ORDER BY CONVERT(structure using gbk)")
    List<String> findAllStructureName();
    @Select("SELECT Pubchem_ID FROM cas_pubchem WHERE Compound_ID=#{id}")
    String findPubchemById(Integer id);
}
