package com.too.trip.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
import com.too.trip.entity.Scenic;
import com.baomidou.mybatisplus.extension.service.IService;
import com.too.trip.entity.User;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
public interface ScenicService extends IService<Scenic> {
    //查找全部景点
    List<Scenic> selectScenicAll();
    //按id查找景点
    Scenic selectScenicById(Integer sid);
    //分页搜索所有景点
    Page<Scenic> searchPageScenic(Integer pages, Integer pageSize, String filed, String keyword);
    //插入景点
    boolean insertScenic(Scenic scenic);
    //删除景点
    boolean deleteScenicById(Integer sid);
    //批量删除景点
    boolean deleteBatchScenic(List<Integer> list);
    //修改景点数据
    boolean updateScenic(Scenic scenic);


}
