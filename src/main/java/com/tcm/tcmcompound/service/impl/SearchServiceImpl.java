package com.tcm.tcmcompound.service.impl;

import com.tcm.tcmcompound.pojo.MedSearchResult;
import com.tcm.tcmcompound.pojo.OriginSearchResult;
import com.tcm.tcmcompound.pojo.CompoundSearchResult;
import com.tcm.tcmcompound.service.SearchService;
import org.apache.solr.client.solrj.SolrClient;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.CloudSolrClient;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.ModifiableSolrParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class SearchServiceImpl implements SearchService {
    @Autowired
    SolrClient solrClient;

    @Override
    public Map<String, Object> searchByKeyword(String keyword, String searchType, int pIndex, int size){
        CloudSolrClient cSolrClient = (CloudSolrClient)solrClient;
        Map<String, Object> result = new HashMap<>();
        List<MedSearchResult> resultList1 = new ArrayList<>();
        List<OriginSearchResult> resultList2 = new ArrayList<>();
        List<CompoundSearchResult> resultList3 = new ArrayList<>();

        result.put("totalResult", 0);
        try{
            ModifiableSolrParams params = new ModifiableSolrParams();
            if (searchType.equals("med")){
                cSolrClient.setDefaultCollection("tcmcompound_med");
                params.add("q","(med_name_zh:*" + keyword + "*^10 OR med_origin:"+keyword + "^1 OR med_function:"
                        + keyword + "^1 OR med_property:" + keyword + "^1 OR med_tropisw:" + keyword + "^1 OR med_name_pinyin:"
                        + keyword + "^10 OR med_name_latin:"+keyword + "^10)");
            } else if (searchType.equals("origin")) {
                cSolrClient.setDefaultCollection("tcmcompound_origin");
                params.add("q","(origin_name_zh:*" + keyword + "*^10 OR origin_appearance:" + keyword + "^1 OR origin_location:"
                        + keyword + "^1 OR origin_hierachy:" + keyword + "^1 OR origin_name_pinyin:" + keyword + "^10 OR origin_name_latin:"+keyword + "^10)");
            } else{
                cSolrClient.setDefaultCollection("tcmcompound");
                params.add("q","(compound_name:" + keyword + "^10 OR compound_synonym:" + keyword + "^1 OR compound_structure:"
                        + keyword + "^1 OR compound_formula:" + keyword + "^1 OR compound_name_zh:*" + keyword + "*^10 OR compound_cas:" + keyword + "^1)");
            }
            params.add("start",String.valueOf(pIndex));
            params.add("rows",String.valueOf(size));
            QueryResponse response=null;
            response = cSolrClient.query(params);
            if (searchType.equals("med")){
                resultList1 = response.getBeans(MedSearchResult.class);
                result.put("data", resultList1);
            } else if (searchType.equals("origin")) {
                resultList2 = response.getBeans(OriginSearchResult.class);
                result.put("data", resultList2);
            } else {
                resultList3 = response.getBeans(CompoundSearchResult.class);
                result.put("data", resultList3);
            }
            long totalResult = response.getResults().getNumFound();
            result.put("totalResult", totalResult);

        } catch (SolrServerException e) {
            e.printStackTrace();
        } catch(Exception e){
            System.out.println(e);
        }
        return result;
    };
}
