package com.too.trip.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.*;
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
@CrossOrigin("*")
@RestController
@RequestMapping("/room")
public class RoomController {

    @Autowired
    private RoomService roomService;
    //处理资源文件
    @Autowired
    private ResourceLoader resourceLoader;

    /**
     * 房间的增加
     *
     * @param file
     * @param room
     * @return 房间实体
     * @throws IOException
     */
    @PostMapping
    public R<Room> insertRoom(@RequestBody @RequestParam("file") MultipartFile file, Room room) throws IOException {
        if (file.isEmpty()) {
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

        File destFile = new File(dir, fileName);
        file.transferTo(destFile);

        // 设置hotel的hotel_img属性
//        scenic.setScienceImg(fileName);
        room.setRoomImg(fileName);
        //boolean isSaveSuccess = hotelService.save(scenic);
        boolean isSaveSuccess = roomService.save(room);
        if (!isSaveSuccess) {
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

    @GetMapping("/page")
    public R<Page> getRoom(@RequestParam(value = "start", defaultValue = "0") Integer pages,
                           @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
                           @RequestParam(value = "field", required = false)String field,
                           @RequestParam(value = "keyword", required = false)String keyword) {

        //页码数小于0 设置为0
        if (pages == null || pages < 0) {
            pages = 0;
        }

        Page<Room> page = roomService.searchPages(pages, pageSize, field, keyword);

        return new R<>(page);
    }


    // 修改房间
    @PutMapping()
    public R updateHotel(@RequestBody(required = false) MultipartFile file, Room room) throws IOException {

        // 如果文件为空则不做变化
        if(file == null || file.isEmpty()){
            room.setRoomImg(room.getRoomImg());
        }else{
            UUID uuid = UUID.randomUUID();
            String fileName = uuid.toString() + file.getOriginalFilename();
            String path = "classpath:/static/images";
            Resource resource = resourceLoader.getResource(path);
            File dir = resource.getFile();

            File destFile  = new File(dir, fileName);
            file.transferTo(destFile);
            room.setRoomImg(fileName);
        }

        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("room_id", room.getRoomId());
        boolean update = roomService.update(room, wrapper);
        if(!update){
            return new R(400,"修改失败");
        }

        return new R();
    }

    @GetMapping("/select/{hotelId}")
    public R selectRoomByHotelId(@RequestBody @PathVariable("hotelId") Integer hId){

        List<Room> rooms = roomService.selectByHotelId(hId);
        if(rooms.size() == 0 || rooms == null){
            return new R(400, "查找失败");
        }
        return new R<>();
    }

}
