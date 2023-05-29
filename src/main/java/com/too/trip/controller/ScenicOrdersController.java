package com.too.trip.controller;

import com.too.trip.entity.R;
import com.too.trip.entity.Scenic;
import com.too.trip.entity.ScenicOrders;
import com.too.trip.service.impl.ScenicOrdersServiceImpl;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@RequestMapping("/scenic-orders")
public class ScenicOrdersController {
    @Autowired
    private ScenicOrdersServiceImpl scenicOrdersService;

    //查询所有订单
    @PostMapping("/selectAll")
    public R selectScenicOredrsAll(HttpServletRequest request) {
        List<ScenicOrders> scenicOrders = scenicOrdersService.selectAllScenicOrder();
        if (scenicOrders == null || scenicOrders.size() == 0) {
            System.out.println(scenicOrders);
            return new R<>("204", "没有查到数据");
        }
        return new R<>(scenicOrders);
    }

    //根据用户id查询订单
    @PostMapping("/selectByUid")
    public R selectScenicOrderByUserId(HttpServletRequest request, @RequestParam("userId") Integer userId) {
        List<ScenicOrders> scenicOrders = scenicOrdersService.selectScenicOrderByUserId(userId);
        if (scenicOrders == null || scenicOrders.size() == 0) {
            System.out.println(scenicOrders);
            return new R<>("204", "没有查到数据");
        }
        return new R<>(scenicOrders);
    }

    //添加景点订单
    @PostMapping("/insert")
    public R insertScenicOrder(HttpServletRequest request, @RequestBody ScenicOrders scenicOrders) {
        LocalDateTime time = LocalDateTime.now();
        scenicOrders.setSoTime(time);
        boolean result = scenicOrdersService.insertScenicOrder(scenicOrders);
        if (!result) {
            System.out.println(scenicOrders);
            return new R<Scenic>("400 Bad Request", "请求参数错误");
        }
        return new R<Scenic>();
    }

    //根据景点订单ID删除景点订单
    @PostMapping("/delete")
    public R deleteScenic(HttpServletRequest request, @RequestParam("soId") Integer soId) {
        boolean result = scenicOrdersService.deleteScenicOrdersById(soId);
        if (!result) {
            return new R<Scenic>("400 Bad Request", "请求参数错误");
        }
        return new R<Scenic>();
    }


}

