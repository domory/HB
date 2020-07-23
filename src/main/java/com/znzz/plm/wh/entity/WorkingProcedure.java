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
 * 工序表
 * </p>
 *
 * @author wh
 * @since 2020-05-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="WorkingProcedure对象", description="工序表")
public class WorkingProcedure implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "工序id")
    @TableId(value = "procedure_id", type = IdType.ID_WORKER_STR)
    private String procedureId;

    @ApiModelProperty(value = "工序名称")
    private String procedureName;

    @ApiModelProperty(value = "工序描述")
    private String procedureDecript;

    @ApiModelProperty(value = "所属工艺线路id")
    private String routeId;


}
