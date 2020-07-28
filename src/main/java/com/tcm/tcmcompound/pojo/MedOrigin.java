package com.tcm.tcmcompound.pojo;
import javax.persistence.*;

@Entity
@Table(name="origin")
public class MedOrigin {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String pinyin;
    private String latin_name;
    private String named_people;
    private String family;
    private Integer plant_id;
    private String complete_name;
    private String intro_1;
    private String intro_2;
    private String appearance;
    private String location;
    private String intro_3;
    private String med_info_flora;
    private String med_info_yaoyong;
    private String complete_intro;
    private String pdfinfo;
    private String hierarchy;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getLatin_name() {
        return latin_name;
    }

    public void setLatin_name(String latin_name) {
        this.latin_name = latin_name;
    }

    public String getNamed_people() {
        return named_people;
    }

    public void setNamed_people(String named_people) {
        this.named_people = named_people;
    }

    public String getFamily() {
        return family;
    }

    public void setFamily(String family) {
        this.family = family;
    }

    public Integer getPlant_id() {
        return plant_id;
    }

    public void setPlant_id(Integer plant_id) {
        this.plant_id = plant_id;
    }

    public String getComplete_name() {
        return complete_name;
    }

    public void setComplete_name(String complete_name) {
        this.complete_name = complete_name;
    }

    public String getIntro_1() {
        return intro_1;
    }

    public void setIntro_1(String intro_1) {
        this.intro_1 = intro_1;
    }

    public String getIntro_2() {
        return intro_2;
    }

    public void setIntro_2(String intro_2) {
        this.intro_2 = intro_2;
    }

    public String getAppearance() {
        return appearance;
    }

    public void setAppearance(String appearance) {
        this.appearance = appearance;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntro_3() {
        return intro_3;
    }

    public void setIntro_3(String intro_3) {
        this.intro_3 = intro_3;
    }

    public String getMed_info_flora() {
        return med_info_flora;
    }

    public void setMed_info_flora(String med_info_flora) {
        this.med_info_flora = med_info_flora;
    }

    public String getMed_info_yaoyong() {
        return med_info_yaoyong;
    }

    public void setMed_info_yaoyong(String med_info_yaoyong) {
        this.med_info_yaoyong = med_info_yaoyong;
    }

    public String getComplete_intro() {
        return complete_intro;
    }

    public void setComplete_intro(String complete_intro) {
        this.complete_intro = complete_intro;
    }

    public String getPdfinfo() {
        return pdfinfo;
    }

    public void setPdfinfo(String pdfinfo) {
        this.pdfinfo = pdfinfo;
    }

    public String getHierarchy() {
        return hierarchy;
    }

    public void setHierarchy(String hierarchy) {
        this.hierarchy = hierarchy;
    }

}
