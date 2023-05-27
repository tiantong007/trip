package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.too.trip.entity.City;
import com.too.trip.mapper.AdminMapper;
import com.too.trip.mapper.CityMapper;
import com.too.trip.service.CityService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Service
public class CityServiceImpl extends ServiceImpl<CityMapper, City> implements CityService {

    @Autowired
    private  CityMapper cityMapper;

    @Override
    public List<City> listCities(String province, String keyword) {
        QueryWrapper<City> queryWrapper = new QueryWrapper<>();
        if (province != null) {
            queryWrapper.eq("province", province);
        }
        if (keyword != null) {
            queryWrapper.like("city_name", keyword);
        }
        return cityMapper.selectList(queryWrapper);
    }
}
