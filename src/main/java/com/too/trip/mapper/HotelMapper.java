package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
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
public interface HotelMapper extends BaseMapper<Hotel> {
    /**
     * 查询全部的宾馆信息
     * @return
     */
    List<Hotel> searchAllHotel();

    /**
     * 根据hId查找宾馆
     * @param hId
     * @return
     */
    Hotel selectByHotelId(@Param("hId") Integer hId);

    /**
     * 分页查询
     * @param page 分页对象
     * @param filed
     * @param keyword
     * @return
     */
    Page<Hotel> selectPage(@Param("page") Page<Hotel> page, @Param("field") String filed, @Param("keyword") String keyword);

    Page<Hotel> selectAllByPage(@Param("page") Page<Hotel> page);
}
