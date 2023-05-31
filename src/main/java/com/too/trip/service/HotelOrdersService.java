package com.too.trip.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.HotelOrders;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface HotelOrdersService extends IService<HotelOrders> {
        //查询所有酒店订单
        Page<HotelOrders>  selectAllHotelOrder(Integer pages, Integer pageSize,  String filed, String keyword);


        //        //根据酒店名搜索
//        List<HotelOrders> selectHotelOrderByH
        //插入酒店订单
        public boolean insertHotelOrder(HotelOrders hotelOrders);

        //删除景点订单
        public boolean deleteHotelOrder(Integer ho_id);

        //更新景点订单
        public boolean updateHotelOrder(HotelOrders hotelOrders);
}
