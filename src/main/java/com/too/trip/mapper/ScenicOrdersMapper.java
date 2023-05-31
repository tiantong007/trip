package com.too.trip.mapper;
import com.too.trip.entity.Order;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.ScenicOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Mapper
@Repository
public interface ScenicOrdersMapper extends BaseMapper<ScenicOrders> {
    List<ScenicOrders> selectAll();

    List<ScenicOrders> selectAllF();

    List<ScenicOrders> selectByUserId(@Param("userId") Integer userId);

    int updateSelective(ScenicOrders scenicOrders);

//    @Select("SELECT science.science_name, Null as hotel_name, Null as room_type, science.science_img, " +
//            "so.price, so.so_status, so.so_time, NULL AS end_date " +
//            "FROM scenic_orders so, scenic science " +
//            "WHERE so.scenic_id = science.scenic_id AND so.user_id = #{userId} " +
//            "UNION ALL " +
//            "SELECT Null, hotel.hotel_name, room.room_type, hotel.hotel_img, room.room_price, " +
//            "ho.status, ho.begin_date, ho.end_date " +
//            "FROM hotel_orders ho, hotel, room " +
//            "WHERE ho.r_id = room.room_id AND room.h_id = hotel.h_id AND ho.u_id = #{userId} " +
//            "ORDER BY so_time DESC")
    @Select("SELECT science.science_name, Null as hotel_name, Null as room_type, science.science_img, science.science_price, " +
            " so.price, so.so_status, so.so_time, NULL AS end_date, so.number " + // 增加number属性
            "FROM scenic_orders so, scenic science " +
            "WHERE so.scenic_id = science.scenic_id AND so.user_id = #{userId} " +
            "UNION ALL " + "SELECT Null, hotel.hotel_name, room.room_type, hotel.hotel_img, ho.price, room.room_price, " +
            "ho.status, ho.begin_date, ho.end_date, ho.number " + // 增加number属性
            "FROM hotel_orders ho, hotel, room " +
            "WHERE ho.r_id = room.room_id AND room.h_id = hotel.h_id AND ho.u_id = #{userId} " +
            "ORDER BY so_time DESC")
    List<Order> getUserOrders(@Param("userId") Integer userId);
//    Map<String, Object> selectByUserIdFromHotelOrdersAndScenicOrders(@Param("userId") Integer userId);


}
