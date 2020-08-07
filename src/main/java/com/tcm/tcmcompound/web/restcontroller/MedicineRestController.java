package com.tcm.tcmcompound.web.restcontroller;

import com.tcm.tcmcompound.pojo.*;
import com.tcm.tcmcompound.service.CompoundService;
import com.tcm.tcmcompound.service.HerbService;
import com.tcm.tcmcompound.service.IngredientService;
import com.tcm.tcmcompound.service.MedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class MedicineRestController {
    @Autowired
    private MedService medService;
    @Autowired
    private HerbService herbService;
    @Autowired
    private IngredientService ingredientService;
    @Autowired
    private CompoundService compoundService;

    @RequestMapping(value = "/medicine/getMedRelate", method = RequestMethod.POST)
    public List<MedOriginCompoundRelateSimple> queryAllMed(@RequestBody Map<String, Integer> map) {
        int mid=map.get("keyword");
        String mname=medService.getNameById(mid);
        List<MedOriginCompoundRelateSimple> res=new LinkedList<>();
        List<CompoundSimple> list1=medService.getCompoundByMedId(mid);
        Set<Integer> set=new HashSet<>();
        for(CompoundSimple item:list1){
            int cid=Integer.parseInt(item.getCompound_id());
            res.add(new MedOriginCompoundRelateSimple(mid,mname,cid,item.getCompound_name(),item.getFormula()));
            set.add(cid);
        }
        Integer hid=medService.getHerbById(mid);
        if(hid!=null){
            String []ss=herbService.getIngredientsbyId(hid).trim().split("\\s+");
            for(String item:ss){
                Ingredient ingredient =ingredientService.getIngredientById(Integer.parseInt(item));
                String cid_s=ingredientService.getCompound(ingredient.getPubChem_ID());
                if(cid_s!=null){
                    int cid=Integer.parseInt(cid_s);
                    if(set.contains(cid))continue;
                    Compound item1=compoundService.getById(cid);
                    res.add(new MedOriginCompoundRelateSimple(mid,mname,cid,item1.getCompound_name(),item1.getFormula()));
                    set.add(cid);
                }
                else{
                    res.add(new MedOriginCompoundRelateSimple(mid,mname,-ingredient.getID(),ingredient.getName(),ingredient.getFormula()));
                }
            }
        }
        return res;
    }
    @RequestMapping(value = "/herb/getHerbRelate", method = RequestMethod.POST)
    public List<MedOriginCompoundRelateSimple> queryAllHerb(@RequestBody Map<String, Integer> map) {
        int hid=map.get("keyword");
        String mname=herbService.getNamebyId(hid);
        Integer mid=herbService.getMedById(hid);
        List<MedOriginCompoundRelateSimple> res=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        if(mid!=null){
            mname=medService.getNameById(mid);
            List<CompoundSimple> list1=medService.getCompoundByMedId(mid);
            for(CompoundSimple item:list1){
                int cid=Integer.parseInt(item.getCompound_id());
                res.add(new MedOriginCompoundRelateSimple(mid,mname,cid,item.getCompound_name(),item.getFormula()));
                set.add(cid);
            }
        }

        String []ss=herbService.getIngredientsbyId(hid).trim().split("\\s+");
        for(String item:ss){
            Ingredient ingredient =ingredientService.getIngredientById(Integer.parseInt(item));
            String cid_s=ingredientService.getCompound(ingredient.getPubChem_ID());
            if(cid_s!=null){
                int cid=Integer.parseInt(cid_s);
                if(set.contains(cid))continue;
                Compound item1=compoundService.getById(cid);
                res.add(new MedOriginCompoundRelateSimple(mid,mname,cid,item1.getCompound_name(),item1.getFormula()));
                set.add(cid);
            }
            else{
                res.add(new MedOriginCompoundRelateSimple(mid,mname,-ingredient.getID(),ingredient.getName(),ingredient.getFormula()));
            }
        }
        return res;
    }

    @RequestMapping(value = "/medicine/getMedRelate/{id}", method = RequestMethod.POST)
    public List<MedOriginCompoundRelate> query(@PathVariable Integer id) {
        return medService.getRelateByMedId(id);
    }

}
