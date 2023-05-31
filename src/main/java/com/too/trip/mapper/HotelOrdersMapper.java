package com.too.trip.mapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.HotelOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.math.BigDecimal;
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

    Page<HotelOrders> selectAllByPage(@Param("page") Page<HotelOrders> page, @Param("field") String filed, @Param("keyword") String keyword);


    //查找房间价格
    @Select("SELECT room_price " +
            "FROM room " +
            "WHERE room_id = #{rId}")
    BigDecimal selectRoomMoney(@Param("rId") Integer rId);

    //查询用户余额
    @Select("SELECT balance " +
            "FROM user " +
            "WHERE user_id = #{uId}")
    BigDecimal selectUserMoney(@Param("uId") Integer uId);

    //扣除用户余额
    @Update("UPDATE user " +
            "set balance = balance - #{price} " +
            "WHERE user_id = #{userId}")
    boolean updateUserMoney(@Param("userId") Integer userId, @Param("price") BigDecimal price);


}
