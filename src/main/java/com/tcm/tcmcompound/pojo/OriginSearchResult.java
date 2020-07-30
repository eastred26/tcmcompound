package com.tcm.tcmcompound.pojo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
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


}
