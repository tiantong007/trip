package com.too.trip.controller;

import com.too.trip.entity.Hotel;
import com.too.trip.entity.R;
import com.too.trip.entity.User;
import com.too.trip.service.HotelService;
import io.swagger.models.auth.In;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

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
@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;

    //查询全部宾馆信息
    @PostMapping("/all")
    public R<List> getAllHotel(HttpServletRequest request){
        List<Hotel> hotels = hotelService.searchAllHotel();
        if (hotels == null || hotels.size() == 0){
            return new R<>("204", "没有查到数据");
        }
        return new R<>(hotels);
    }

    //查询单个宾馆信息
    @PostMapping("single")
    public R<Hotel> searchHotel(HttpServletRequest request, @RequestParam("hId") Integer hId){
        Hotel hotel = hotelService.searchById(hId);
        if (hotel == null){
            return new R<>("204", "没有查到数据");
        }
        return new R<>(hotel);
    }

    @PostMapping("/delete")
    public R<Hotel> deleteHotel(HttpServletRequest request, @RequestParam("hId") Integer hId){
        boolean result = hotelService.removeById(hId);
        if(!result){
            return new R<Hotel>("204 Not Found", "找不到对应的宾馆id");
        }
        return new R<Hotel>();
    }


    //分页查询
    @PostMapping("/page")
    public R<List> searchPage(HttpServletRequest request, @RequestParam("pages") Integer pages, @RequestParam("pageSize") Integer pageSize, Hotel hotel){
        //页码数小于0 设置为0
        if(pages == null || pages < 0){
            pages = 0;
        }
        // 调用searchPage方法
        List<Hotel> hotels = hotelService.searchPage(pages, pageSize, hotel);
        if (hotels == null || hotels.size() == 0){
            return new R<>("204", "没有查到数据");
        }
        return new R<>(hotels);
    }

}
