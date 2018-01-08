package com.zjr.gaode.controller;

import com.zjr.gaode.pojo.CycleVO;
import com.zjr.gaode.pojo.StartFinishPointVO;
import com.zjr.gaode.service.IGaodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author: ZhangJiaRen
 * @Date: Created in 14:38 2018/1/8
 * @Description:
 */
@Api(value = "gaode web API", description = "高德web服务")
@RestController
public class GaodeController {
    @Autowired
    private IGaodeService gaodeService;

    @ApiOperation(value = "骑行路径规划之骑行距离")
    @RequestMapping(value = "/cycle/distance", produces = {"application/json"}, method = RequestMethod.POST)
    public CycleVO cycleDistance(
            @ApiParam(value = "起终点的坐标信息", required = true) @RequestBody StartFinishPointVO startFinishPointVO) {

        CycleVO cycleVO = new CycleVO();
        //不能直接返回String类型，否则swagger拿不到数据(报错---Response Headers: no response from server)，解决办法：把String类型数据封装成一个对象，然后返回对象
        cycleVO.setContent(gaodeService.cyclingDistance(startFinishPointVO.getOrigins(), startFinishPointVO.getDestination()));
        return cycleVO;
    }

    @ApiOperation(value = "骑行路径规划之骑行时间")
    @RequestMapping(value = "/cycle/time", produces = {"application/json"}, method = RequestMethod.POST)
    public CycleVO cycleTime(
            @ApiParam(value = "起终点的坐标信息", required = true) @RequestBody StartFinishPointVO startFinishPointVO) {

        CycleVO cycleVO = new CycleVO();
        cycleVO.setContent(gaodeService.cyclingTime(startFinishPointVO.getOrigins(), startFinishPointVO.getDestination()));
        return cycleVO;
    }
}