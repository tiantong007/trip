package com.too.trip.controller;

import com.too.trip.entity.User;
import com.too.trip.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/foreregister",produces = "text/html;charset=UTF-8")
    @ResponseBody
    public ModelAndView register(HttpServletRequest request, HttpServletResponse response, User user) throws Exception{
        ModelAndView mav = new ModelAndView();
        try{
            userService.insert(user);
            request.getSession().setAttribute("user",user);
        }catch (Exception e){
            log.info("用户名已存在");
//            return generalController.home(request);
        }
        mav.setViewName("registerSuccess");
        return mav;
    }
}
