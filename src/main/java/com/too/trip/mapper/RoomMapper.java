package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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
public interface RoomMapper extends BaseMapper<Room> {

    /**
     * 根据酒店ID查询所有可用的某种房间类型
     * @param hotelId 酒店ID
     * @return 某种房间类型列表
     */
    @Select("select * from room where h_id = #{hotelId} and room_type = 1")
    List<Room> selectRoomTypeByHotelId(@Param("hotelId") Integer hotelId);

    /**
     * 根据酒店ID和房间号码查询房间信息
     * @param hotelId 酒店ID
     * @param roomId 房间号码
     * @return 房间列表
     */
    @Select("SELECT * FROM room WHERE hotel_id = #{hotelId} AND room_id = #{roomId}")
    List<Room> selectRoomByHotelIdAndRoomType(@Param("hotelId") Integer hotelId, @Param("roomtype") String roomtype);
}
