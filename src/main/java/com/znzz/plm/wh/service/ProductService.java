package com.znzz.plm.wh.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.znzz.plm.wh.entity.ConditionQuery.MaterialQuery;
import com.znzz.plm.wh.entity.ConditionQuery.ProductQuery;
import com.znzz.plm.wh.entity.Material;
import com.znzz.plm.wh.entity.Product;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 成品表 服务类
 * </p>
 *
 * @author wh
 * @since 2020-05-25
 */
public interface ProductService extends IService<Product> {

    IPage<Product> selectCondition(Page<Product> materialPage, ProductQuery productQuery);
}
