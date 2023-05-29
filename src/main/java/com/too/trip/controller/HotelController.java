package com.too.trip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
import com.too.trip.entity.R;
import com.too.trip.entity.User;
import com.too.trip.service.HotelService;
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
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private ResourceLoader resourceLoader;


    //查询单个宾馆信息
    @PostMapping("single")
    public R<Hotel> searchHotel(HttpServletRequest request, @RequestParam("hId") Integer hId){
        Hotel hotel = hotelService.searchById(hId);
        if (hotel == null){
            return new R<>(400, "没有查到数据");
        }
        return new R<>(hotel);
    }


    //分页查询
    @GetMapping()
    public R<Page<Hotel>> searchPages(HttpServletRequest request, @RequestParam("pages") Integer pages, @RequestParam("pageSize") Integer pageSize, Hotel hotel){
        //页码数小于0 设置为0
        if(pages == null || pages < 0){
            pages = 0;
        }
        // 调用searchPage方法
        Page<Hotel> hotels = hotelService.searchPages(pages, pageSize, hotel);

        return new R<>(hotels);
    }

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

}
