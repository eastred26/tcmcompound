package com.tcm.tcmcompound.web.restcontroller;

import com.tcm.tcmcompound.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/search")
public class SearchRestController {
    @Autowired
    SearchService searchService;

    @RequestMapping(value = "/getSearchResult", method = RequestMethod.POST)
    @ResponseBody
    public Map<String, Object> getSearchResult(@RequestBody Map<String, String> params) {
        Map<String, Object> result = new HashMap<>();
        String keyword = params.get("keyword");
        String type = params.get("type");
        int pIndex = Integer.parseInt(params.get("pIndex"));
        int size = Integer.parseInt(params.get("size"));
        if(keyword == null || keyword.equals("")){
            keyword = "";
        }
        result = searchService.searchByKeyword(keyword, type, pIndex, size);
        return result;
    }
}
