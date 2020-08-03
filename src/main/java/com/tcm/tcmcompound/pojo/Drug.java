package com.tcm.tcmcompound.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Drug {
    private int ID;
    private String Name;
    private String Drugbank_Access_No;
    private String Drug_Type;
}
