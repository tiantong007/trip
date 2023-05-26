package com.too.trip.mapper;

import com.too.trip.entity.Admin;
import com.too.trip.entity.User;
import com.too.trip.service.AdminService;
import com.too.trip.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AdminMapperTest {
    @Autowired
    private AdminService adminService;

    @Test
    public void testSelect() {
        System.out.println(("----- select method test ------"));
        // 查询管理员
        Admin admin = adminService.getById(1);
        log.info(admin.toString());
    }








}
