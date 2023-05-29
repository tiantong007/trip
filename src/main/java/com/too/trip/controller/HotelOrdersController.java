package com.too.trip.controller;

import com.too.trip.entity.HotelOrders;
import com.too.trip.entity.R;
import com.too.trip.entity.Scenic;
import com.too.trip.entity.ScenicOrders;
import com.too.trip.service.HotelOrdersService;
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
@CrossOrigin("*")
@RequestMapping("/hotel-orders")
public class HotelOrdersController {

    @Autowired
    private HotelOrdersService hotelOrdersService;

    //查询所有酒店
    @PostMapping("/selectAll")
    public R selectHotelOredrsAll(HttpServletRequest request) {
        List<HotelOrders> hotelOrders = hotelOrdersService.selectAllHotelOrder();
        if (hotelOrders == null || hotelOrders.size() == 0) {
            System.out.println(hotelOrders);
            return new R<>(204, "没有查到数据");
        }
        return new R<>(hotelOrders);
    }

    //添加酒店订单
    @PostMapping("/insert")
    public R insertHotelOrder(HttpServletRequest request, @RequestBody HotelOrders hotelOrders) {
        LocalDateTime time = LocalDateTime.now();
        hotelOrders.setBeginDate(time);
        System.out.println("aaaaaa" + hotelOrders);
        boolean result = hotelOrdersService.insertHotelOrder(hotelOrders);
        if (!result) {
            System.out.println(hotelOrders);
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    //根据酒店订单ID删除酒店订单
    @PostMapping("/delete")
    public R deleteHotelOrder(HttpServletRequest request, @RequestParam("hoId") Integer hoId) {
        boolean result = hotelOrdersService.deleteHotelOrder(hoId);
        if (!result) {
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    //更新酒店订单
    @PostMapping("/update")
    public R updateHotelOrder(HttpServletRequest request, @RequestBody HotelOrders hotelOrders) {
        LocalDateTime time = LocalDateTime.now();
        hotelOrders.setBeginDate(time);
        boolean result = hotelOrdersService.updateHotelOrder(hotelOrders);
        if (!result) {
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

}
