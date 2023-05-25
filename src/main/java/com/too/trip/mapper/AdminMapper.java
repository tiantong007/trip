package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.Admin;
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
public interface AdminMapper extends BaseMapper<Admin> {
    @Override
    int insert(Admin entity);

    @Override
    int updateById(Admin entity);

    @Override
    int deleteById(Admin entity);

    @Override
    Admin selectById(Serializable id);

    @Override
    List<Admin> selectList(Wrapper<Admin> queryWrapper);
}
