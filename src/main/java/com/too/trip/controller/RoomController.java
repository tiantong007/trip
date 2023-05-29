package com.too.trip.controller;

import com.too.trip.entity.R;
import com.too.trip.entity.Room;
import com.too.trip.entity.Scenic;
import com.too.trip.service.RoomService;
import com.too.trip.service.impl.RoomServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

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
    //处理资源文件
    @Autowired
    private ResourceLoader resourceLoader;



    @PostMapping("insert")
    public R insertScenic(@RequestBody @RequestParam("file") MultipartFile file, Room room) throws IOException {
        if(file.isEmpty()){
            return new R(400, "文件不能为空");
        }

        // 通用标识符 UUID
        UUID uuid = UUID.randomUUID();

        // 获取文件名
        String fileName = uuid.toString() + file.getOriginalFilename();

        // 构建文件保存路径 resources/static/images
        String path = "classpath:/static/images";
        Resource resource = resourceLoader.getResource(path);
        File dir = resource.getFile();

        File destFile  = new File(dir, fileName);
        file.transferTo(destFile);

        // 设置hotel的hotel_img属性
//        scenic.setScienceImg(fileName);
        room.setRoomImg(fileName);
        //boolean isSaveSuccess = hotelService.save(scenic);
        boolean isSaveSuccess = roomService.save(room);
        if(!isSaveSuccess){
            return new R(400, "插入失败");
        }
        return new R();
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
