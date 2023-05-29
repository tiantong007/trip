package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.too.trip.entity.City;
import com.too.trip.entity.Comment;
import com.too.trip.entity.Hotel;
import com.too.trip.mapper.CommentMapper;
import com.too.trip.service.CommentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
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



    //根据评论id查询该评论

    @Override
    public List<Comment> selectByCommentId(Integer commentId) {
        List<Comment> comment = commentMapper.selectByCommentId(commentId);
        return comment;
    }


    // 根据用户id查询所有评论信息
    @Override
    public List<Comment> getCommentsByUserId(Integer uId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("u_id", uId).orderByDesc("c_date");
        return commentMapper.selectList(wrapper);
    }

    // 根据酒店id查询所有评论信息
    @Override
    public List<Comment> getCommentsByHotelId(Integer hId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id", hId).orderByDesc("c_date");
        return commentMapper.selectList(wrapper);
    }

    //根据景点id查询所有评论信息

    @Override
    public  List<Comment> getCommentsBySId(Integer sId){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("s_id",sId).orderByDesc("c_date");
        return commentMapper.selectList(wrapper);
    }

    //根据评论id删除评论
    @Override
    public boolean deleteByCommentId(Integer commentId) {
        int row = commentMapper.deleteByCommentId(commentId);
        return row > 0;
    }

    //分页查询

}
