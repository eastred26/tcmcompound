package com.tcm.tcmcompound.pojo;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "tcmcompound")
public class CompoundSearchResult {
    @Field(value = "compound_id")
    private String compound_id;

    @Field(value = "compound_name")
    private String compound_name;

    @Field(value = "compound_synonym")
    private String compound_synonym;

    @Field(value = "compound_cas")
    private String compound_cas;

    @Field(value = "compound_name_zh")
    private String compound_name_zh;

    @Field(value = "compound_structure")
    private String compound_structure;

    @Field(value = "compound_formula")
    private String compound_formula;

    public String getCompound_id() {
        return compound_id;
    }

    public void setCompound_id(String compound_id) {
        this.compound_id = compound_id;
    }

    public String getCompound_name() {
        return compound_name;
    }

    public void setCompound_name(String compound_name) {
        this.compound_name = compound_name;
    }

    public String getCompound_synonym() {
        return compound_synonym;
    }

    public void setCompound_synonym(String compound_synonym) {
        this.compound_synonym = compound_synonym;
    }

    public String getCompound_cas() {
        return compound_cas;
    }

    public void setCompound_cas(String compound_cas) {
        this.compound_cas = compound_cas;
    }

    public String getCompound_name_zh() {
        return compound_name_zh;
    }

    public void setCompound_name_zh(String compound_name_zh) {
        this.compound_name_zh = compound_name_zh;
    }

    public String getCompound_structure() {
        return compound_structure;
    }

    public void setCompound_structure(String compound_structure) {
        this.compound_structure = compound_structure;
    }

    public String getCompound_formula() {
        return compound_formula;
    }

    public void setCompound_formula(String compound_formula) {
        this.compound_formula = compound_formula;
    }
}
