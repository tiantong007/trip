package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.math.BigDecimal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author isixe
 * @since 2023-05-24
 */
@Data
@TableName("room")
@ApiModel(value = "Room对象", description = "")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("room_id")
    private Integer roomId;

    @ApiModelProperty("关联酒店id")
    @TableField("h_id")
    private Integer hId;

    @ApiModelProperty("房间状态（空闲，被预定等）")
    @TableField("room_status")
    private Integer roomStatus;

    @ApiModelProperty("房间价格")
    @TableField("room_price")
    private BigDecimal roomPrice;

    @ApiModelProperty("房间数量")
    @TableField("room_num")
    private Integer roomNum;

    @ApiModelProperty("房间类型（大床房，双人房等）")
    @TableField("room_type")
    private  String roomType;

    @ApiModelProperty("房间图片")
    @TableField("room_img")
    private String roomImg;


    private Hotel hotel;

}