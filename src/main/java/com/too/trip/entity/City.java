package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author isixe
 * @since 2023-05-24
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@TableName("city")
@ApiModel(value = "City对象", description = "")
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId("city_id")
    private Integer cityId;

    @ApiModelProperty("城市名")
    @TableField("city_name")
    private String cityName;

    @ApiModelProperty("城市所在的省份")
    @TableField("province")
    private String province;

    @ApiModelProperty("城市名字的关键字")
    @TableField(exist = false)
    private String keyword;


}