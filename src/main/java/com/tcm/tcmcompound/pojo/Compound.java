package com.tcm.tcmcompound.pojo;

import javax.persistence.*;

@Entity
@Table(name="compound")
public class Compound {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column(name="compound_name")
    private String compoundName;
    private String synonym;
    private String CAS;
    private String compound_id;
    private String structure;
    private String formula;
    private String molecular_weight;
    private String H_bond_donnor;
    private String H_bond_acceptor;
    private String rotable_bonds;
    private String hydrophobic_alogp;
    private String atoms;
    private String heavy_atoms;
    private String H_atoms;
    private String C_atoms;
    private String bonds;
    private String non_H_bonds;
    private String rings;
    private String se_sum;
    private String absolute_atomic_charge;
    private String squared_atomic_charge;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCompoundName() {
        return compoundName;
    }

    public void setCompoundName(String compoundName) {
        this.compoundName = compoundName;
    }

    public String getSynonym() {
        return synonym;
    }

    public void setSynonym(String synonym) {
        this.synonym = synonym;
    }

    public String getCAS() {
        return CAS;
    }

    public void setCAS(String CAS) {
        this.CAS = CAS;
    }

    public String getCompound_id() {
        return compound_id;
    }

    public void setCompound_id(String compound_id) {
        this.compound_id = compound_id;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
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

    public String getH_bond_donnor() {
        return H_bond_donnor;
    }

    public void setH_bond_donnor(String h_bond_donnor) {
        H_bond_donnor = h_bond_donnor;
    }

    public String getH_bond_acceptor() {
        return H_bond_acceptor;
    }

    public void setH_bond_acceptor(String h_bond_acceptor) {
        H_bond_acceptor = h_bond_acceptor;
    }

    public String getRotable_bonds() {
        return rotable_bonds;
    }

    public void setRotable_bonds(String rotable_bonds) {
        this.rotable_bonds = rotable_bonds;
    }

    public String getHydrophobic_alogp() {
        return hydrophobic_alogp;
    }

    public void setHydrophobic_alogp(String hydrophobic_alogp) {
        this.hydrophobic_alogp = hydrophobic_alogp;
    }

    public String getAtoms() {
        return atoms;
    }

    public void setAtoms(String atoms) {
        this.atoms = atoms;
    }

    public String getHeavy_atoms() {
        return heavy_atoms;
    }

    public void setHeavy_atoms(String heavy_atoms) {
        this.heavy_atoms = heavy_atoms;
    }

    public String getH_atoms() {
        return H_atoms;
    }

    public void setH_atoms(String h_atoms) {
        H_atoms = h_atoms;
    }

    public String getC_atoms() {
        return C_atoms;
    }

    public void setC_atoms(String c_atoms) {
        C_atoms = c_atoms;
    }

    public String getBonds() {
        return bonds;
    }

    public void setBonds(String bonds) {
        this.bonds = bonds;
    }

    public String getNon_H_bonds() {
        return non_H_bonds;
    }

    public void setNon_H_bonds(String non_H_bonds) {
        this.non_H_bonds = non_H_bonds;
    }

    public String getRings() {
        return rings;
    }

    public void setRings(String rings) {
        this.rings = rings;
    }

    public String getSe_sum() {
        return se_sum;
    }

    public void setSe_sum(String se_sum) {
        this.se_sum = se_sum;
    }

    public String getAbsolute_atomic_charge() {
        return absolute_atomic_charge;
    }

    public void setAbsolute_atomic_charge(String absolute_atomic_charge) {
        this.absolute_atomic_charge = absolute_atomic_charge;
    }

    public String getSquared_atomic_charge() {
        return squared_atomic_charge;
    }

    public void setSquared_atomic_charge(String squared_atomic_charge) {
        this.squared_atomic_charge = squared_atomic_charge;
    }
}
