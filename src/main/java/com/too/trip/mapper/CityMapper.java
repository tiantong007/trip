package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.City;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.too.trip.entity.Hotel;
import com.too.trip.entity.Scenic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Mapper
@Repository
public interface CityMapper extends BaseMapper<City> {
    @Select("SELECT * FROM city WHERE city_name LIKE CONCAT('%', #{keyword}, '%') AND province = #{province}")
    List<City> selectByKeywordAndProvince(@Param("keyword") String keyword, @Param("province") String province);

    List<City> selectByCityId(@Param("cityId") Integer cityId);

    int deleteByCityId(@Param("cityId") Integer cityId);

    int updateCityName(@Param("cityName") String cityName);

    int insertSelective(City city);


}
