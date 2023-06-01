package com.too.trip.controller;

import com.too.trip.entity.Position;
import com.too.trip.service.PositionService;
import com.too.trip.utils.DistanceUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/route")
public class ShortDistanceController {
    @Autowired
    private PositionService positionService;

    @PostMapping("/calculate")
    public List<String> calculateShortestPath(@RequestParam("x0") Double x0,
                                              @RequestParam("y0") Double y0) {
        {
            List<Position> points = new ArrayList<>();

            //获取列表循环添加   pointList为周边景点列表（数据库中获取）
//            List<Position> positions = positionService.selectScenicByPositionRange(x0, y0);
//            if (positions == null || positions.size() == 0){
//                System.out.println(1);
//            }
            List<Position> pointList = positionService.selectScenicByPositionRange(x0, y0);
            System.out.println("aaaaaaaaaaaa" + pointList);
            for (int i; pointList.size() > 0; pointList.remove(0), i++) {
                points.add(i = 0, new Position(pointList.get(i).getName(), pointList.get(i).getX(), pointList.get(i).getY()));
            }
            points.add(0, new Position("我的位置", x0, y0));
//            points.add(1, new Position("厦门理工", 118.07981, 24.63927));
//            points.add(2, new Position("三期宿舍", 118.09583, 24.63773));
//            points.add(3, new Position("上李水库", 118.09644, 24.48541));
//            points.add(4, new Position("环东浪漫线", 118.15034, 24.61799));
            DistanceUtil distanceUtil = new DistanceUtil();
            List<List<Position>> perms = permute(points.subList(1, points.size()));
            double mindistance = 999999999;
            List<String> nameList = new ArrayList<>();
            for (List<Position> perm : perms) {
                double distance = 0;
                List<String> tempList = new ArrayList<>();
                tempList.add(points.get(0).getName());
                List<Position> a = new ArrayList<>(perm);
                a.add(0, points.get(0));
                int dFlag = 0;
                for (int i = 0; i < a.size() - 1; i++) {
                    distance += distanceUtil.getDistance(a.get(i).getX(), a.get(i).getY(), a.get(i + 1).getX(), a.get(i + 1).getY());
                    tempList.add(a.get(i + 1).getName());
                    if (distance > mindistance) {
                        dFlag = 1;
                        break;
                    }
                    if (dFlag == 1) {
                        dFlag = 0;
                        continue;
                    }
//                    System.out.println(a);
                }
                if (distance < mindistance) {
                    mindistance = distance;
                    nameList = tempList;
                }
            }
            System.out.println("最短路线为" + String.join("->", nameList));
            System.out.println("最短距离" + mindistance);
            System.out.println("aaaaaa" + nameList);
            return nameList;
        }
    }

    public static List<List<Position>> permute(List<Position> nums) {
        List<List<Position>> result = new ArrayList<>();
        if (nums.size() == 1) {
            result.add(new ArrayList<>(nums));
        } else {
            for (int i = 0; i < nums.size(); i++) {
                Position num = nums.get(i);
                nums.remove(i);
                List<List<Position>> perms = permute(nums);
                for (List<Position> perm : perms) {
                    perm.add(num);
                    result.add(perm);
                }
                nums.add(i, num);
            }
        }
        return result;
    }

}


