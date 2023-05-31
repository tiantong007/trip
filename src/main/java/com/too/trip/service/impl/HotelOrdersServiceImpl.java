package com.too.trip.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.HotelOrders;
import com.too.trip.mapper.HotelOrdersMapper;
import com.too.trip.service.HotelOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
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
    public Page<HotelOrders> selectAllHotelOrder(Integer pages, Integer pageSize, String filed, String keyword) {
        Page<HotelOrders> page = new Page<>(pages, pageSize);
        hotelOrdersMapper.selectAllByPage(page, filed, keyword);
        return page;
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

    //判断入住天数
    @Override
    public long determineNumberDays(LocalDateTime star, LocalDateTime end) {
        LocalDate date1 = star.toLocalDate();
        LocalDate date2 = end.toLocalDate();
        long days = ChronoUnit.DAYS.between(date1, date2);
        return days;
    }

    //查询房间金额
    @Override
    public BigDecimal selectRoomMoney(Integer rId) {
        BigDecimal bigDecimal = hotelOrdersMapper.selectRoomMoney(rId);
        return bigDecimal;
    }
    //查询用户余额
    @Override
    public BigDecimal selectUserMoney(Integer uId) {
        BigDecimal bigDecimal = hotelOrdersMapper.selectUserMoney(uId);
        return bigDecimal;
    }

    @Override
    public boolean updateUserMoney(Integer uId, BigDecimal price) {
        boolean b = hotelOrdersMapper.updateUserMoney(uId, price);
        return b;
    }
}
