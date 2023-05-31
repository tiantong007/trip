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

import java.math.BigDecimal;
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
//        LocalDateTime time = LocalDateTime.now();
//        hotelOrders.setBeginDate(time);
        //1.计算酒店订单用户入住天数(如果为负数则日期错误）
        LocalDateTime beginDate = hotelOrders.getBeginDate();
        LocalDateTime endDate = hotelOrders.getEndDate();
        long day = hotelOrdersService.determineNumberDays(beginDate, endDate);
        if (day<0){
            return new R<Scenic>(400, "入住时间错误");
        }
        //酒店数量进行判断不能为负数
        Integer number = hotelOrders.getNumber();
        if (number<0){
            return new R<Scenic>(400, "房间数量错误");
        }
        //2.获取当前酒店房间的价格
        BigDecimal roomMoney = hotelOrdersService.selectRoomMoney(hotelOrders.getRId());
        //计算当前订单总价格=房间价格*入住天数*预定房间数量
        BigDecimal sumPrice = roomMoney.multiply(BigDecimal.valueOf(number).multiply(BigDecimal.valueOf(day))) ;
        //将酒店价格set到对象中
        hotelOrders.setPrice(sumPrice);
        //获取用户金额
        BigDecimal userMoney = hotelOrdersService.selectUserMoney(hotelOrders.getUId());
        //3.判断用户金钱是否大于等于当前订单总价格
//        if (usermoney.compareTo(BigDecimal.ZERO) >0 && usermoney.compareTo(scenicOrders.getPrice()) > 0)
        if (userMoney.compareTo(BigDecimal.ZERO) <=0 || userMoney.compareTo(sumPrice) < 0){
            return new R<Scenic>(400, "用户余额不足");
        }
        //4.添加数据到数据库
        boolean result = hotelOrdersService.insertHotelOrder(hotelOrders);
        if (!result) {
            System.out.println(hotelOrders);
            return new R<Scenic>(400, "请求参数错误");
        }
        //用户减少对应价格
        boolean b = hotelOrdersService.updateUserMoney(hotelOrders.getUId(), sumPrice);
        if (!b) {
            System.out.println(hotelOrders);
            return new R<Scenic>(400, "减少用户价格错误");
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
