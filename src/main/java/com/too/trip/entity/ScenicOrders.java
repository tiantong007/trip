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
@TableName("scenic_orders")
@ApiModel(value = "ScenicOrders对象", description = "")
public class ScenicOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId(value = "so_id", type = IdType.AUTO)
    private Integer soId;

    @ApiModelProperty("景点id")
    @TableField("scenic_id")
    private Integer scenicId;

    @ApiModelProperty("用户id")
    @TableField("user_id")
    private Integer userId;

    @ApiModelProperty("订单状态")
    @TableField("so_status")
    private String soStatus;

    @ApiModelProperty("预定时间")
    @TableField(value = "so_time",fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime soTime;


}