package com.too.trip.controller;

import com.too.trip.entity.City;
import com.too.trip.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
}
