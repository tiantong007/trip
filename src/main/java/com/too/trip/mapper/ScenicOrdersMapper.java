package com.too.trip.mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Order;
import com.too.trip.entity.Scenic;
import org.apache.ibatis.annotations.Param;

import com.too.trip.entity.ScenicOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

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

    Page<Scenic> selectAllByPage(@Param("page") Page<ScenicOrders> page, @Param("field") String filed, @Param("keyword") String keyword);

    List<ScenicOrders> selectByUserId(@Param("userId") Integer userId);

    int updateSelective(ScenicOrders scenicOrders);

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
    //扣除用户金钱
    @Update("UPDATE user " +
            "set balance = balance - #{price} " +
            "WHERE user_id = #{userId}")
    boolean updateUserMoney(@Param("userId") Integer userId, @Param("price") BigDecimal price);

    //查询用户金钱
    @Select("select balance " +
            "FROM user " +
            "WHERE user_id = #{userId}")
    BigDecimal selectUsermoney(@Param("userId") Integer userId);

    //查找景点价格
    @Select("select science_price " +
            "FROM scenic " +
            "WHERE scenic_id = #{scenicId}")
    BigDecimal selectScenicMoney(@Param("scenicId") Integer scenicId);
}
