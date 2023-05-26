package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.too.trip.entity.Admin;
import com.too.trip.entity.User;
import com.too.trip.mapper.AdminMapper;
import com.too.trip.mapper.UserMapper;
import com.too.trip.service.AdminService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.ibatis.annotations.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

import java.sql.SQLOutput;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Service
public class AdminServiceImpl extends ServiceImpl<AdminMapper, Admin> implements AdminService {


    @Autowired
    private AdminMapper adminMapper;

    //管理员登陆
    @Override
    public Admin login(String aAccount, String aPassword) {
        QueryWrapper<Admin> wrapper = new QueryWrapper<>();
        wrapper.and(qw -> qw.eq("a_account", aAccount).eq("a_password", aPassword));

        return adminMapper.selectOne(wrapper);
    }


    }

