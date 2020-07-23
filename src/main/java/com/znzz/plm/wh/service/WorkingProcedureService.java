package com.znzz.plm.wh.service;

import com.znzz.plm.wh.entity.Dto.procedureroute;
import com.znzz.plm.wh.entity.WorkingProcedure;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 工序表 服务类
 * </p>
 *
 * @author wh
 * @since 2020-05-18
 */
public interface WorkingProcedureService extends IService<WorkingProcedure> {

    List<procedureroute> getlist();
}
