package com.too.trip.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.too.trip.entity.Order;
import com.too.trip.entity.R;
import com.too.trip.entity.Scenic;
import com.too.trip.entity.ScenicOrders;
import com.too.trip.service.ScenicOrdersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@CrossOrigin("*")
@RequestMapping("/scenic-orders")
public class ScenicOrdersController {
    @Autowired
    private ScenicOrdersService scenicOrdersService;

    //查询所有订单
    @PostMapping("/selectAll")
    public R selectScenicOredrsAll(HttpServletRequest request) {
        List<ScenicOrders> scenicOrders = scenicOrdersService.selectAllScenicOrder();
        if (scenicOrders == null || scenicOrders.size() == 0) {
            System.out.println(scenicOrders);
            return new R<>(204, "没有查到数据");
        }
        return new R<>(scenicOrders);
    }

    //根据用户id查询订单
    @PostMapping("/selectByUid")
    public R selectScenicOrderByUserId(HttpServletRequest request, @RequestParam("userId") Integer userId) {
        List<ScenicOrders> scenicOrders = scenicOrdersService.selectScenicOrderByUserId(userId);
        if (scenicOrders == null || scenicOrders.size() == 0) {
            System.out.println(scenicOrders);
            return new R<>(204, "没有查到数据");
        }
        return new R<>(scenicOrders);
    }

    //根据用户ID查询酒店订单+景点订单
    @PostMapping("/getUserOrder")
    public R<List<Order>> getUserOrders(HttpServletRequest request, @RequestParam("userId") Integer userId) {
        List<Order> orders = scenicOrdersService.getUserOrders(userId);
        System.out.println("ffffffff" + orders);
        if (orders == null || orders.size() == 0) {
            return new R<>(204, "没有查到数据");
        }
        return new R<>(orders);
    }

    //添加景点订单
    @PostMapping("/insert")
    public R insertScenicOrder(HttpServletRequest request, @RequestBody ScenicOrders scenicOrders) {
        LocalDateTime time = LocalDateTime.now();
        scenicOrders.setSoTime(time);
        boolean result = scenicOrdersService.insertScenicOrder(scenicOrders);
        if (!result) {
            System.out.println(scenicOrders);
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    //根据景点订单ID删除景点订单
    @PostMapping("/delete")
    public R deleteScenicOrder(HttpServletRequest request, @RequestParam("soId") Integer soId) {
        boolean result = scenicOrdersService.deleteScenicOrdersById(soId);
        if (!result) {
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    //更新景点订单
    @PostMapping("/update")
    public R updateScenicOrder(HttpServletRequest request, @RequestBody ScenicOrders scenicOrders) {
        LocalDateTime time = LocalDateTime.now();
        scenicOrders.setSoTime(time);
        boolean result = scenicOrdersService.updateScenicOrder(scenicOrders);
        if (!result) {
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    //批量删除
    @DeleteMapping("batch")
    public R deleteByBatch(@RequestBody Map<String, List<Integer>> json){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Integer>> map = mapper.convertValue(json, Map.class);
        List<Integer> soIds = map.get("soIds");
        if(soIds.size() == 0){
            return new R(400,"删除数据不能为空");
        }
        boolean result = scenicOrdersService.removeBatchByIds(soIds);
        if(!result){
            return new R(200,"没有对应的数据可删除");
        }
        return new R();

    }

}

