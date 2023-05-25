package com.too.trip.mapper;

import com.too.trip.entity.User;
import com.too.trip.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author: isixe
 * @create: 2023-05-25 21:57
 * @description: 用户mapper测试
 **/
@SpringBootTest
@Slf4j
public class UserMapperTest {
    @Autowired
    private UserService userService;

    @Test
    public void testSelect() {
        System.out.println(("----- selectAll method test ------"));
        //参数是一个Wrapper，条件结构器，这里先不用 填null
        //查询所有的用户
        User user = userService.getById(1);
        log.info(user.toString());
    }
}
