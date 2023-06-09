package com.too.trip.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
import com.too.trip.mapper.HotelMapper;
import com.too.trip.service.HotelService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@Service
public class HotelServiceImpl extends ServiceImpl<HotelMapper, Hotel> implements HotelService {
    @Autowired
    private HotelMapper hotelMapper;
    @Override
    public List<Hotel> searchAllHotel() {
        // 获取宾馆信息
        List<Hotel> hotels = hotelMapper.searchAllHotel();
        return hotels;
    }

    @Override
    public Hotel selectByHotelId(Integer hId) {
        Hotel hotel = hotelMapper.selectByHotelId(hId);
        return hotel;
    }

    /**
     * 分页查询
     * @param pages 页码，从1开始
     * @param pageSize 每页显示几条数据
     * @param filed
     * @param keyword
     * @return
     */
    @Override
    public Page<Hotel> searchPages(Integer pages, Integer pageSize,  String filed, String keyword) {
        Page<Hotel> page = new Page<>(pages, pageSize);
        hotelMapper.selectPage(page, filed, keyword);
        return page;
    }

    /**
     * 批量删除
     * @param hotelIds
     * @return
     */
    @Override
    public boolean deleteByHotelIds(List<Integer> hotelIds) {
        int i = hotelMapper.deleteBatchIds(hotelIds);
        if(i == 0){
            return false;
        }
        return true;
    }

    @Override
    public Page<Hotel> selectAllHotelByPage(Integer start, Integer size) {
        Page<Hotel> page = new Page<>(start, size);
        hotelMapper.selectAllByPage(page);
        return page;
    }
}
