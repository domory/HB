package com.znzz.plm.wh.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.znzz.plm.wh.entity.ConditionQuery.MaterialQuery;
import com.znzz.plm.wh.entity.Material;
import com.znzz.plm.wh.mapper.MaterialMapper;
import com.znzz.plm.wh.service.MaterialService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 原料表 服务实现类
 * </p>
 *
 * @author wh
 * @since 2020-05-25
 */
@Service
public class MaterialServiceImpl extends ServiceImpl<MaterialMapper, Material> implements MaterialService {

    @Override
    public IPage<Material> selectCondition(Page<Material> materialPage, MaterialQuery materialQuery) {
        if(materialQuery==null){
            IPage<Material> page = baseMapper.selectPage(materialPage, null);
            return  page;
        }
        String materialName = materialQuery.getMaterialName();
        String type = materialQuery.getType();
        QueryWrapper<Material> queryWrapper = new QueryWrapper<>();
        if(!StringUtils.isEmpty(materialName)){
            queryWrapper.like("material_name",materialName);
        }
        if(!StringUtils.isEmpty(type)){
            queryWrapper.like("type",type);
        }
        IPage<Material> page = baseMapper.selectPage(materialPage, queryWrapper);

        return page;
    }
}
