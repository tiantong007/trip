package com.too.trip.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.Hotel;
import com.too.trip.entity.Scenic;
import com.too.trip.entity.User;
import com.too.trip.mapper.ScenicMapper;
import com.too.trip.mapper.UserMapper;
import com.too.trip.service.ScenicService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
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
public class ScenicServiceImpl extends ServiceImpl<ScenicMapper, Scenic> implements ScenicService {


    @Autowired
    private ScenicMapper scenicMapper;


    /**
     * 查询全部景点
     * @return
     */
    @Override
    public List<Scenic> selectScenicAll() {
        List<Scenic> scenics = scenicMapper.searchAllScenic();
        return scenics;
    }

    /**
     * 按id查询景点
     * @return 景点对象
     */
    @Override
    public Scenic selectScenicById(Integer sid) {
        Scenic scenic = scenicMapper.searchScenicById(sid);
        return scenic;
    }

    /**
     * 按id增加景点
     * @param scenic
     * @return
     */
    @Override
    public boolean insertScenic(Scenic scenic) {
        int row = scenicMapper.insert(scenic);
        return row > 0;
    }

    /**
     * 根据id删除景点
     * @param sid
     * @return
     */
    @Override
    public boolean deleteScenicById(Integer sid) {
        int row = scenicMapper.deleteById(sid);
        return row > 0;
    }


    /**
     * 分页查询景点，可以根据城市id或者景点名字查询
     * @param pages
     * @param pageSize
     * @param scenic
     * @return
     */

    @Override
    public Page<Scenic> searchPageScenic(Integer pages, Integer pageSize, Scenic scenic) {
//        System.out.println(scenic);

        Page<Scenic> page = new Page<>(pages,pageSize);
        scenicMapper.selectPage(page,scenic);
//        System.out.println("page为："+page.getRecords());
//        List<Scenic> records = page.getRecords();
//        return records;
        return page;
    }
}
