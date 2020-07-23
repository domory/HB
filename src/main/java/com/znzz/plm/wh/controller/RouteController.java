package com.znzz.plm.wh.controller;


import com.znzz.plm.wh.config.R;
import com.znzz.plm.wh.entity.Route;
import com.znzz.plm.wh.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author wh
 * @since 2020-05-18
 */
@RestController
@CrossOrigin
@RequestMapping("/plm/route")
public class RouteController {

    @Autowired
    RouteService routeService;

    //模拟登录
    @PostMapping("/login")
    public  R login(){
        return R.ok().data("token","admin");
    }

    @GetMapping("/info")
    public R info(){
        return R.ok().data("roles","管理员").data("name","admin").data("avatar","https://wpimg.wallstcn.com/f778738c-e4f8-4870-b634-56703b4acafe.gif");
    }

    @GetMapping("/list")
    public R getRouteList(){
        List<Route> list = routeService.list(null);
        return R.ok().data("list",list);
    }

    @PostMapping("/addRoute")
    public R addRoute(@RequestBody Route route){
        boolean b = routeService.save(route);
        if(b){
            return R.ok();
        }
        return R.error();
    }

    @GetMapping("/route/{id}")
    public R getRouteById(@PathVariable String id){
        Route route = routeService.getById(id);
        return R.ok().data("route",route);
    }

    @PostMapping("/updateRoute")
    public R updateRouteById(@RequestBody Route route){
        boolean b = routeService.updateById(route);
        if(b==true){
            return  R.ok();
        }else {
            return R.error();
        }
    }

    @DeleteMapping("/delete/{id}")
    public R deleteRouteById(@PathVariable String id){
        boolean b = routeService.removeById(id);
        if(b==true){
            return  R.ok();
        }else {
            return R.error();
        }
    }
}

