package com.tcm.tcmcompound.pojo;

import lombok.Builder;
import lombok.Data;

import javax.persistence.*;

@Data
@Builder
public class Prescription {
    private int id;
    private String pinyin_name;
    private String chinese_name;
    private String composition;
    private String indication;
    private String use_method;
    private String reference;

}
