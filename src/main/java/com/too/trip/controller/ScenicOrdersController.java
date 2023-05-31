package com.too.trip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.too.trip.entity.Order;
import com.too.trip.entity.R;
import com.too.trip.entity.Scenic;
import com.too.trip.entity.ScenicOrders;
import com.too.trip.service.ScenicOrdersService;
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
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/scenic-orders")
public class ScenicOrdersController {
    @Autowired
    private ScenicOrdersService scenicOrdersService;

    //查询所有订单
    @GetMapping("/selectAll")
    public R selectScenicOredrsAll(HttpServletRequest request) {
        List<ScenicOrders> scenicOrders = scenicOrdersService.selectAllScenicOrder();
        if (scenicOrders == null || scenicOrders.size() == 0) {
            System.out.println(scenicOrders);
            return new R<>(204, "没有查到数据");
        }
        return new R<>(scenicOrders);
    }

    //查询所有订单(前端)
    @GetMapping("/page")
    public R selectScenicOrdersAllF(@RequestParam(value = "start", defaultValue = "0") Integer pages,
                                    @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
                                    @RequestParam(value = "field", required = false)String field,
                                    @RequestParam(value = "keyword", required = false)String keyword) {
        Page<ScenicOrders> page = scenicOrdersService.selectAllByPage(pages, pageSize, field, keyword);
        if (page.getRecords() == null || page.getRecords().size() == 0) {
            return new R<>(400, "查询失败");
        }
        return new R<>(page);
    }

    //根据用户id查询订单
    @GetMapping("/selectByUid")
    public R selectScenicOrderByUserId(HttpServletRequest request, @RequestParam("userId") Integer userId) {
        List<ScenicOrders> scenicOrders = scenicOrdersService.selectScenicOrderByUserId(userId);
        if (scenicOrders == null || scenicOrders.size() == 0) {
            System.out.println(scenicOrders);
            return new R<>(204, "没有查到数据");
        }
        return new R<>(scenicOrders);
    }

    //根据用户ID查询酒店订单+景点订单
    @GetMapping("/getUserOrder")
    public R<List<Order>> getUserOrders(HttpServletRequest request, @RequestParam("userId") Integer userId) {
        List<Order> orders = scenicOrdersService.getUserOrders(userId);
        System.out.println("ffffffff" + orders);
        if (orders == null || orders.size() == 0) {
            return new R<>(204, "没有查到数据");
        }
        return new R<>(orders);
    }

    //添加景点订单
    @PostMapping()
    public R insertScenicOrder(HttpServletRequest request, @RequestBody ScenicOrders scenicOrders) {
        //定义订单时间
        LocalDateTime time = LocalDateTime.now();
        scenicOrders.setSoTime(time);
        //判断数量是否合理
        if (scenicOrders.getNumber()<=0){
            return new R(400,"数量输入错误");
        }

        //获取景点价格并给订单
        BigDecimal scenicMoney = scenicOrdersService.selectScenicMoney(scenicOrders.getScenicId());
        scenicOrders.setSciencePrice(scenicMoney);

        //判断用户余额是否合理
        BigDecimal price = scenicOrders.getSciencePrice().multiply(BigDecimal.valueOf(scenicOrders.getNumber()));
        scenicOrders.setPrice(price);
        boolean result = scenicOrdersService.determineUserAmount(scenicOrders);
        if (result){
            return new R(400,"用户余额不足");
        }
        result = scenicOrdersService.insertScenicOrder(scenicOrders);
        if (!result) {
            System.out.println(scenicOrders);
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    //根据景点订单ID删除景点订单
    @DeleteMapping()
    public R deleteScenicOrder(HttpServletRequest request, @RequestParam("soId") Integer soId) {
        boolean result = scenicOrdersService.deleteScenicOrdersById(soId);
        if (!result) {
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    //更新景点订单
    @PutMapping()
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
            return new R(400,"没有对应的数据可删除");
        }
        return new R();

    }

}

