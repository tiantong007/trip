package com.too.trip.controller;

import com.too.trip.entity.Admin;
import com.too.trip.entity.R;
import com.too.trip.entity.User;
import com.too.trip.service.AdminService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;



    @PostMapping(value = "/login")
    public R selectAdmin(HttpServletRequest request, @RequestParam String aAccount, @RequestParam String aPassword) {
        //判断登录，登录成功则返回用户信息
        Admin admin = adminService.login(aAccount,aPassword);
        if (admin == null){
            return new R<Admin>(400,"用户名或密码错误");
        }

        //将信息保存进session
        HttpSession session = request.getSession();
        session.setAttribute("a_account",admin.getAAccount());
        session.setAttribute("a_password",admin.getAPassword());

        return new R<Admin>(admin);
    }
}
