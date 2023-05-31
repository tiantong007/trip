package com.too.trip.mapper;
import com.too.trip.entity.City;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
import com.too.trip.entity.Scenic;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
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

@Repository
public interface ScenicMapper extends BaseMapper<Scenic> {
    List<Scenic> searchAllScenic();
    Scenic searchScenicById(Integer sid);
    Page<Scenic> selectPage(@Param("page") Page<Scenic> page, @Param("field") String filed, @Param("keyword") String keyword);

    List<String> selectFromImageByScenicId(@Param("scenicId") Integer scenicId);
}
