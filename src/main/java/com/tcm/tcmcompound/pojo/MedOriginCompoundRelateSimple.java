package com.tcm.tcmcompound.pojo;
import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
public class MedOriginCompoundRelateSimple {
    private Integer medicine_id;
    private String medicine_name;
    private Integer compound_id;
    private String compound_name;
    private String formula;
    public MedOriginCompoundRelateSimple(Integer medicine_id,String medicine_name,Integer compound_id,String compound_name,String formula){
        this.medicine_id=medicine_id;
        this.medicine_name=medicine_name;
        this.compound_id=compound_id;
        this.compound_name=compound_name;
        this.formula=formula;
    }
}
