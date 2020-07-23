package com.znzz.equ.controller;


import com.znzz.equ.config.R;
import com.znzz.equ.entity.Equipment;
import com.znzz.equ.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-07-06
 */
@RestController
@CrossOrigin
@RequestMapping("/equ/equipment")
public class EquipmentController {
    @Autowired
    EquipmentService equipmentService;


    //模拟登录
    @PostMapping("/login")
    public  R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","管理员").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    //设备列表的查询
    @GetMapping("/getList")
    public R getEquipList(){
        List<Equipment> list = equipmentService.list(null);
        return R.ok().data("list",list);
    }



    @PostMapping("/addEqu")
    public R addEqu(@RequestBody Equipment equipment){
        equipment.setEquipmentTime(new Date());
        boolean save = equipmentService.save(equipment);
        if(save){
            return  R.ok();
        }else {
            return  R.error();
        }
    }

    @GetMapping("/getEquById/{id}")
    public R getEquById(@PathVariable String id){
        Equipment equipment = equipmentService.getById(id);
        return R.ok().data("data",equipment);
    }

    @PostMapping("/updateEquById")
    public R update(@RequestBody Equipment equipment){
        boolean b = equipmentService.updateById(equipment);
        if(b){
            return R.ok();
        }else{
            return  R.error();
        }
    }

    @DeleteMapping("/deleteById/{id}")
    public R deleteById(@PathVariable String id){
        boolean b = equipmentService.removeById(id);
        if(b){
            return R.ok();
        }else{
            return  R.error();
        }
    }
}

