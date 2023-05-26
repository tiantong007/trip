package com.too.trip.service;

import com.too.trip.entity.Admin;
import com.baomidou.mybatisplus.extension.service.IService;
import com.too.trip.entity.User;
import org.apache.ibatis.annotations.Result;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface AdminService extends IService<Admin> {
    public Admin login(String aAccount, String aPassword);


}
