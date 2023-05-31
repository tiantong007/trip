package com.too.trip.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.too.trip.entity.*;
import com.too.trip.service.HotelService;
import com.too.trip.service.RoomService;
import io.swagger.models.auth.In;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private ResourceLoader resourceLoader;

    @Autowired
    private RoomService roomService;

    /**
     * 查询所有宾馆
     * @return
     */
    @GetMapping("/selectAll/{start}/{size}")
    public R<Page<Hotel>> searchHotel(@PathVariable("start") Integer start, @PathVariable("size") Integer size){

        Page<Hotel> page = hotelService.selectAllHotelByPage(start, size);
        List<Hotel> records = page.getRecords();
        for(Hotel hotel : records){
            Integer hId = hotel.getHId();
            List<Room> rooms = roomService.selectByHotelId(hId);
            hotel.setRooms(rooms);
        }
        return new R<>(page);
    }


    /**
     * 分页查询
     * @param pages
     * @param pageSize
     * @param field
     * @param keyword
     * @return
     */
    @GetMapping("/page")
    public R<Page<Hotel>> searchPages(@RequestParam(value = "start", defaultValue = "0") Integer pages,
                                      @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
                                      @RequestParam(value = "field", required = false)String field,
                                      @RequestParam(value = "keyword", required = false)String keyword){

        //页码数小于0 设置为0
        if(pages == null || pages < 0){
            pages = 0;
        }
        // 调用searchPage方法
        Page<Hotel> hotels = hotelService.searchPages(pages, pageSize, field, keyword);

        List<Hotel> records = hotels.getRecords();
        for(Hotel hotel : records){
            Integer hId = hotel.getHId();
            List<Room> rooms = roomService.selectByHotelId(hId);
            hotel.setRooms(rooms);
        }
        return new R<>(hotels);
    }


    /**
     * 新增宾馆
     * @param file
     * @param hotel
     * @return
     * @throws IOException
     */
    @PostMapping()
    public R insertHotelUploadFile(@RequestBody @RequestParam("file") MultipartFile file, Hotel hotel) throws IOException {
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
        hotel.setHotelImg(fileName);
        boolean isSaveSuccess = hotelService.save(hotel);
        if(!isSaveSuccess){
            return new R(400, "插入失败");
        }
        return new R();

    }

    /**
     * 宾馆批量删除
     * @return
     */
    @DeleteMapping("/batch")
    public R deleteByHotelIds(@RequestBody Map<String, List<Integer>> json){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Integer>> map = mapper.convertValue(json, Map.class);
        List<Integer> list = map.get("hIds");
        if(list.size() == 0){
            return new R(400,"删除数据不能为空");
        }
        boolean result = hotelService.deleteByHotelIds(list);
        if(!result){
            return new R(200,"没有对应的数据可删除");
        }
        return new R();

    }

    /**
     * 修改酒店
     * @param file
     * @param hotel
     * @return
     */
    @PutMapping()
    public R updateHotel(@RequestBody(required = false) MultipartFile file, Hotel hotel) throws IOException {

        // 如果文件为空则不做变化
        if(file == null || file.isEmpty()){
            hotel.setHotelImg(hotel.getHotelImg());
        }else{
            UUID uuid = UUID.randomUUID();
            String fileName = uuid.toString() + file.getOriginalFilename();
            String path = "classpath:/static/images";
            Resource resource = resourceLoader.getResource(path);
            File dir = resource.getFile();

            File destFile  = new File(dir, fileName);
            file.transferTo(destFile);
            hotel.setHotelImg(fileName);
        }
        System.out.println(hotel);
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("h_id", hotel.getHId());
        boolean update = hotelService.update(hotel, wrapper);
        if(!update){
            return new R(400,"修改失败");
        }

        return new R();
    }

    @GetMapping("selectById/{hId}")
    public R selectByHotelId(@PathVariable("hId") Integer hId){
        Hotel hotel = hotelService.selectByHotelId(hId);
        if(hotel == null){
            return new R(400, "查找失败");
        }
        List<Room> rooms = roomService.selectByHotelId(hotel.getHId());
        hotel.setRooms(rooms);
        return new R(hotel);
    }
}
