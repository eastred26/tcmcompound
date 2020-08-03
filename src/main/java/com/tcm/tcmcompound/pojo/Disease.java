package com.tcm.tcmcompound.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Disease {
    private int ID;
    private String Name;
    private String OMIM_ID;
    private String Alternative_Name;
}
