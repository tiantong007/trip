package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.City;
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
//查找城市列表
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

    //根据城市id删除城市
    @Override
    public boolean deleteByCityId(Integer cityId) {
        int row = cityMapper.deleteByCityId(cityId);
        return row > 0;
    }
    //根据城市id修改城市
    @Override
    public boolean updateCity(City city) {
        return cityMapper.updateById(city) > 0;
    }
    //添加新的城市
    @Override
    public boolean insertCity(City city){
        int row = cityMapper.insert(city);
        return  row>0;

    }
    //分页查询城市
    @Override
    public Page<City> searchPageCity(Integer pages, Integer pageSize, City city) {

        Page<City> page = new Page<>(pages,pageSize);

        cityMapper.selectPage(page, city);

        return page;
    }

    //根据城市id查询
    @Override
    public List<City> selectByCityId(Integer cityId) {

       List<City> city = cityMapper.selectByCityId(cityId);

       return city;
    }
}
