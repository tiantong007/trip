package com.too.trip.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;
import com.too.trip.entity.Hotel;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface CommentService extends IService<Comment> {


    // 根据用户 id 获取评论详情
    List<Comment> getCommentsByUserId(Integer uId);
    // 根据酒店 id 获取该酒店所有评论列表
    List<Comment> getCommentsByHotelId(Integer hId);
//根据景点id获取景点的评论
    List<Comment> getCommentsBySId(Integer sId);

    boolean deleteByCommentId(Integer commentId);

    List<Comment> selectByCommentId(Integer commentId);

    //批量删除
    boolean deleteBatchComment(List<Integer> list);

    //分页查询
    Page<Comment> searchPages(Integer pages, Integer pageSize, String filed, String keyword);

    //查询全部

    Page<Comment> selectAllCommentByPage(Integer start, Integer size);




}
