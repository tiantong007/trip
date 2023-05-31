package com.too.trip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.too.trip.entity.*;
import com.too.trip.service.CommentService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping("/comment")
public class CommentController {

    @Autowired
    private CommentService commentService;  // 实现了 CommentService 接口

    // 添加评论
    @PostMapping
    public R<Comment> addComment(@ModelAttribute Comment comment){
        System.out.println("-------------------->"+comment);
        LocalDateTime time = LocalDateTime.now();
        comment.setCDate(time);
        boolean result = commentService.save(comment);
        if (! result){
            return new R<>(400 , "请求参数错误");
        }
        return new R<>();
    }


    // 根据用户 id 获取用户评论
    @GetMapping("/byUser/{userId}")
    public R getCommentsByUserId(@RequestParam(value = "start", defaultValue = "0") Integer start, @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Page<Comment> page = commentService.selectAllCommentByPage(start,size);
        if (page.getRecords().size() == 0 || page.getRecords() == null) {
            return new R(400, "未找到该用户的评论");
        }else {
            return new R(page);
        }
    }


    // 根据酒店 id 获取该酒店所有评论列表
    @GetMapping("/byHotel/{hotelId}")
    public R  getCommentsByHotelId(@RequestParam(value = "start", defaultValue = "0") Integer start, @RequestParam(value = "size", defaultValue = "5") Integer size) {
       Page<Comment> page =  commentService.selectAllCommentByPage(start,size);

        if (page.getRecords().size() == 0 || page.getRecords() == null) {
            return new R(400, "未找到该酒店的评论");
        }else {
            return new R(page);
        }
    }
    //根据景点id获取该景点的评论
    @GetMapping("/byScenic/{scenicId}")
    public R getCommentsBySId(@RequestParam(value = "start", defaultValue = "0") Integer start, @RequestParam(value = "size", defaultValue = "5") Integer size) {
        Page<Comment> page =  commentService.selectAllCommentByPage(start,size);
        if (page.getRecords().size() == 0 || page.getRecords() == null) {
            return new R(400, "未找到该景点的评论");
        } else {
            return new R(page);
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

    @DeleteMapping("{commentId}")
    public R deleteByCommentId( @PathVariable("commentId") Integer commentId){
        boolean result = commentService.deleteByCommentId(commentId);
        if(!result){
            return new R<City>(204 ,"没有这条评论");
        }
        return new R<City>();
    }

    //批量删除

    @DeleteMapping("/batch")
    public R deleteBatchComment(@RequestBody Map<String, List<Integer>> json){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Integer>> map = mapper.convertValue(json, Map.class);
        System.out.println(map.get("commendIds"));
        List<Integer> list = map.get("commentIds");
        boolean result = commentService.deleteBatchComment(list);
        if(!result){
            return new R<Comment>(400,"请求参数错误");
        }
        return new R<Comment>();
    }

    /**
     * 分页查询
     * @param pages
     * @param pageSize
     * @param field
     * @param keyword
     * @return
     */
    @GetMapping("/page")
    public R<Page<Comment>> searchPages(@RequestParam(value = "start", defaultValue = "0") Integer pages,
                                      @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
                                      @RequestParam(value = "field", required = false)String field,
                                      @RequestParam(value = "keyword", required = false)String keyword){

        //页码数小于0 设置为0
        if(pages == null || pages < 0){
            pages = 0;
        }
        // 调用searchPage方法
        Page<Comment> comments = commentService.searchPages(pages, pageSize, field, keyword);

        System.out.println(comments);
        if (comments == null || comments.getTotal() == 0){
            return new R<>(204,"没有查到数据");
        }
        return new R<Page<Comment>>(comments);
    }

}







