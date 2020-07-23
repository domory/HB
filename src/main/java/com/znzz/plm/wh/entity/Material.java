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
 * 原料表
 * </p>
 *
 * @author wh
 * @since 2020-05-25
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Material对象", description="原料表")
public class Material implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "material_id", type = IdType.ID_WORKER_STR)
    private String materialId;

    @ApiModelProperty(value = "原料名称")
    private String materialName;

    @ApiModelProperty(value = "规格")
    private String standards;

    @ApiModelProperty(value = "颜色")
    private String color;

    @ApiModelProperty(value = "种类")
    private String type;


}
