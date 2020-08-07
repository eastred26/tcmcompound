package com.tcm.tcmcompound.pojo;

import lombok.Data;

@Data
public class HerbName {
    private String pinyinName;
    private String latinName;
    private String chineseName;
    private String englishName;

    public String getName(){
        if(chineseName.equals("NA")){
            if(pinyinName.equals("NA")){
                if(englishName.equals("NA")){
                    return latinName;
                }
                return englishName;
            }
            return pinyinName;
        }
        return chineseName;
    }
}
