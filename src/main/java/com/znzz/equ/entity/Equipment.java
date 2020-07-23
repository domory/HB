package com.znzz.equ.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author wh
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Equipment对象", description="")
public class Equipment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;

    @ApiModelProperty(value = "设备名称")
    private String equipmentName;

    @ApiModelProperty(value = "设备所属类型")
    private String equipmentType;

    @ApiModelProperty(value = "设备位置")
    private String equipmentLocation;

    @ApiModelProperty(value = "产能单位")
    private String equipmentUnit;

    @ApiModelProperty(value = "设备产能")
    private Double equipmentCapacity;

    @ApiModelProperty(value = "设备在工厂中的状态。0代表正常闲置，1代表维修，2代表报废，3代表使用中，4代表出售")
    private String equipmentState;

    @ApiModelProperty(value = "设备到厂日期")
    private Date equipmentTime;


}
