package com.too.trip.service;

import com.too.trip.entity.Room;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface RoomService extends IService<Room> {

    /**
     * 根据酒店ID查询所有可用的房间类型
     * @param hotelId 酒店ID
     * @return 房间类型列表
     */
    List<Room> selectRoomTypeByHotelId(Integer hotelId);

    /**
     * 添加房间
     * @param room 待添加的房间对象
     */
    void insertRoom(Room room);

    /**
     * 根据房间ID查询房间信息
     * @param roomId 房间ID
     * @return 房间对象
     */
    Room selectRoomById(Integer roomId);

    /**
     * 更新房间信息
     * @param room 待更新的房间对象
     */
    void updateRoom(Room room);

    /**
     * 根据房间ID删除房间信息
     * @param roomId 房间ID
     */
    void deleteRoomById(Integer roomId);

    /**
     * 根据酒店ID和房间号码查询房间信息
     * @param hotelId 酒店ID
     * @param roomId 房间号码
     * @return 房间列表
     */
    List<Room> selectRoomByHotelIdAndRoomType(Integer hotelId, String roomtype);
}