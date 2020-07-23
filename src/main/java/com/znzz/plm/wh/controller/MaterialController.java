package com.znzz.plm.wh.controller;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.znzz.plm.wh.config.R;
import com.znzz.plm.wh.entity.ConditionQuery.MaterialQuery;
import com.znzz.plm.wh.entity.Material;
import com.znzz.plm.wh.service.MaterialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 原料表 前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-05-25
 */
@RestController
@CrossOrigin
@RequestMapping("/plm/material")
public class MaterialController {
    @Autowired
    MaterialService materialService;


    @PostMapping("/condition/{page}/{size}")
    public R getMaterialByCondition(@PathVariable Integer page,
                                    @PathVariable Integer size,
                                    @RequestBody(required = false) MaterialQuery materialQuery){
        Page<Material> materialPage = new Page<>(page,size);

        IPage<Material> page1= materialService.selectCondition(materialPage,materialQuery);
        long total = page1.getTotal();
        List<Material> records = page1.getRecords();
        return R.ok().data("total",total).data("list",records);
    }


    @PostMapping("/addMaterial")
    public R addMaterial(@RequestBody Material material){
        boolean save = materialService.save(material);
        if(save){
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/getMaterialInfoById/{id}")
    public R getMaterialInfoById(@PathVariable String id){
        Material material = materialService.getById(id);
        return R.ok().data("data",material);
    }

    @PostMapping("/updateMaterialById")
    public R updateMaterial(@RequestBody Material material){
        boolean b = materialService.updateById(material);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @DeleteMapping("/deleteById/{id}")
    public  R delete(@PathVariable String id){
        boolean b = materialService.removeById(id);
        if(b){
            return R.ok();
        }
        return R.error();
    }

}

