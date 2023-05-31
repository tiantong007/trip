package com.too.trip.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.too.trip.entity.Position;
import org.springframework.stereotype.Service;

import java.util.List;


public interface PositionService extends IService<Position> {
    List<Position> selectScenicByPositionRange(Double x, Double y);
}
