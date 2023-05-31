package com.too.trip.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
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
        wrapper.eq("u_id", uId).orderByDesc("hc_date");
        return commentMapper.selectList(wrapper);
    }

    // 根据酒店id查询所有评论信息
    @Override
    public List<Comment> getCommentsByHotelId(Integer hId) {
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("h_id", hId).orderByDesc("hc_date");
        return commentMapper.selectList(wrapper);
    }

    //根据景点id查询所有评论信息

    @Override
    public  List<Comment> getCommentsBySId(Integer sId){
        QueryWrapper<Comment> wrapper = new QueryWrapper<>();
        wrapper.eq("s_id",sId).orderByDesc("hc_date");
        return commentMapper.selectList(wrapper);
    }

    //根据评论id删除评论
    @Override
    public boolean deleteByCommentId(Integer commentId) {
        int row = commentMapper.deleteByCommentId(commentId);
        return row > 0;
    }

    //批量删除
    @Override
    public boolean deleteBatchComment(List<Integer> list) {
        int row = commentMapper.deleteBatchIds(list);
        return row > 0;
    }

    /**
     * 分页查询
     * @param pages 页码，从1开始
     * @param pageSize 每页显示几条数据
     * @param filed
     * @param keyword
     * @return
     */
    @Override
    public Page<Comment> searchPages(Integer pages, Integer pageSize, String filed, String keyword) {
        Page<Comment> page = new Page<>(pages, pageSize);
        commentMapper.selectPage(page, filed, keyword);
        return page;
    }
    //查找全部评论
    @Override
    public Page<Comment> selectAllCommentByPage(Integer start, Integer size) {
        Page<Comment> page = new Page<>(start, size);
        commentMapper.selectAllByPage(page);
        return page;
    }

}
