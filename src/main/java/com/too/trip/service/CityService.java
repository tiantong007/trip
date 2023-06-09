package com.too.trip.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.City;
import com.baomidou.mybatisplus.extension.service.IService;
import com.too.trip.entity.Comment;

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
   //添加城市
    boolean insertCity(City city);
   //修改城市
    boolean updateCity(City city);
    //删除城市
    boolean deleteByCityId(Integer cityId);


    //根据城市id查询
    List<City> selectByCityId(Integer cityId);
    //批量删除
    boolean deleteBatchCity(List<Integer> list);
    //查询所有城市
    List<City> getAllCities();

    //分页查询
    Page<City> searchPages(Integer pages, Integer pageSize, String filed, String keyword);

}
