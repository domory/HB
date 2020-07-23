package com.znzz.plm.wh.controller;


import com.znzz.plm.wh.config.R;
import com.znzz.plm.wh.entity.ProductionLine;
import com.znzz.plm.wh.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 生产线表 前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-05-24
 */
@RestController
@CrossOrigin
@RequestMapping("/plm/productionline")
public class ProductionLineController {
    @Autowired
    ProductionLineService lineService;


    @GetMapping("/list")
    public R getList(){
        List<ProductionLine> list = lineService.list(null);
        return  R.ok().data("list",list);

    }

    @PostMapping("/addLine")
    public R addProductionLine(@RequestBody ProductionLine line){
        boolean save = lineService.save(line);
        if(save){
            return R.ok();
        }
        return R.error().message("添加失败");
    }

    @GetMapping("/getProductionline/{id}")
    public R getProductionById(@PathVariable String id){
        ProductionLine line = lineService.getById(id);
        return R.ok().data("line",line);
    }

    @PostMapping("/updateLine")
    public R updateProductionLine(@RequestBody ProductionLine line){
        boolean b = lineService.updateById(line);
        if(b){
            return R.ok();
        }
        return R.error().message("修改失败");
    }

    @DeleteMapping("/deleteLine/{id}")
    public  R deleteLineById(@PathVariable String id){
        boolean b = lineService.removeById(id);
        if(b){
            return R.ok();
        }
        return R.error().message("删除失败");
    }

}

