package com.znzz.plm.wh.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.znzz.plm.wh.config.R;
import com.znzz.plm.wh.entity.Dto.procedureroute;
import com.znzz.plm.wh.entity.ProductionLine;
import com.znzz.plm.wh.entity.WorkingProcedure;
import com.znzz.plm.wh.service.ProductionLineService;
import com.znzz.plm.wh.service.WorkingProcedureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 工序表 前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-05-18
 */
@RestController
@CrossOrigin
@RequestMapping("/plm/workingprocedure")
public class WorkingProcedureController {
    @Autowired
    WorkingProcedureService procedureService;
    @Autowired
    ProductionLineService lineService;

    @PostMapping("/addProcedure")
    public R addProcedure(@RequestBody WorkingProcedure procedure){
        boolean save = procedureService.save(procedure);
        if(save){
            return R.ok();
        }
        return R.error();
    }

    //获得工序中所有信息
    @GetMapping("/procedureList")
    public R getAllProcedure(){
        List<procedureroute> list = procedureService.getlist();
        return R.ok().data("list",list);
    }

    @GetMapping("/getProcedureInfoById/{id}")
    public R getProcedureInfoById(@PathVariable String id){
        WorkingProcedure procedure = procedureService.getById(id);
        return R.ok().data("procedure",procedure);
    }

    @PostMapping("/updateProcedureById")
    public R updateProcedureById(@RequestBody WorkingProcedure procedure){
        boolean b = procedureService.updateById(procedure);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @DeleteMapping("/deleteProcedureById/{id}")
    public R deleteProcedureById(@PathVariable String id){
        boolean b = procedureService.removeById(id);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/getProductionLineInfo/{id}")
    public R getLineInfoByProId(@PathVariable String id){
        QueryWrapper<ProductionLine> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("procedure_id",id);
        List<ProductionLine> list = lineService.list(queryWrapper);
        return R.ok().data("lineList",list);
    }
}

