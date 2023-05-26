package com.too.trip.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author: isixe
 * @create: 2023-05-26 16:23
 * @description: 界面链接转发
 **/
@Controller
public class BaseController {

    //主页
    @RequestMapping(value = "/")
    public String index() {
        return "index.html";
    }

    //登录注册
    @RequestMapping(value = "login")
    public String login() {
        return "layout/login.html";
    }

    //后台
    @RequestMapping(value = "admin")
    public String admin() {
        return "layout/admin.html";
    }
}
