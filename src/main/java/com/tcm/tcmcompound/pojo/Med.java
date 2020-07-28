package com.tcm.tcmcompound.pojo;
import javax.persistence.*;

@Entity
@Table(name="med_yaodian")
public class Med {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="med_name_zh")
    private String name;
    @Column(name="med_name_pinyin")
    private String pinyin;
    @Column(name="med_name_latin")
    private String latin_name;
    private String med_origin;
    private String med_store;
    private String med_property;
    private String med_tropisw;
    private String med_function;
    private Integer tcm_id;
    private String tcm_name;
    private String source;

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

    public String getMed_origin() {
        return med_origin;
    }

    public void setMed_origin(String med_origin) {
        this.med_origin = med_origin;
    }

    public String getMed_store() {
        return med_store;
    }

    public void setMed_store(String med_store) {
        this.med_store = med_store;
    }

    public String getMed_function() {
        return med_function;
    }

    public void setMed_function(String med_function) {
        this.med_function = med_function;
    }

    public String getMed_property() {
        return med_property;
    }

    public void setMed_property(String med_property) {
        this.med_property = med_property;
    }

    public String getMed_tropisw() {
        return med_tropisw;
    }

    public void setMed_tropisw(String med_tropisw) {
        this.med_tropisw = med_tropisw;
    }

    public Integer getTcm_id() {
        return tcm_id;
    }

    public void setTcm_id(Integer tcm_id) {
        this.tcm_id = tcm_id;
    }

    public String getTcm_name() {
        return tcm_name;
    }

    public void setTcm_name(String tcm_name) {
        this.tcm_name = tcm_name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

}
