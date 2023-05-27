package com.too.trip.controller;

import com.too.trip.entity.Hotel;
import com.too.trip.entity.R;
import com.too.trip.entity.Scenic;
import com.too.trip.entity.User;
import com.too.trip.mapper.ScenicMapper;
import com.too.trip.service.ScenicService;
import com.too.trip.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@RequestMapping("/scenic")
public class ScenicController {

    @Autowired
    private ScenicService scenicService;


    /**
     * 查询所有景点
     * @param request
     * @return
     */
    @PostMapping("/selectAll")
    public R selectScenicAll(HttpServletRequest request){
        List<Scenic> scenics = scenicService.selectScenicAll();
        if(scenics == null || scenics.size() == 0){
            return new R<>("204", "没有查到数据");
        }
        return new R<>(scenics);
    }

    /**
     *根据景点id查询景点对象
     * @param request
     * @param cId
     * @return
     */
    @PostMapping("/selectById")
    public R selectScenicById(HttpServletRequest request,@RequestParam("sId") Integer sId){
        Scenic scenic = scenicService.selectScenicById(sId);
        if(scenic == null){
            return new R<>("204", "没有查到数据");
        }
        return new R<>(scenic);
    }

    /**
     * 新增景点
     * @param request
     * @param scenic
     * @return
     */
    @PostMapping("/insert")
    public R insertScenic(HttpServletRequest request,Scenic scenic){
        boolean result = scenicService.insertScenic(scenic);
        if (! result){
            return new R<Scenic>("400 Bad Request", "请求参数错误");
        }
        return new R<Scenic>();
    }

    /**
     * 根据id删除景点
     * @param request
     * @param sId
     * @return
     */
    @PostMapping("/delete")
    public R deleteScenic(HttpServletRequest request,@RequestParam("sId") Integer sId){
        boolean result = scenicService.deleteScenicById(sId);
        if (! result){
            return new R<Scenic>("400 Bad Request", "请求参数错误");
        }
        return new R<Scenic>();
    }
}
