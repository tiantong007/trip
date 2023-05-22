package com.too.trip.service.impl;

import com.too.trip.entity.Admin;
import com.too.trip.mapper.AdminMapper;
import com.too.trip.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    private AdminMapper adminMapper;

    @Override
    public Admin login(String account, String password) {
        Admin admin = adminMapper.isExistsByActAndPsd(account, password);
        return admin;
    }
}
