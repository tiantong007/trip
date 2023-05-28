package com.too.trip.service;

import com.too.trip.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface UserService extends IService<User> {

    public User login(String username, String password);

    public boolean isExist(String username, String email);

    /**
     * 根据id删除用户
     * @return
     */
    boolean deleteUserById(Integer id);
}
