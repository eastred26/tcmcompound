package com.tcm.tcmcompound.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Herb {
    private int ID;
    private String pinyin_name;
    private String chinese_name;
    private String english_name;
    private String latin_name;
    private String properties;//属性
    private String meridians;//器官
    private String use_part;//使用部分
    private String effect;//作用
    private String indication;//适应症
}
