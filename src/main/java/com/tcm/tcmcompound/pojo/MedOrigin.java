package com.tcm.tcmcompound.pojo;
import lombok.Data;

import javax.persistence.*;

@Data
public class MedOrigin {
    private int id;
    private String name;
    private String pinyin;
    private String latin_name;
    private String named_people;
    private String family;
    private Integer plant_id;
    private String complete_name;
    private String intro_1;
    private String intro_2;
    private String appearance;
    private String location;
    private String intro_3;
    private String med_info_flora;
    private String med_info_yaoyong;
    private String complete_intro;
    private String pdfinfo;
    private String hierarchy;


}
