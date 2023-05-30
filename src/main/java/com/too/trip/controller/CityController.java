package com.too.trip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.too.trip.entity.*;
import com.too.trip.service.CityService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

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
@RequestMapping("/city")
public class CityController {
    @Autowired
    private CityService cityService;

    /**
     * 查询城市列表
     *
     * @param province 所属省份名称，可选
     * @param keyword  城市名称模糊查询关键字，可选
     * @return 城市列表
     */
    @GetMapping("/list")
    public List<City> listCities(@RequestParam(required = false) String province,
                                 @RequestParam(required = false) String keyword) {
        return cityService.listCities(province, keyword);
    }

    //删除城市

    @DeleteMapping("{byCityId}")
    public R deleteByCityId( @PathVariable("byCityId") int cityId){
        boolean result = cityService.deleteByCityId(cityId);
        if(!result){
            return new R<City>(204 ,"找不到对应的城市id");
        }
        return new R<City>();
    }



    //添加城市
    @PostMapping
    public R insertCity(HttpServletRequest request,City city){
        boolean result = cityService.insertCity(city);
        if (! result){
            return new R<City>(400 , "请求参数错误");
        }
        return new R<City>();
    }
    //查询城市
    @GetMapping("{cityId}")
    public R<List<City>> selectByCityId( @PathVariable("cityId") Integer cityId){
        List<City> city = cityService.selectByCityId(cityId);
        if (city == null){
            return new R<>(204, "没有查到数据");
        }
        return new R<>(city);
    }
    //修改城市
    @PutMapping("/update")
    public R updateCity( @RequestBody City city) {

        boolean result = cityService.updateCity(city);
        if (!result) {
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }



    //批量删除
    @DeleteMapping("/batch")
    public R deleteBatchCity(@RequestBody Map<String, List<Integer>> json){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Integer>> map = mapper.convertValue(json, Map.class);
        System.out.println(map.get("cityIds"));
        List<Integer> list = map.get("cityIds");
        boolean result = cityService.deleteBatchCity(list);
        if(!result){
            return new R<Scenic>(400,"请求参数错误");
        }
        return new R<Scenic>();
    }


    //查找所有城市

    @GetMapping
    public R getAllCities(HttpServletRequest request) {
        List<City> city = cityService.getAllCities();
        if (city == null || city.size() == 0) {
            System.out.println(city);
            return new R<>(204, "没有查到数据");
        }
        return new R<>(city);
    }



}
