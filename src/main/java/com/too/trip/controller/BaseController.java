package com.too.trip.controller;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: isixe
 * @create: 2023-05-26 16:23
 * @description: 界面链接转发
 **/
@Controller
@Slf4j
public class BaseController {

    //主页
    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

    //登录注册
    @RequestMapping(value = "/login")
    public String login() {
        return "layout/login.html";
    }

    //后台登录
    @RequestMapping(value = "/admin")
    public String admin() {
        return "admin/admin.html";
    }

    //后台管理界面
    @RequestMapping(value = "/dashboard")
    public String dashboardUser() {
        return "admin/dashboard.html";
    }

    @RequestMapping(value = "/hotel")
    public String dashboardHotel() {
        return "admin/hotel.html";
    }

    @RequestMapping(value = "/city")
    public String dashboardCity() {
        return "admin/city.html";
    }

    @RequestMapping(value = "/comment")
    public String dashboardComment() {
        return "admin/comment";
    }

    @RequestMapping(value = "/room")
    public String dashboardRoom() {
        return "admin/room.html";
    }

    @RequestMapping(value = "scenic")
    public String dashboardScenic() {
        return "admin/scenic.html";
    }

    @RequestMapping(value = "hotelOrder")
    public String dashboardHotelOrder() {
        return "admin/hotel_order.html";
    }

    @RequestMapping(value = "scenicOrder")
    public String dashboardScenicOrder() {
        return "admin/scenic_order.html";
    }

}
