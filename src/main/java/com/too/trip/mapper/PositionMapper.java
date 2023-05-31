package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.too.trip.entity.Position;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface PositionMapper extends BaseMapper<Position> {
    /**
     * 根据位置坐标范围查找景点
     * @param lowLongitude
     * @param upLongitude
     * @param lowLatitude
     * @param upLatitude
     * @return
     */
    List<Position> selectScenicByPositionRange(@Param("lowLongitude") Double lowLongitude,
                                                     @Param("upLongitude") Double upLongitude,
                                                     @Param("lowLatitude") Double lowLatitude,
                                                     @Param("upLatitude") Double upLatitude);
}
