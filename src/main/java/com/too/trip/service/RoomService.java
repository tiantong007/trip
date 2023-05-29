package com.too.trip.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
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
     * 根据房间ID查询房间信息
     * @param roomId 房间ID
     * @return 房间对象
     */
    Room selectRoomById(Integer roomId);


    Page<Room> searchPages(Integer pages, Integer pageSize, String filed, String keyword);
}