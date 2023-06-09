package com.too.trip.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
import com.baomidou.mybatisplus.extension.service.IService;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface HotelService extends IService<Hotel> {
    /**
     * 查找所有的宾馆信息
     * @return 返回列表，元素类型Hotel类
     */
    List<Hotel> searchAllHotel();

    /**
     * 根据id查询单个宾馆信息
     * @return
     */
    Hotel selectByHotelId(Integer hId);

    /**
     * 分页查询
     * @param pages 页码，从1开始
     * @param pageSize 每页显示几条数据
     * @return
     */
    Page<Hotel> searchPages(Integer pages, Integer pageSize,  String filed, String keyword);

    boolean deleteByHotelIds(List<Integer> hotelIds);

    Page<Hotel> selectAllHotelByPage(Integer start, Integer size);
}
