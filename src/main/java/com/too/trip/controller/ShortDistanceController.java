package com.too.trip.controller;

import com.too.trip.utils.DistanceUtil;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
class Position {
    public Position() {
    }

    //景点名
    String name;
    double x;
    double y;

    //有参构造 父节点
    public Position(String name, double x, double y) {
        this.name = name;
        this.x = x;
        this.y = y;
    }
}

public class ShortDistanceController {
    public static void main(String[] args) {
        // 周边景点的列表
        List<Position> points = new ArrayList<>();
        //0为出发点
        points.add(0, new Position("火车站", 118.08055, 24.64267));
        points.add(1, new Position("厦门理工", 118.07981, 24.63927));
        points.add(2, new Position("三期宿舍", 118.09583, 24.63773));
        points.add(3, new Position("上李水库", 118.09644, 24.48541));
        points.add(4, new Position("环东浪漫线", 118.15034, 24.61799));
        DistanceUtil distanceUtil = new DistanceUtil();

        List<List<Position>> perms = permute(points.subList(1, points.size()));
        double mindistance = 999999999;
        List<String> nameList = new ArrayList<>();
//        nameList.add(points.get(0).getName());
        for (List<Position> perm : perms) {
            double distance = 0;
            List<String> tempList = new ArrayList<>();
            tempList.add(points.get(0).getName());
            List<Position> a = new ArrayList<>(perm);
            a.add(0, points.get(0));

            for (int i = 0; i < a.size() - 1; i++) {
                distance += distanceUtil.getDistance(a.get(i).getX(), a.get(i).getY(), a.get(i + 1).getX(), a.get(i + 1).getY());
                tempList.add(a.get(i + 1).getName());
            }

            System.out.println(a);
            if (distance < mindistance) {
                mindistance = distance;
                nameList = tempList;
            }
            System.out.println(distance);
        }
        System.out.println("最短路线为" + String.join("->", nameList));
        System.out.println("最短距离" + mindistance);


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


