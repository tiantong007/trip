package com.too.trip.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.HotelOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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
public interface HotelOrdersMapper extends BaseMapper<HotelOrders> {
    List<HotelOrders> selectAll();

    int updateSelective(HotelOrders hotelOrders);

}
