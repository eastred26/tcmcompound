package com.tcm.tcmcompound.pojo;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Data
public class Compound {
    private int id;
    private String compound_name;
    private String synonym;
    private String CAS;
    private int chem_id;
    private String name_zh;
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

}
