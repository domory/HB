package com.znzz.equ.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.znzz.equ.config.R;
import com.znzz.equ.entity.Dispatch;
import com.znzz.equ.entity.Equipment;
import com.znzz.equ.entity.ProductionLine;
import com.znzz.equ.service.DispatchService;
import com.znzz.equ.service.EquipmentService;
import com.znzz.equ.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 调度表 前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-07-06
 */
@RestController
@CrossOrigin
@RequestMapping("/equ/dispatch")
public class DispatchController {
    @Autowired
    DispatchService dispatchService;
    @Autowired
    ProductionLineService lineService;
    @Autowired
    EquipmentService equipmentService;

    @PostMapping("/add")
    public R addDispatch(@RequestBody Dispatch dispatch){
        String equipId = dispatch.getEquipId();
        QueryWrapper<Dispatch> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("equip_id",equipId).eq("state","未审核");
        Dispatch one = dispatchService.getOne(queryWrapper);
        if(one!=null){
//            QueryWrapper<Dispatch> queryWrapper1 = new QueryWrapper<>();
//            queryWrapper1.eq("equip_id",equipId);
//            dispatchService.remove(queryWrapper1);
            return R.error().message("这个设备已经被调度了，正在审核中");
        }

        boolean save = dispatchService.save(dispatch);
        if(save){
            return  R.ok();
        }else {
            return  R.error();
        }
    }


    //获得调度申请列表
    @GetMapping("/getList")
    public R getList(){
        List<Dispatch> list = dispatchService.list(null);
        return R.ok().data("list",list);
    }

//    @GetMapping("/getDispatchById/{id}")
//    public  R getById(@PathVariable String id){
//        Dispatch dispatch = dispatchService.getById(id);
//        return R.ok().data("data",dispatch);
//    }

    //审核通过
    @PostMapping("/updateById/{id}")
    public R update(@PathVariable String id){
        QueryWrapper<Dispatch> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("equip_id",id);
        Dispatch dispatch = dispatchService.getOne(queryWrapper);
        dispatch.setState("通过");
//        QueryWrapper<Dispatch> queryWrapper1 = new QueryWrapper<>();
//        queryWrapper1.eq("equip_id",id);
        boolean b = dispatchService.update(dispatch,queryWrapper);
        QueryWrapper<Equipment> wrapper = new QueryWrapper<>();
        wrapper.eq("id",id);
        Equipment equipment = equipmentService.getOne(wrapper);
        equipment.setEquipmentState("使用");
        equipmentService.updateById(equipment);
        lineService.updateCapacity(dispatch);
        if(b){
            return  R.ok();
        }else {
            return  R.error();
        }
    }


    @PostMapping("/failupdateById/{id}")
    public R Unupdate(@PathVariable String id){
        QueryWrapper<Dispatch> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("equip_id",id);
        Dispatch dispatch = dispatchService.getOne(queryWrapper);
        dispatch.setState("未通过");
        boolean b = dispatchService.update(dispatch,queryWrapper);
        if(b){
            return  R.ok();
        }else {
            return  R.error();
        }
    }
}

