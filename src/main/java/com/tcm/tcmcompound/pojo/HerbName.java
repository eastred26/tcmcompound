package com.tcm.tcmcompound.pojo;

import lombok.Data;

@Data
public class HerbName {
    private String pinyinName;
    private String latinName;
    private String chineseName;

    public String getName(){
        if(chineseName.equals("NA")){
            if(pinyinName.equals("NA")){
                return latinName;
            }
            return pinyinName;
        }
        return chineseName;
    }
}
