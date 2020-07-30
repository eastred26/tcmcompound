package com.tcm.tcmcompound.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Ingredient {
    private int ID;
    private String Name;
    private String Formula;
    private String PubChem_ID;
    private String SMILE;
}
