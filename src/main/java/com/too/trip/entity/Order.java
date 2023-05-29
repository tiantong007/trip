package com.too.trip.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
public class Order implements Serializable {


    @TableField()
    private String scienceName;
    private String hotelName;
    private Integer roomType;
    private String scienceImg;
    private BigDecimal sciencePrice;
    private String soStatus;
    private LocalDateTime soTime;
    private LocalDateTime endDate;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}