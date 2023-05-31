package com.too.trip.entity;

import lombok.Data;

@Data
public class Position {
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


