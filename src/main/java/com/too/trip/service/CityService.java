package com.too.trip.service;

import com.too.trip.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface CityService extends IService<City> {
    /**
     * 查询城市列表
     *
     * @param province 所属省份名称，可选
     * @param keyword  城市名称模糊查询关键字，可选
     * @return 城市列表
     */
    List<City> listCities(String province, String keyword);

}
