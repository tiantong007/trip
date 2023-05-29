package com.too.trip.service;

import com.too.trip.entity.ScenicOrders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

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

        //添加景点订单
        public boolean insertScenicOrder(ScenicOrders scenicOrders);

        //删除景点订单
        public boolean deleteScenicOrdersById(Integer so_id);

        //景点订单状态更新
        public boolean updateScenicOrder(ScenicOrders scenicOrders);

}
