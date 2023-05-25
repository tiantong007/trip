package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.Hotel;
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
public interface HotelMapper extends BaseMapper<Hotel> {
    @Override
    int insert(Hotel entity);

    @Override
    int updateById(Hotel entity);

    @Override
    int deleteById(Hotel entity);

    @Override
    Hotel selectById(Serializable id);

    @Override
    List<Hotel> selectList(Wrapper<Hotel> queryWrapper);
}
