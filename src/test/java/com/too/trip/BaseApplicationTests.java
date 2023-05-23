package com.too.trip;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author: isixe
 * @create: 2023-05-23 21:13
 * @description: 数据库连接测试
 **/
@SpringBootTest
class BaseApplicationTests {
    @Autowired
    private DataSource dataSource;

    @Test
    void contextLoads() {
    }

    @Test
    void datasourceLoads() {
        //查看数据源
        System.out.println(dataSource.getClass());
        //获得数据库连接
        try {
            Connection connection = dataSource.getConnection();
            System.out.println(connection);
            //关闭连接
            connection.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
