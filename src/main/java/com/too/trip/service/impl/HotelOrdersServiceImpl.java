package com.too.trip.service.impl;

import com.too.trip.entity.HotelOrders;
import com.too.trip.mapper.HotelOrdersMapper;
import com.too.trip.service.HotelOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Service
public class HotelOrdersServiceImpl extends ServiceImpl<HotelOrdersMapper, HotelOrders> implements HotelOrdersService {

    @Autowired
    private HotelOrdersMapper hotelOrdersMapper;


    @Override
    public List<HotelOrders> selectAllHotelOrder() {
        List<HotelOrders> hotelOrders = hotelOrdersMapper.selectAll();
        return hotelOrders;
    }

    @Override
    public List<HotelOrders> selectAllHotelOrderF() {
        List<HotelOrders> hotelOrders = hotelOrdersMapper.selectAllF();
        return hotelOrders;
    }

    @Override
    public boolean insertHotelOrder(HotelOrders hotelOrders) {
        int row = hotelOrdersMapper.insert(hotelOrders);
        return row > 0;
    }

    @Override
    public boolean deleteHotelOrder(Integer ho_id) {
        int row = hotelOrdersMapper.deleteById(ho_id);
        return row > 0;
    }

    @Override
    public boolean updateHotelOrder(HotelOrders hotelOrders) {
        int row = hotelOrdersMapper.updateSelective(hotelOrders);
        return row > 0;
    }
}
