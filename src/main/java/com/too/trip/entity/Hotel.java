package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author isixe
 * @since 2023-05-24
 */
@Data
@TableName("hotel")
@ApiModel(value = "Hotel对象", description = "")
public class Hotel implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "h_id", type = IdType.AUTO)
    private Integer hId;

    @ApiModelProperty("图片")
    @TableField("hotel_img")
    private String hotelImg;

    @ApiModelProperty("酒店名称")
    @TableField("hotel_name")
    private String hotelName;

    @ApiModelProperty("描述")
    @TableField("hotel_description")
    private String hotelDescription;

    @ApiModelProperty("星级")
    @TableField("hotel_star")
    private Integer hotelStar;

    @ApiModelProperty("具体位置")
    @TableField("hotel_position")
    private String hotelPosition;

    @ApiModelProperty("所在城市")
    @TableField("city_id")
    private Integer cityId;

    @TableField(exist = false)
    private City city;

    private List<Room> rooms;
}