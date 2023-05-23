package com.too.trip.utils;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
public class MybatisPlusGeneratorApplicationTests {
    @Value("${spring.datasource.url}")
    private String dbUrl;

    @Value("${spring.datasource.username}")
    private String dbUsername;

    @Value("${spring.datasource.password}")
    private String dbPassword;

    @Test
    void generatorLoads() {
        List<String> tables = new ArrayList<>();
        tables.add("t_admin");
        tables.add("t_user");
        MybatisPlusGenerator generator = new MybatisPlusGenerator();
        generator.run(dbUrl, dbUsername, dbPassword, tables);
    }
}
