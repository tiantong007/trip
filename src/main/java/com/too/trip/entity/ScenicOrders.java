package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.*;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.time.LocalDateTime;
import lombok.Data;

/**
 * @TableName scenic_orders
 */
@TableName(value = "scenic_orders")
@Data
public class ScenicOrders implements Serializable {
    /**
     * id
     */
    @TableId(type = IdType.AUTO)
    private Integer soId;

    /**
     * 景点id
     */
    private Integer scenicId;

    /**
     * 用户id
     */
    private Integer userId;

    /**
     * 订单状态
     */
    private String soStatus;

    /**
     * 预定时间
     */

    private LocalDateTime soTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}