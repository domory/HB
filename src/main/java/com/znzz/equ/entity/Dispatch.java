package com.znzz.equ.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 调度表
 * </p>
 *
 * @author wh
 * @since 2020-07-06
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="Dispatch对象", description="调度表")
public class Dispatch implements Serializable {

    private static final long serialVersionUID = 1L;

    private String equipId;

    @TableField("productionLine_id")
    private String productionlineId;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @ApiModelProperty(value = "调度时间")
    private Date applyTime;

    @ApiModelProperty(value = "调度人姓名")
    private String applyName;

    private String state;

    @ApiModelProperty(value = "调度说明")
    private String note;


}
