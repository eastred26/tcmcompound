package com.tcm.tcmcompound.pojo;

import lombok.Data;

@Data
public class GNode {
    private String id;
    private String label;
    private String group;
    private boolean isFold;
    public GNode(String id,String label,String group,boolean isFold){
        this.id=id;
        this.label=label;
        this.group=group;
        this.isFold=isFold;
    }
}
