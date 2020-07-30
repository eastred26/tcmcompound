package com.tcm.tcmcompound.pojo;

import lombok.Data;
import org.apache.solr.client.solrj.beans.Field;
import org.springframework.data.solr.core.mapping.SolrDocument;

@Data
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

}
