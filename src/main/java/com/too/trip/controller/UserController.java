package com.too.trip.controller;

import com.too.trip.entity.R;
import com.too.trip.entity.User;
import com.too.trip.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * 前端控制器
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@Slf4j
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    @ResponseBody
    public R addUer(User user) {
        String username = user.getUsername();
        String email = user.getEmail();

        //用户名或邮箱是否已注册
        boolean flag = userService.isExist(username, email);
        if (!flag) {
            //用户注册更新用户信息到数据库
            userService.save(user);
            //返回注册成功信息
            return new R<User>();
        }

        //如果用户名和邮箱已经注册，返回错误信息
        return new R<>("409 Conflict", "用户名或邮箱已被注册");
    }

    @PostMapping(value = "/login")
    public R selectUser(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        //判断登录，登录成功则返回用户信息
        User user = userService.login(username, password);
        if (user == null) {
            return new R<User>("400 Bad Request", "用户名或密码错误");
        }

        //将信息保存进session
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getUserId());
        session.setAttribute("username", user.getUsername());

        return new R<User>(user);
    }
}
