package com.tcm.tcmcompound.pojo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
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

}
