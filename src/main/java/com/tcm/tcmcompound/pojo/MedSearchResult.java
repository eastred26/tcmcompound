package com.tcm.tcmcompound.pojo;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "tcmcompound_med")
public class MedSearchResult {
    @Field(value = "med_id")
    private String med_id;

    @Field(value = "med_name_zh")
    private String med_name_zh;

    @Field(value = "med_name_pinyin")
    private String med_name_pinyin;

    @Field(value = "med_name_latin")
    private String med_name_latin;

    @Field(value = "med_origin")
    private String med_origin;

    @Field(value = "med_app_identify")
    private String med_app_identify;

    @Field(value = "med_property")
    private String med_property;

    @Field(value = "med_tropisw")
    private String med_tropisw;

    @Field(value = "med_function")
    private String med_function;

    public String getMed_id() {
        return med_id;
    }

    public void setMed_id(String med_id) {
        this.med_id = med_id;
    }

    public String getMed_name_zh() {
        return med_name_zh;
    }

    public void setMed_name_zh(String med_name_zh) {
        this.med_name_zh = med_name_zh;
    }

    public String getMed_name_pinyin() {
        return med_name_pinyin;
    }

    public void setMed_name_pinyin(String med_name_pinyin) {
        this.med_name_pinyin = med_name_pinyin;
    }

    public String getMed_name_latin() {
        return med_name_latin;
    }

    public void setMed_name_latin(String med_name_latin) {
        this.med_name_latin = med_name_latin;
    }

    public String getMed_origin() {
        return med_origin;
    }

    public void setMed_origin(String med_origin) {
        this.med_origin = med_origin;
    }

    public String getMed_app_identify() {
        return med_app_identify;
    }

    public void setMed_app_identify(String med_app_identify) {
        this.med_app_identify = med_app_identify;
    }

    public String getMed_property() {
        return med_property;
    }

    public void setMed_property(String med_property) {
        this.med_property = med_property;
    }

    public String getMed_tropisw() {
        return med_tropisw;
    }

    public void setMed_tropisw(String med_tropisw) {
        this.med_tropisw = med_tropisw;
    }

    public String getMed_function() {
        return med_function;
    }

    public void setMed_function(String med_function) {
        this.med_function = med_function;
    }
}
