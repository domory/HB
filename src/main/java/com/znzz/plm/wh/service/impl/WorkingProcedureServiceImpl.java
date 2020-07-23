package com.znzz.plm.wh.service.impl;

import com.znzz.plm.wh.entity.Dto.procedureroute;
import com.znzz.plm.wh.entity.Route;
import com.znzz.plm.wh.entity.WorkingProcedure;
import com.znzz.plm.wh.mapper.WorkingProcedureMapper;
import com.znzz.plm.wh.service.RouteService;
import com.znzz.plm.wh.service.WorkingProcedureService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <p>
 * 工序表 服务实现类
 * </p>
 *
 * @author wh
 * @since 2020-05-18
 */
@Service
public class WorkingProcedureServiceImpl extends ServiceImpl<WorkingProcedureMapper, WorkingProcedure> implements WorkingProcedureService {
    @Autowired
    RouteService routeService;

    @Override
    public List<procedureroute> getlist() {

        List<WorkingProcedure> procedures = baseMapper.selectList(null);
        List<procedureroute> list=new ArrayList<>();
        for (WorkingProcedure procedure : procedures) {
            procedureroute procedureroute = new procedureroute();
            BeanUtils.copyProperties(procedure,procedureroute);
            Route route = routeService.getById(procedure.getRouteId());
            if(route!=null){
            procedureroute.setRouteName(route.getRouteName());}else{
            procedureroute.setRouteName("该工序不属于任何工艺线路，请及时修改");}
            list.add(procedureroute);
        }
        return list;
    }
}
