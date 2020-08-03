package com.tcm.tcmcompound.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Target {
    private int ID;
    private String Name;
    private String Gene_Name;
}
