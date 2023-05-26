package com.too.trip.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author: isixe
 * @create: 2023-05-26 11:05
 * @description: 统一返回的 JSON 结构
 **/
@Data
public class R<T> implements Serializable {

    @ApiModelProperty("请求状态码")
    private String code;

    @ApiModelProperty("实体数据")
    private T data;

    @ApiModelProperty("返回的具体消息")
    private String msg;

    /**
     * 若没有数据返回，默认状态码为 200 OK，提示信息为“操作成功！”
     */
    public R() {
        this.code = "200 OK";
        this.msg = "success";
    }

    /**
     * 若没有数据返回，可以人为指定状态码和提示信息
     *
     * @param code
     * @param msg
     */
    public R(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    /**
     * 有数据返回时，状态码为 200，默认提示信息为“操作成功！”
     *
     * @param data
     */
    public R(T data) {
        this.data = data;
        this.code = "200 OK";
        this.msg = "success";
    }

    /**
     * 有数据返回，状态码为 200，人为指定提示信息
     *
     * @param data
     * @param msg
     */
    public R(T data, String msg) {
        this.code = "200 OK";
        this.data = data;
        this.msg = msg;
    }

    /**
     * 有数据返回，人为指定状态码、提示信息
     *
     * @param data
     * @param msg
     * @param code
     */
    public R(String code, T data, String msg) {
        this.code = code;
        this.data = data;
        this.msg = msg;
    }
}
