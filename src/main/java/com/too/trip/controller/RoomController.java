package com.too.trip.controller;

import com.too.trip.entity.Room;
import com.too.trip.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomServiceImpl roomService; // 注入 RoomServiceImpl 服务实现

    /**
     * 根据酒店 ID 查询所有可用的某种房间类型列表
     *
     * @param hotelId 酒店 ID
     * @return 某种房间类型列表
     */
    @GetMapping("/type")
    public List<Room> getRoomTypeByHotelId(@RequestParam("hotelId") Integer hotelId) {
        return roomService.selectRoomTypeByHotelId(hotelId);
    }

    /**
     * 根据房间 ID 查询房间信息
     *
     * @param roomId 房间 ID
     * @return 房间信息
     */
    @GetMapping("{roomId}")
    public Room getRoomById(@PathVariable("roomId") Integer roomId) {
        return roomService.selectRoomById(roomId);
    }

    /**
     * 添加一个新的房间
     *
     * @param room 要添加的房间对象
     */
    @PostMapping
    public void addRoom(@RequestBody Room room) {
        roomService.insertRoom(room);
    }

    /**
     * 更新指定 ID 的房间信息
     *
     * @param roomId 要更新的房间 ID
     * @param room   新的房间信息
     */
    @PutMapping("{roomId}")
    public void updateRoom(@PathVariable("roomId") Integer roomId, @RequestBody Room room) {
        // 设置要更新的房间的 ID
        room.setRoomId(roomId);
        // 调用底层服务来更新房间信息
        roomService.updateRoom(room);
    }

    /**
     * 根据房间 ID 删除指定房间
     *
     * @param roomId 要删除的房间 ID
     */
    @DeleteMapping("{roomId}")
    public void deleteRoomById(@PathVariable("roomId") Integer roomId) {
        roomService.deleteRoomById(roomId);
    }

    /**
     * 根据酒店 ID 和房间类型查询房间列表
     *
     * @param hotelId  酒店 ID
     * @param roomtype 房间类型
     * @return 房间列表
     */
    @GetMapping
    public List<Room> getRooms(@RequestParam("hotelId") Integer hotelId, @RequestParam("roomtype") String roomtype) {
        return roomService.selectRoomByHotelIdAndRoomType(hotelId, roomtype);
    }
}
