package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
@TableName("scenic")
@ApiModel(value = "Scenic对象", description = "")
public class Scenic implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "scenic_id", type = IdType.AUTO)
    private Integer scenicId;

    @ApiModelProperty("景点名称")
    @TableField("science_name")
    private String scienceName;

    @ApiModelProperty("景点图片")
    @TableField("science_img")
    private String scienceImg;

    @ApiModelProperty("景点价格")
    @TableField("science_price")
    private BigDecimal sciencePrice;

    @ApiModelProperty("景点描述")
    @TableField("description")
    private String description;

    @ApiModelProperty("评分")
    @TableField("science_star")
    private Integer scienceStar;

    @ApiModelProperty("所在城市")
    @TableField("city_id")
    private Integer cityId;

    @ApiModelProperty("具体位置")
    @TableField("science_position")
    private String sciencePosition;


}