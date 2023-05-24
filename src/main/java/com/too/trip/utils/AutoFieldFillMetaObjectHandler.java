package com.too.trip.utils;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.reflection.MetaObject;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: isixe
 * @create: 2023-05-24 19:53
 * @description: 重写自动填充策略
 **/
@Slf4j
@Component
public class AutoFieldFillMetaObjectHandler implements MetaObjectHandler {

    /**
     * 插入填充
     * @param metaObject
     */
    @Override
    public void insertFill(MetaObject metaObject) {
        log.info("start insert fill ......");

        this.fillStrategy(metaObject,"c_date", new Date());
        this.fillStrategy(metaObject,"begin_date", new Date());
        this.fillStrategy(metaObject,"end_date", new Date());
        this.fillStrategy(metaObject,"so_time", new Date());

        log.info("end insert fill ......");
    }

    /**
     * 修改填充
     * @param metaObject
     */
    @Override
    public void updateFill(MetaObject metaObject) {
        log.info("start update fill ......");

        this.fillStrategy(metaObject,"c_date", new Date());
        this.fillStrategy(metaObject,"begin_date", new Date());
        this.fillStrategy(metaObject,"end_date", new Date());
        this.fillStrategy(metaObject,"so_time", new Date());

        log.info("end update fill ......");
    }

}

