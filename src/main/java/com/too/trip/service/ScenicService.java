package com.too.trip.service;

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
    //插入景点
    boolean insertScenic(Scenic scenic);
    //删除景点
    boolean deleteScenicById(Integer sid);

}
