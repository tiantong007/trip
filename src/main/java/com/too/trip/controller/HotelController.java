package com.too.trip.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.too.trip.entity.Hotel;
import com.too.trip.entity.R;
import com.too.trip.entity.Scenic;
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
@CrossOrigin("*")
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    @Autowired
    private ResourceLoader resourceLoader;


    /**
     * 查询所有宾馆
     * @return
     */
    @GetMapping("selectAll")
    public R<Page<Hotel>> searchHotel(@RequestParam("start") Integer start, @RequestParam("size") Integer size){

        Page<Hotel> page = hotelService.selectAllHotelByPage(start, size);
        return new R<>(page);
    }


    /**
     * 分页查询
     * @param request
     * @param pages
     * @param pageSize
     * @param field
     * @param keyword
     * @return
     */
    @GetMapping("/page/{start}/{size}/{field}/{keyword}")
    public R<Page<Hotel>> searchPages(HttpServletRequest request, @PathVariable("start") Integer pages, @PathVariable("size") Integer pageSize,
                                      @PathVariable("field")String field, @PathVariable("keyword")String keyword){
        //页码数小于0 设置为0
        if(pages == null || pages < 0){
            pages = 0;
        }
        // 调用searchPage方法
        Page<Hotel> hotels = hotelService.searchPages(pages, pageSize, field, keyword);

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


}
