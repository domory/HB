package com.znzz.plm.wh.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 成品表
 * </p>
 *
 * @author wh
 * @since 2020-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Product对象", description="成品表")
public class Product implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "product_id", type = IdType.ID_WORKER_STR)
    private String productId;

    @ApiModelProperty(value = "成品名称")
    private String productName;

    @ApiModelProperty(value = "规格")
    private String productStandards;

    @ApiModelProperty(value = "成品颜色")
    private String productColor;

    @ApiModelProperty(value = "种类")
    private String productType;

    @ApiModelProperty(value = "图片")
    private String productPic;


}
