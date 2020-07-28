package com.tcm.tcmcompound.pojo;
import javax.persistence.*;

@Entity
@Table(name="medicine_origin_map")
public class MedOriginRelate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="origin_id")
    private Integer originId;
    @Column(name="origin_name_zh")
    private String originNameZh;
    private String origin_name_latin;
    private String origin_name_latin_people;
    @Column(name="medicine_name")
    private String medicineName;
    @Column(name="medicine_id")
    private Integer medicineId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public String getOriginNameZh() {
        return originNameZh;
    }

    public void setOriginNameZh(String originNameZh) {
        this.originNameZh = originNameZh;
    }

    public String getOrigin_name_latin() {
        return origin_name_latin;
    }

    public void setOrigin_name_latin(String origin_name_latin) {
        this.origin_name_latin = origin_name_latin;
    }

    public String getOrigin_name_latin_people() {
        return origin_name_latin_people;
    }

    public void setOrigin_name_latin_people(String origin_name_latin_people) {
        this.origin_name_latin_people = origin_name_latin_people;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }
}
