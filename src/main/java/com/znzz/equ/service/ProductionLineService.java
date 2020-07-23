package com.znzz.equ.service;

import com.znzz.equ.entity.Dispatch;
import com.znzz.equ.entity.ProductionLine;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 生产线表 服务类
 * </p>
 *
 * @author wh
 * @since 2020-07-06
 */
public interface ProductionLineService extends IService<ProductionLine> {

    void updateCapacity(Dispatch dispatch);
}
