package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@TableName("image")
@ApiModel(value = "Image对象", description = "酒店和景点的图片")
@AllArgsConstructor
@NoArgsConstructor
public class Image {
//    @ApiModelProperty("id")
//    @TableId(value = "scenic_id", type = IdType.AUTO)
//    private Integer scenicId;

    @ApiModelProperty("id")
    @TableId(value = "img_id",type = IdType.AUTO)
    private Integer imgId;

    @ApiModelProperty("酒店图片")
    @TableField("h_id")
    private Integer hId;

    @ApiModelProperty("景点图片")
    @TableField("s_id")
    private Integer sId;

    @ApiModelProperty("图片内容")
    @TableField("img_src")
    private String imgSrc;

}
