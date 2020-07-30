package com.tcm.tcmcompound.pojo;
import lombok.Data;

import javax.persistence.*;

@Data
public class MedOriginCompoundRelate {
    private int id;
    private Integer medicine_id;
    private String medicine_name;
    private Integer origin_id;
    private String origin_name;
    private String origin_latin;
    private Integer compound_id;
    private String compound_name;
    private String CAS;
    private String zju_id;
    private String formula;
    private String molecular_weight;

}
