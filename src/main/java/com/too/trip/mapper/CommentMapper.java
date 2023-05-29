package com.too.trip.mapper;
import org.apache.ibatis.annotations.Param;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.too.trip.entity.Comment;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

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
@Mapper
@Repository
public interface CommentMapper extends BaseMapper<Comment> {



    List<Comment> selectByCommentId(@Param("commentId") Integer commentId);

    int insertSelective(Comment comment);

    int deleteByCommentId(@Param("commentId") Integer commentId);

    List<Comment> selectAllByUId(@Param("uId") Integer uId);

    List<Comment> selectAllByHId(@Param("hId") Integer hId);

    List<Comment> selectAllBySId(@Param("sId") Integer sId);



}
