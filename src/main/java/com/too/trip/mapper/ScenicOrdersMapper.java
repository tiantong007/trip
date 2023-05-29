package com.too.trip.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.ScenicOrders;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
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
public interface ScenicOrdersMapper extends BaseMapper<ScenicOrders> {
    List<ScenicOrders> selectAll();

    List<ScenicOrders> selectByUserId(@Param("userId") Integer userId);

}
