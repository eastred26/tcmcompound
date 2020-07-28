package com.tcm.tcmcompound.web.restcontroller;

import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import com.tcm.tcmcompound.service.MedOriginService;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/origin")
public class OriginRestController {
    private final MedOriginService medOriginService;

    public OriginRestController(MedOriginService medOriginService) {
        this.medOriginService = medOriginService;
    }

    @RequestMapping(value = "/getOriginRelate", method = RequestMethod.POST)
    public List<MedOriginCompoundRelate> queryAll(@RequestBody Map<String, Integer> map) {
        return medOriginService.getRelateByOriginId(map.get("keyword"));
    }
}
