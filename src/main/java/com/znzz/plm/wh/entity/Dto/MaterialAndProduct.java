package com.znzz.plm.wh.entity.Dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class MaterialAndProduct {
    private  String productId;
    private String materialId;

    private String materialName;

    private Double amount;

    private String unit;
}
