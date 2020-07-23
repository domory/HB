package com.znzz.equ.entity;

import java.math.BigDecimal;
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
 * 生产线表
 * </p>
 *
 * @author wh
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ProductionLine对象", description="生产线表")
public class ProductionLine implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "生产线编号")
    @TableId(value = "production_line_id", type = IdType.ID_WORKER_STR)
    private String productionLineId;

    @ApiModelProperty(value = "生产线名称")
    private String productionLineName;

    @ApiModelProperty(value = "生产线状态")
    private String productionLineState;

    @ApiModelProperty(value = "生产线产能单位")
    private String capacityUnit;

    @ApiModelProperty(value = "生产线产能")
    private Double capacity;

    @ApiModelProperty(value = "生产线所属工序编号")
    private String procedureId;


}
