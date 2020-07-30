package com.tcm.tcmcompound.pojo;
import lombok.Data;

import javax.persistence.*;

@Data
public class MedOriginRelate {
    private int id;
    private Integer origin_id;
    private String origin_name_zh;
    private String origin_name_latin;
    private String origin_name_latin_people;
    private String medicine_name;
    private Integer medicine_id;
}
