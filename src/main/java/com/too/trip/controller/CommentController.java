package com.too.trip.controller;

import com.too.trip.entity.City;
import com.too.trip.entity.Comment;
import com.too.trip.entity.R;
import com.too.trip.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
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
    @PostMapping
    public R<Comment> addComment(@RequestBody Comment comment){
        boolean result = commentService.save(comment);
        if (! result){
            return new R<>(400 , "请求参数错误");
        }
        return new R<>();
    }


    // 根据用户 id 获取用户评论
    @GetMapping("/byUser/{userId}")
    public R<List<Comment>> getCommentsByUserId(@PathVariable Integer userId) {
        List<Comment> comments = commentService.getCommentsByUserId(userId);
        if (comments != null && !comments.isEmpty()) {
            return new R<>( comments);
        } else {
            return new R<>(204, "未找到该用户的评论");
        }
    }


    // 根据酒店 id 获取该酒店所有评论列表
    @GetMapping("/byHotel/{hotelId}")
    public R<List<Comment>>  getCommentsByHotelId(@PathVariable Integer hotelId) {
       List<Comment> comments =  commentService.getCommentsByHotelId(hotelId);
        if (comments != null && !comments.isEmpty()) {
            return new R<>( comments);
        } else {
            return new R<>(204, "未找到该酒店的评论");
        }
    }
    //根据景点id获取该景点的评论
    @GetMapping("/byScenic/{scenicId}")
    public R<List<Comment>>  getCommentsBySId(@PathVariable Integer scenicId) {
        List<Comment> comments =  commentService.getCommentsBySId(scenicId);
        if (comments != null && !comments.isEmpty()) {
            return new R<>( comments);
        } else {
            return new R<>(204, "未找到该景点的评论");
        }
    }

    //根据评论id获取该评论完整信息

    @GetMapping("/byCommentId/{commentId}")
    public R<List<Comment>>  selectByCommentId(@PathVariable Integer commentId) {
        List<Comment> comments =  commentService.selectByCommentId(commentId);
        if (comments != null && !comments.isEmpty()) {
            return new R<>( comments);
        } else {
            return new R<>(204, "未找到该评论");
        }
    }

    //删除评论

    @DeleteMapping
    public R deleteByCommentId( @RequestParam("cityId") Integer cityId){
        boolean result = commentService.deleteByCommentId(cityId);
        if(!result){
            return new R<City>(204 ,"没有这条评论");
        }
        return new R<City>();
    }


}

