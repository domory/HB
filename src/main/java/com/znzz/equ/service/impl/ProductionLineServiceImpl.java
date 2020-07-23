package com.znzz.equ.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import com.znzz.equ.entity.Dispatch;
import com.znzz.equ.entity.Equipment;
import com.znzz.equ.entity.ProductionLine;
import com.znzz.equ.mapper.ProductionLineMapper;
import com.znzz.equ.service.EquipmentService;
import com.znzz.equ.service.ProductionLineService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 生产线表 服务实现类
 * </p>
 *
 * @author wh
 * @since 2020-07-06
 */
@Service
public class ProductionLineServiceImpl extends ServiceImpl<ProductionLineMapper, ProductionLine> implements ProductionLineService {

    @Autowired
    EquipmentService equipmentService;

    @Override
    public void updateCapacity(Dispatch dispatch) {
        String productionlineId = dispatch.getProductionlineId();
        String equipId = dispatch.getEquipId();
        //拿生产线产能
        QueryWrapper<ProductionLine> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("production_line_id",productionlineId);
        ProductionLine productionLine = baseMapper.selectOne(queryWrapper);

        //拿设备产能
        QueryWrapper<Equipment> wrapper = new QueryWrapper<>();
        wrapper.eq("id",equipId);

        Equipment equipment = equipmentService.getOne(wrapper);
        if(productionLine.getProductionLineState().equals("未使用")){
            productionLine.setProductionLineState("使用中");
            productionLine.setCapacity(equipment.getEquipmentCapacity());
        }else{
            if(productionLine.getCapacity()>equipment.getEquipmentCapacity()){
                productionLine.setCapacity(equipment.getEquipmentCapacity());
            }
        }
        baseMapper.updateById(productionLine);
    }
}
