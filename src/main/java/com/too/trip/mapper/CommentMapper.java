package com.too.trip.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.Comment;
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
public interface CommentMapper extends BaseMapper<Comment> {
    @Override
    int insert(Comment entity);

    @Override
    int updateById(Comment entity);

    @Override
    int deleteById(Comment entity);

    @Override
    Comment selectById(Serializable id);

    @Override
    List<Comment> selectList(Wrapper<Comment> queryWrapper);
}
