package com.too.trip.controller;

import com.too.trip.entity.R;
import com.too.trip.entity.Room;
import com.too.trip.service.RoomService;
import com.too.trip.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */

@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;

    /**
     * 房间增加
     *
     * @param room 要添加的房间对象
     */
    @PostMapping
    public R<Room> addRoom(@RequestBody Room room) {
        boolean flag = roomService.save(room);

        if (!flag) {
            return new R<>(400, "添加失败");
        }

        return new R<>();
    }

    /**
     * 房间的ID查询
     *
     * @param roomId
     * @return Room
     */
    @GetMapping("/{roomId}")
    public R<Room> getRoomById(@PathVariable("roomId") Integer roomId) {
        Room room = roomService.selectRoomById(roomId);
        return new R<>(room);
    }

    /**
     * 房间ID删除
     *
     * @param roomId
     * @return R
     */
    @DeleteMapping("/{roomId}")
    public R<Room> deleteRoomById(@PathVariable("roomId") Integer roomId) {
        boolean flag = roomService.removeById(roomId);
        if (!flag) {
            return new R<Room>(404, "找不到对应的房间id");
        }
        return new R<>();
    }

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
