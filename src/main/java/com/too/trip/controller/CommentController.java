package com.too.trip.controller;

import com.too.trip.entity.Comment;
import com.too.trip.entity.R;
import com.too.trip.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;  // 实现了 CommentService 接口

    // 添加评论
    @PostMapping("")
    public R<Comment> saveComment(@RequestBody Comment comment) {
        boolean success = commentService.save(comment);
        if (success) {
            return new R<>(comment);
        } else {
            return new R<>("204", "评论失败");
        }
    }


    // 根据用户 id 获取用户评论
    @GetMapping("/byUser/{userId}")
    public R<List<Comment>> getCommentsByUserId(@PathVariable Integer userId) {
        List<Comment> comments = commentService.getCommentsByUserId(userId);
        if (comments != null && !comments.isEmpty()) {
            return new R<>( comments);
        } else {
            return new R<>("204", "未找到该用户的评论");
        }
    }


    // 根据酒店 id 获取该酒店所有评论列表
    @GetMapping("/byHotel/{hotelId}")
    public R<List<Comment>>  getCommentsByHotelId(@PathVariable Integer hotelId) {
       List<Comment> comments =  commentService.getCommentsByHotelId(hotelId);
        if (comments != null && !comments.isEmpty()) {
            return new R<>( comments);
        } else {
            return new R<>("204", "未找到该用户的评论");
        }
    }
}

