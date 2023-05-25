package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.Room;
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
public interface RoomMapper extends BaseMapper<Room> {
    @Override
    int insert(Room entity);

    @Override
    int updateById(Room entity);

    @Override
    int deleteById(Room entity);

    @Override
    Room selectById(Serializable id);

    @Override
    List<Room> selectList(Wrapper<Room> queryWrapper);
}
