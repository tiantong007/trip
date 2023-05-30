package com.too.trip.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.too.trip.entity.HotelOrders;
import com.too.trip.entity.Order;
import com.too.trip.entity.ScenicOrders;
import com.too.trip.service.ScenicOrdersService;
import com.too.trip.mapper.ScenicOrdersMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author 15110
 * @description 针对表【scenic_orders】的数据库操作Service实现
 * @createDate 2023-05-29 10:31:10
 */
@Service
public class ScenicOrdersServiceImpl extends ServiceImpl<ScenicOrdersMapper, ScenicOrders>


        implements ScenicOrdersService {
    @Autowired
    private ScenicOrdersMapper scenicOrdersMapperl;

    @Override
    public List<ScenicOrders> selectAllScenicOrder() {
        List<ScenicOrders> scenicOrders = scenicOrdersMapperl.selectAll();
        return scenicOrders;
    }

    @Override
    public List<ScenicOrders> selectAllScenicOrderF() {
        List<ScenicOrders> scenicOrders = scenicOrdersMapperl.selectAllF();
        return scenicOrders;
    }

    @Override
    public List<ScenicOrders> selectScenicOrderByUserId(Integer uid) {
        List<ScenicOrders> scenicOrders = scenicOrdersMapperl.selectByUserId(uid);
        return scenicOrders;
    }


    @Override
    public List<Order> getUserOrders(Integer uid) {
//        System.out.println(scenicOrdersMapperl.getUserOrders(uid));
        List<Order> orders = scenicOrdersMapperl.getUserOrders(uid);
        return orders;
    }

    @Override
    public boolean insertScenicOrder(ScenicOrders scenicOrders) {
        int row = scenicOrdersMapperl.insert(scenicOrders);
        return row > 0;
    }

    @Override
    public boolean deleteScenicOrdersById(Integer so_id) {
        int row = scenicOrdersMapperl.deleteById(so_id);
        return row > 0;
    }

    @Override
    public boolean updateScenicOrder(ScenicOrders scenicOrders) {
        int row = scenicOrdersMapperl.updateSelective(scenicOrders);
        return row > 0;
    }
}




