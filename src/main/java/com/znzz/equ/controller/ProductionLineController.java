package com.znzz.equ.controller;


import com.znzz.equ.config.R;
import com.znzz.equ.entity.ProductionLine;
import com.znzz.equ.service.ProductionLineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 * 生产线表 前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-07-06
 */
@RestController
@CrossOrigin
@RequestMapping("/equ/productionline")
public class ProductionLineController {

    @Autowired
    ProductionLineService productionLineService;

    @GetMapping("productlineList")
    public R getList(){
        List<ProductionLine> list = productionLineService.list(null);
        return  R.ok().data("list",list);
    }
}

