package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author isixe
 * @since 2023-05-24
 */
@Data
@TableName("comment")
@ApiModel(value = "Comment对象", description = "")
public class Comment implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Integer commentId;

    @ApiModelProperty("酒店id")
    @TableField("h_id")
    private Integer hId;

    @ApiModelProperty("用户id")
    @TableField("u_id")
    private Integer uId;

    @ApiModelProperty("景点id")
    @TableField("s_id")
    private  Integer sId;

    @ApiModelProperty("评论信息")
    @TableField("c_context")
    private String cContext;

    @ApiModelProperty("评论时间")
    @TableField(value = "c_date",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime cDate;


}