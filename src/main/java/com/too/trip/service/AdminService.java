package com.too.trip.service;

import com.too.trip.entity.Admin;


public interface AdminService {
    Admin login(String account, String password);
}
