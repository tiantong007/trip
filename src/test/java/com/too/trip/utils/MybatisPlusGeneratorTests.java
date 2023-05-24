package com.too.trip.utils;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

/**
 * @author: isixe
 * @create: 2023-05-23 21:13
 * @description: 启动 MybatisPlusGenerator
 **/
@SpringBootTest
@Slf4j
public class MybatisPlusGeneratorTests {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Test
    void generatorLoads() {
        // 作者
        String author = "isixe";

        // 准备要生产的数据表名列表
        List<String> tables = new ArrayList<>();
        tables.add("admin");
        tables.add("city");
        tables.add("comment");
        tables.add("hotel");
        tables.add("hotel_orders");
        tables.add("room");
        tables.add("scenic");
        tables.add("scenic_orders");
        tables.add("user");

        // 启动
        MybatisPlusGenerator generator = new MybatisPlusGenerator();
        generator.run(dbUrl, dbUsername, dbPassword, tables, author);

    }
}
