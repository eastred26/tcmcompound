package com.tcm.tcmcompound.pojo;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class IngredientSimple {
    String ingredient_name;
    Integer ingredient_id;
}
