package com.too.trip.controller;

import com.too.trip.entity.Comment;
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
    @PostMapping("/insertComment")
    public ResponseEntity<String> addComment( Comment comment) {
        try {
            commentService.addComment(comment);
            return ResponseEntity.ok("新增评论成功");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body("新增评论失败：" + e.getMessage());
        }
    }

    // 根据用户 id 获取用户评论
    @GetMapping("/user/comments")
    public ResponseEntity<List<Comment>> getCommentsByUserId(@RequestParam("uId") Integer uId) {
        List<Comment> comments = commentService.getCommentsByUserId(uId);
        if (comments != null) {
            return ResponseEntity.ok(comments);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    // 根据酒店 id 获取该酒店所有评论列表
    @GetMapping("/hotel")
    public ResponseEntity<List<Comment>> getCommentsByHotelId(@RequestParam("hd") Integer hId) {
        List<Comment> comments = commentService.getCommentsByHotelId(hId);
        return ResponseEntity.ok(comments);
    }

}

