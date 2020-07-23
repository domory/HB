package com.znzz.plm.wh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.znzz.plm.wh.entity.ConditionQuery.MaterialQuery;
import com.znzz.plm.wh.entity.ConditionQuery.ProductQuery;
import com.znzz.plm.wh.entity.Material;
import com.znzz.plm.wh.entity.Product;
import com.znzz.plm.wh.mapper.ProductMapper;
import com.znzz.plm.wh.service.ProductService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 成品表 服务实现类
 * </p>
 *
 * @author wh
 * @since 2020-05-25
 */
@Service
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements ProductService {

    @Override
    public IPage<Product> selectCondition(Page<Product> productPage, ProductQuery productQuery) {
        if(productQuery==null){
            IPage<Product> page = baseMapper.selectPage(productPage, null);
            return  page;
        }
        String productName = productQuery.getProductName();
        String type = productQuery.getProductType();
        QueryWrapper<Product> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(productName)){
            queryWrapper.like("product_name",productName);
        }
        if(!StringUtils.isEmpty(type)){
            queryWrapper.like("product_type",type);
        }
        IPage<Product> page = baseMapper.selectPage(productPage, queryWrapper);

        return page;
    }
}
