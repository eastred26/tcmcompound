package com.tcm.tcmcompound.pojo;

import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@SolrDocument(collection = "tcmcompound_origin")
public class OriginSearchResult {
    @Field(value = "origin_id")
    private String origin_id;

    @Field(value = "origin_name_zh")
    private String origin_name_zh;

    @Field(value = "origin_name_pinyin")
    private String origin_name_pinyin;

    @Field(value = "origin_name_latin")
    private String origin_name_latin;

    @Field(value = "origin_family")
    private String origin_family;

    @Field(value = "origin_appearance")
    private String origin_appearance;

    @Field(value = "origin_location")
    private String origin_location;

    @Field(value = "origin_hierachy")
    private String origin_hierachy;

    public String getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(String origin_id) {
        this.origin_id = origin_id;
    }

    public String getOrigin_name_zh() {
        return origin_name_zh;
    }

    public void setOrigin_name_zh(String origin_name_zh) {
        this.origin_name_zh = origin_name_zh;
    }

    public String getOrigin_name_pinyin() {
        return origin_name_pinyin;
    }

    public void setOrigin_name_pinyin(String origin_name_pinyin) {
        this.origin_name_pinyin = origin_name_pinyin;
    }

    public String getOrigin_name_latin() {
        return origin_name_latin;
    }

    public void setOrigin_name_latin(String origin_name_latin) {
        this.origin_name_latin = origin_name_latin;
    }

    public String getOrigin_family() {
        return origin_family;
    }

    public void setOrigin_family(String origin_family) {
        this.origin_family = origin_family;
    }

    public String getOrigin_appearance() {
        return origin_appearance;
    }

    public void setOrigin_appearance(String origin_appearance) {
        this.origin_appearance = origin_appearance;
    }

    public String getOrigin_location() {
        return origin_location;
    }

    public void setOrigin_location(String origin_location) {
        this.origin_location = origin_location;
    }

    public String getOrigin_hierachy() {
        return origin_hierachy;
    }

    public void setOrigin_hierachy(String origin_hierachy) {
        this.origin_hierachy = origin_hierachy;
    }
}
