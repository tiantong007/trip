package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.too.trip.entity.User;
import com.too.trip.mapper.UserMapper;
import com.too.trip.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
    @Autowired
    private UserMapper userMapper;

    //用户登陆
    @Override
    public User login(String username, String password) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.and(qw -> qw.eq("username", username).or().eq("email", username))
                .eq("password", password);
        return userMapper.selectOne(wrapper);
    }

    //用户名和邮箱是否已经注册
    @Override
    public boolean isExist(String username, String email) {
        int count = Math.toIntExact(userMapper.selectCount(
                Wrappers.<User>lambdaQuery()
                        .eq(User::getUsername, username)
                        .or()
                        .eq(User::getEmail, email)
        ));
        return count > 0;
    }

    //删除用户
    @Override
    public boolean deleteUserById(Integer id) {
        int row = userMapper.deleteById(id);
        return row > 0;
    }
}
