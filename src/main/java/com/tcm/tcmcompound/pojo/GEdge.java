package com.tcm.tcmcompound.pojo;

import lombok.Data;

@Data
public class GEdge {
    private String id;
    private String from;
    private String to;

    public GEdge(String id,String from,String to){
        this.id=id;
        this.from=from;
        this.to=to;
    }

}
