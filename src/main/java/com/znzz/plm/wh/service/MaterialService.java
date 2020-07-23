package com.znzz.plm.wh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.znzz.plm.wh.entity.ConditionQuery.MaterialQuery;
import com.znzz.plm.wh.entity.Material;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 原料表 服务类
 * </p>
 *
 * @author wh
 * @since 2020-05-25
 */
public interface MaterialService extends IService<Material> {

    IPage<Material> selectCondition(Page<Material> materialPage, MaterialQuery materialQuery);
}
