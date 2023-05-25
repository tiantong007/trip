package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.Scenic;
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
public interface ScenicMapper extends BaseMapper<Scenic> {
    @Override
    int insert(Scenic entity);

    @Override
    int updateById(Scenic entity);

    @Override
    int deleteById(Scenic entity);

    @Override
    Scenic selectById(Serializable id);

    @Override
    List<Scenic> selectList(Wrapper<Scenic> queryWrapper);
}
