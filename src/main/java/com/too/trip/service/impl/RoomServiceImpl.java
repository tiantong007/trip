package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Room;
import com.too.trip.mapper.RoomMapper;
import com.too.trip.service.RoomService;
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
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Autowired
    RoomMapper roomMapper;

    @Override
    public Room selectRoomById(Integer roomId) {
        return roomMapper.selectById(roomId);
    }

    @Override
    public Page<Room> searchPages(Integer pages, Integer pageSize, String filed, String keyword) {
        Page<Room> page = new Page<>(pages, pageSize);
        roomMapper.selectPages(page, pageSize, filed, keyword);
        return page;
    }

    @Override
    public List<Room> selectByHotelId(Integer hId) {
        QueryWrapper<Room> queryWrapper =  new QueryWrapper<Room>();
        queryWrapper.eq("h_id", hId);
        List<Room> rooms = roomMapper.selectList(queryWrapper);
        return rooms;
    }


}



