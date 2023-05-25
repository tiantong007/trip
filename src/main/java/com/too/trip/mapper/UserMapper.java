package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.io.Serializable;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface UserMapper extends BaseMapper<User> {
    @Override
    int insert(User entity);

    @Override
    int update(User entity, Wrapper<User> updateWrapper);

    @Override
    int updateById(User entity);

    @Override
    int deleteById(User entity);

    @Override
    User selectById(Serializable id);

    @Override
    List<User> selectList(Wrapper<User> queryWrapper);
}
