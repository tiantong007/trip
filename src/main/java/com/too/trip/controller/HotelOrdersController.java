package com.too.trip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
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
@RequestMapping("/hotel-orders")
public class HotelOrdersController {

    @Autowired
    private HotelOrdersService hotelOrdersService;

    //查询所有酒店订单
    @GetMapping("/page")
    public R selectHotelOredrsAll(@RequestParam(value = "start", defaultValue = "0") Integer pages,
                                  @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
                                  @RequestParam(value = "field", required = false)String field,
                                  @RequestParam(value = "keyword", required = false)String keyword) {
        Page<HotelOrders> page = hotelOrdersService.selectAllHotelOrder(pages, pageSize, field, keyword);
        if (page.getRecords() == null){
            return new R<>(400, "查询失败");
        }
        return new R<>(page);
    }

    //查询所有酒店(前端用)
    @GetMapping("/selectAllF")
    public R selectHotelOredrsAllF(HttpServletRequest request) {
       return new R();
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
    @DeleteMapping("/delete")
    public R deleteHotelOrder(HttpServletRequest request, @RequestParam("hoId") Integer hoId) {
        boolean result = hotelOrdersService.deleteHotelOrder(hoId);
        if (!result) {
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    //批量删除酒店订单
    @DeleteMapping("batch")
    public R deleteByBatch(@RequestBody Map<String, List<Integer>> json) {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Integer>> map = mapper.convertValue(json, Map.class);
        List<Integer> hoIds = map.get("hoIds");
        if (hoIds.size() == 0) {
            return new R(400, "删除数据不能为空");
        }
        boolean result = hotelOrdersService.removeBatchByIds(hoIds);
        if (!result) {
            return new R(200, "没有对应的数据可删除");
        }
        return new R();

    }

    //更新酒店订单
    @PutMapping("/update")
    public R updateHotelOrder(HttpServletRequest request, @RequestBody HotelOrders hotelOrders) {
        boolean result = hotelOrdersService.updateHotelOrder(hotelOrders);
        if (!result) {
            return new R<HotelOrders>(400, "请求参数错误");
        }
        return new R<HotelOrders>();
    }

}
