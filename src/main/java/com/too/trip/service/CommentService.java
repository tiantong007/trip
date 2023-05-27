package com.too.trip.service;

import com.too.trip.entity.Comment;
import com.baomidou.mybatisplus.extension.service.IService;

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
    // 新增评论
    void addComment(Comment comment);

    // 根据用户 id 获取评论详情
    List<Comment> getCommentsByUserId(Integer uId);
    // 根据酒店 id 获取该酒店所有评论列表，按照评论时间倒序排列
    List<Comment> getCommentsByHotelId(Integer hId);

}
