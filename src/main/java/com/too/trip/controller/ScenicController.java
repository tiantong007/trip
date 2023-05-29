package com.too.trip.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.too.trip.entity.Hotel;
import com.too.trip.entity.R;
import com.too.trip.entity.Scenic;
import com.too.trip.entity.User;
import com.too.trip.mapper.ScenicMapper;
import com.too.trip.service.ScenicService;
import com.too.trip.service.UserService;
import io.swagger.models.auth.In;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.UUID;

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
    @GetMapping("/selectAll")
    public R selectScenicAll(HttpServletRequest request){
        List<Scenic> scenics = scenicService.selectScenicAll();
        if(scenics == null || scenics.size() == 0){
            return new R<>(204, "没有查到数据");
        }
        return new R<>(scenics);
    }

    /**
     *根据景点id查询景点对象
     * @param request
     * @param
     * @return
     */
    @GetMapping("/selectById/{id}")
    public R selectScenicById(HttpServletRequest request,@PathVariable Integer id){


        Scenic scenic = scenicService.selectScenicById(id);
        if(scenic == null){
            return new R<>(204, "没有查到数据");
        }
        return new R<>(scenic);
    }

    /**
     *
     * 分页查询，可以根据城市id和景点名称进行搜索,没有输入则查取全部
     * @param
     * @param pages
     * @param pageSize
     * @param scenic
     * @return
     */
    @GetMapping("/page/{start}/{size}")
    public R<Page<Scenic>> searchPages(@PathVariable("start") Integer pages, @PathVariable("size") Integer pageSize,@RequestBody Scenic scenic){
        //页码数小于0 设置为0
        if (pages == null || pages < 0){
            pages = 0;
        }
        Page<Scenic> scenics = scenicService.searchPageScenic(pages,pageSize,scenic);
        System.out.println(scenic);
        if (scenics == null || scenics.getTotal() == 0){
            return new R<>(204,"没有查到数据");
        }
        return new R<Page<Scenic>>(scenics);
    }

    /**
     * 新增景点
     * @param
     * @param scenic
     * @return
     */
//    @PostMapping("/insert")
//    public R insertScenic(HttpServletRequest request,@RequestBody Scenic scenic){
//        System.out.println(scenic);
//        boolean result = scenicService.insertScenic(scenic);
//        if (! result){
//            return new R<Scenic>(400, "请求参数错误");
//        }
//        return new R<Scenic>();
//    }

    /**
     * 修改景点数据
     * @param scenic
     * @return
     */
    @PutMapping("/update")
    public R updateScenic(@RequestBody Scenic scenic){
        boolean result = scenicService.updateScenic(scenic);
        if(! result){
            return new R(400,"请求参数错误");
        }
        return new R();
    }

    /**
     * 根据id删除景点
     * @param request
     * @param
     * @return
     */
    @DeleteMapping("/deleteById/{id}")
    public R deleteScenic(HttpServletRequest request,@PathVariable Integer id){
        boolean result = scenicService.deleteScenicById(id);
        if (! result){
            return new R<Scenic>(400, "请求参数错误");
        }
        return new R<Scenic>();
    }

    /**
     * 批量删除功能
     * @param request
     * @param json
     * @return
     */
    @DeleteMapping("/batch")
    public R batchDeleteScenic(HttpServletRequest request,@RequestBody Map<String, List<Integer>> json){
        ObjectMapper mapper = new ObjectMapper();
        Map<String, List<Integer>> map = mapper.convertValue(json, Map.class);
        System.out.println(map.get("sIds"));
        List<Integer> list = map.get("sIds");
        boolean result = scenicService.deleteBatchScenic(list);
        if(!result){
            return new R<Scenic>(400,"请求参数错误");
        }
        return new R<Scenic>();
    }
}
