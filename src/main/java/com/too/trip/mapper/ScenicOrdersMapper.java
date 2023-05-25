package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.ScenicOrders;
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
public interface ScenicOrdersMapper extends BaseMapper<ScenicOrders> {
    @Override
    int insert(ScenicOrders entity);

    @Override
    int updateById(ScenicOrders entity);

    @Override
    int deleteById(ScenicOrders entity);

    @Override
    ScenicOrders selectById(Serializable id);

    @Override
    List<ScenicOrders> selectList(Wrapper<ScenicOrders> queryWrapper);
}
