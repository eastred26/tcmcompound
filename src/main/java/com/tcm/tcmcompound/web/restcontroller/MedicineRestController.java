package com.tcm.tcmcompound.web.restcontroller;

import com.tcm.tcmcompound.pojo.MedOriginCompoundRelate;
import com.tcm.tcmcompound.pojo.MedOriginRelate;
import com.tcm.tcmcompound.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/medicine")
public class MedicineRestController {
    private final MedService medService;

    @Autowired
    public MedicineRestController(MedService medService) {
        this.medService = medService;
    }

    @RequestMapping(value = "/getMedRelate", method = RequestMethod.POST)
    public List<MedOriginCompoundRelate> queryAll(@RequestBody Map<String, Integer> map) {
        return medService.getRelateByMedId( map.get("keyword"));
    }

    @RequestMapping(value = "/medicine/getMedRelate/{id}", method = RequestMethod.POST)
    public List<MedOriginCompoundRelate> query(@PathVariable Integer id) {
        return medService.getRelateByMedId(id);
    }

}
