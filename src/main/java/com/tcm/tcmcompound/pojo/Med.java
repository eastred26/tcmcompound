package com.tcm.tcmcompound.pojo;
import lombok.Data;

import javax.persistence.*;

@Data
public class Med {
    private int id;
    private String med_name_zh;
    private String med_name_pinyin;
    private String med_name_latin;
    private String med_origin;
    private String med_store;
    private String med_property;
    private String med_tropisw;
    private String med_function;
    private Integer tcm_id;
    private String tcm_name;
    private String source;


}
