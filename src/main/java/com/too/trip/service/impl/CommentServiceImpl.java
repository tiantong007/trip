package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.too.trip.entity.Comment;
import com.too.trip.mapper.CommentMapper;
import com.too.trip.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Service
public class CommentServiceImpl extends ServiceImpl<CommentMapper, Comment> implements CommentService {
    @Autowired
    private CommentMapper commentMapper;

    @Override
    public void addComment(Comment comment) {
        commentMapper.insert(comment);
    }

    @Override
    public List<Comment> getCommentsByUserId(Integer uId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id", uId).orderByDesc("c_date");
        return commentMapper.selectList(wrapper);
    }


    @Override
    public List<Comment> getCommentsByHotelId(Integer hId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id", hId).orderByDesc("c_date");
        return commentMapper.selectList(wrapper);
    }
}
