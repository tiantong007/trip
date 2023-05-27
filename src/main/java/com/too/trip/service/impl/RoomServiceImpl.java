package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.too.trip.entity.Room;
import com.too.trip.mapper.RoomMapper;
import com.too.trip.service.RoomService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Service
public class RoomServiceImpl extends ServiceImpl<RoomMapper, Room> implements RoomService {
    @Autowired RoomMapper roomMapper;
//查找房间类型通过酒店id
    @Override
    public List<Room> selectRoomTypeByHotelId(Integer hotelId) {
        return roomMapper.selectRoomTypeByHotelId(hotelId);
    }
//添加房间
    @Override
    public void insertRoom(Room room) {
        roomMapper.insert(room);
    }
//查找房间通过房间id
    @Override
    public Room selectRoomById(Integer roomId) {
        return roomMapper.selectById(roomId);
    }
//修改房间
    @Override
    public void updateRoom(Room room) {
        roomMapper.updateById(room);
    }
//删除房间
    @Override
    public void deleteRoomById(Integer roomId) {
        roomMapper.deleteById(roomId);
    }
//查找房间通过酒店id和房间id
    @Override
    public List<Room> selectRoomByHotelIdAndRoomType(Integer hotelId, String roomtype) {
        return roomMapper.selectList(
                new QueryWrapper<Room>()
                        .eq("h_id", hotelId)
                        .eq("room_type", roomtype)
        );
    }
}



