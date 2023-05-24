package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

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
@TableName("hotel_orders")
@ApiModel(value = "HotelOrders对象", description = "")
public class HotelOrders implements Serializable {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty("id")
    @TableId("ho_id")
    private String hoId;

    @ApiModelProperty("	酒店id")
    @TableField("h_id")
    private Integer hId;

    @ApiModelProperty("用户id")
    @TableField("u_id")
    private Integer uId;

    @ApiModelProperty("房间id")
    @TableField("r_id")
    private Integer rId;

    @ApiModelProperty("入住时间")
    @TableField("begin_date")
    private LocalDateTime beginDate;

    @ApiModelProperty("离开时间")
    @TableField("end_date")
    private LocalDateTime endDate;

    @ApiModelProperty("订单状态")
    @TableField("status")
    private String status;


}