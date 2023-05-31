package com.too.trip.controller;

import com.too.trip.entity.Position;
import com.too.trip.entity.R;
import com.too.trip.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/position")
public class PositionController {

    @Autowired
    private PositionService positionService;
    @GetMapping
    public R selectScenicByPositionRange(@RequestParam("x") Double x, @RequestParam("y") Double y){
        List<Position> positions = positionService.selectScenicByPositionRange(x, y);
        if (positions == null || positions.size() == 0){
            return new R(400, "查找失败");
        }
        return new R(positions);
    }
}
