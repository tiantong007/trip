package com.too.trip.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.HotelOrders;
import com.too.trip.entity.Order;
import com.too.trip.entity.ScenicOrders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author 15110
 * @description 针对表【scenic_orders】的数据库操作Service
 * @createDate 2023-05-29 10:31:10
 */
public interface ScenicOrdersService extends IService<ScenicOrders> {

    //查询所有景点订单
    List<ScenicOrders> selectAllScenicOrder();

    //根据用户ID查询查询景点订单
    List<ScenicOrders> selectScenicOrderByUserId(Integer uid);

    //查询所有酒店订单(前端)
    List<ScenicOrders> selectAllScenicOrderF();

    //根据用户ID查询酒店订单+景点订单
    List<Order> getUserOrders(Integer uid);

    //添加景点订单
    public boolean insertScenicOrder(ScenicOrders scenicOrders);

    //删除景点订单
    public boolean deleteScenicOrdersById(Integer so_id);

    //景点订单状态更新
    public boolean updateScenicOrder(ScenicOrders scenicOrders);

    //判断用户账户是否合理
    public boolean determineUserAmount(ScenicOrders scenicOrders);

    //查询景点价格
    BigDecimal selectScenicMoney(Integer scenicId);
}
