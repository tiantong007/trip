package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Room;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.too.trip.entity.Scenic;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
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
public interface RoomMapper extends BaseMapper<Room> {
    Page<Room> selectPages(@Param("page") Page<Room> page, Integer pageSize, @Param("field") String filed, @Param("keyword") String keyword);

}
