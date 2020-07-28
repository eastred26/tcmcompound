package com.tcm.tcmcompound.web.controller;

import com.tcm.tcmcompound.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @RequestMapping("/result")
    public String result(){
        return "search/result";
    }
}
