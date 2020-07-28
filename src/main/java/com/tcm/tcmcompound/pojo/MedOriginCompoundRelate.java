package com.tcm.tcmcompound.pojo;
import javax.persistence.*;

@Entity
@Table(name="medicine_origin_compound_map")
public class MedOriginCompoundRelate {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="medicine_id")
    private Integer medicineId;
    @Column(name="medicine_name")
    private String medicineName;
    @Column(name="origin_id")
    private Integer originId;
    @Column(name="origin_name")
    private String originName;
    private String origin_latin;
    @Column(name="compound_id")
    private Integer compoundId;
    @Column(name="compound_name")
    private String compoundName;
    private String CAS;
    private String zju_id;
    private String formula;
    private String molecular_weight;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMedicineId() {
        return medicineId;
    }

    public void setMedicineId(Integer medicineId) {
        this.medicineId = medicineId;
    }

    public String getMedicineName() {
        return medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    public Integer getOriginId() {
        return originId;
    }

    public void setOriginId(Integer originId) {
        this.originId = originId;
    }

    public String getOriginName() {
        return originName;
    }

    public void setOriginName(String originName) {
        this.originName = originName;
    }

    public String getOrigin_latin() {
        return origin_latin;
    }

    public void setOrigin_latin(String origin_latin) {
        this.origin_latin = origin_latin;
    }

    public Integer getCompoundId() {
        return compoundId;
    }

    public void setCompoundId(Integer compoundId) {
        this.compoundId = compoundId;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    public String getCAS() {
        return CAS;
    }

    public void setCAS(String CAS) {
        this.CAS = CAS;
    }

    public String getZju_id() {
        return zju_id;
    }

    public void setZju_id(String zju_id) {
        this.zju_id = zju_id;
    }

    public String getFormula() {
        return formula;
    }

    public void setFormula(String formula) {
        this.formula = formula;
    }

    public String getMolecular_weight() {
        return molecular_weight;
    }

    public void setMolecular_weight(String molecular_weight) {
        this.molecular_weight = molecular_weight;
    }
}
