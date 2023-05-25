package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.HotelOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface HotelOrdersMapper extends BaseMapper<HotelOrders> {
    @Override
    int insert(HotelOrders entity);

    @Override
    int updateById(HotelOrders entity);

    @Override
    int deleteById(HotelOrders entity);

    @Override
    HotelOrders selectById(Serializable id);

    @Override
    List<HotelOrders> selectList(Wrapper<HotelOrders> queryWrapper);
}
