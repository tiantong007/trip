package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.City;
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
public interface CityMapper extends BaseMapper<City> {
    @Override
    int insert(City entity);

    @Override
    int updateById(City entity);

    @Override
    int deleteById(City entity);

    @Override
    City selectById(Serializable id);

    @Override
    List<City> selectList(Wrapper<City> queryWrapper);
}
