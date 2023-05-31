package com.too.trip.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.too.trip.entity.HotelOrders;
import com.too.trip.entity.Position;
import com.too.trip.mapper.HotelOrdersMapper;
import com.too.trip.mapper.PositionMapper;
import com.too.trip.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl extends ServiceImpl<PositionMapper, Position> implements PositionService{

    @Autowired
    private PositionMapper positionMapper;
    @Override
    public List<Position> selectScenicByPositionRange(Double x, Double y) {
        List<Position> positionMappers = positionMapper.selectScenicByPositionRange(x - 0.5, x + 0.5, y - 0.5, y + 0.5);
        return positionMappers;
    }
}
