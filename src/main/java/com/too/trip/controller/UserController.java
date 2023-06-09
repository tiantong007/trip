package com.too.trip.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.too.trip.entity.R;
import com.too.trip.entity.User;
import com.too.trip.service.UserService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.lang.reflect.Field;

/**
 * 前端控制器
 *
 * @author isixe
 * @since 2023-05-24
 */
@RestController
@Slf4j
@CrossOrigin(value = "*", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping(value = "/register")
    @ResponseBody
    public R addUer(User user) {
        String username = user.getUsername();
        String email = user.getEmail();

        //用户名或邮箱是否已注册
        boolean flag = userService.isExist(username, email);
        if (!flag) {
            //用户注册更新用户信息到数据库
            userService.save(user);
            //返回注册成功信息
            return new R<User>();
        }

        //如果用户名和邮箱已经注册，返回错误信息
        return new R<>(409, "用户名或邮箱已被注册");
    }

    /**
     * 用户登录
     *
     * @param request
     * @param username
     * @param password
     * @return 登录信息
     */
    @PostMapping(value = "/login")
    public R selectUser(HttpServletRequest request, @RequestParam String username, @RequestParam String password) {
        //判断登录，登录成功则返回用户信息
        User user = userService.login(username, password);
        if (user == null) {
            return new R<User>(400, "用户名或密码错误");
        }

        //将信息保存进session
        HttpSession session = request.getSession();
        session.setAttribute("id", user.getUserId());
        session.setAttribute("username", user.getUsername());

        return new R<User>(user);
    }

    /**
     * 用户退出
     *
     * @param request
     * @return 请求结果
     */
    @DeleteMapping(value = "/logout")
    public R logoutUser(HttpServletRequest request) {
        //清除用户的session信息
        HttpSession session = request.getSession();
        session.removeAttribute("id");
        request.removeAttribute("username");
        return new R<>();
    }


    /**
     * 删除用户信息
     *
     * @param request
     * @param uid
     * @return 请求结果
     */
    @DeleteMapping("/{uid}")
    public R deleteUser(HttpServletRequest request, @PathVariable("uid") Integer uid) {
        boolean result = userService.deleteUserById(uid);
        if (!result) {
            return new R<User>(404, "找不到对应的用户id");
        }
        return new R<User>();
    }

    /**
     * 添加用户信息
     *
     * @param request
     * @param user
     * @return 请求结果
     */
    @PostMapping
    public R insertUser(HttpServletRequest request, User user) {
        String username = user.getUsername();
        String email = user.getEmail();

        //用户名或邮箱是否已注册
        boolean flag = userService.isExist(username, email);
        if (flag) {
            //返回失败信息
            return new R<>(409, "用户名或邮箱已被注册");
        }
        boolean result = userService.save(user);
        if (!result) {
            return new R<User>(400, "请求参数错误");
        }
        return new R<User>();
    }

    /**
     * 更新用户信息
     *
     * @param request
     * @param user
     * @return 请求结果
     * @throws IllegalAccessException
     */
    @PutMapping
    public R updateUser(HttpServletRequest request, User user) throws IllegalAccessException {
        // 用户id为空时返回错误信息
        if (user.getUserId() == null) {
            return new R<User>(400, "用户id为空");
        }

        // 默认所有属性都为空，当所有属性都为空时，说明用户没有进行修改操作
        boolean allFieldsNotNull = false;
        // 获取User类中的所有字段
        Field[] fields = User.class.getDeclaredFields();
        for (Field field : fields) {
            // 屏蔽userId字段和serialVersionUID字段
            if ("userId".equals(field.getName()) || "serialVersionUID".equals(field.getName())) {
                continue;
            }
            /*
                setAccessible用于设置某个类的私有成员变量的访问权限
                setAccessible(true)方法可以将这种限制取消，使得当前代码可以访问该变量
            */
            field.setAccessible(true);
            Object value = field.get(user);
            // 有一个不为空就说明用户有进行修改，则跳出循环
            if (value != null) {
                allFieldsNotNull = true;
                break;
            }
        }
        if (!allFieldsNotNull) {
            return new R<User>(204, "没有提交修改信息");
        }

        String username = user.getUsername();
        String email = user.getEmail();

        //用户名或邮箱是否已注册
        boolean flag = userService.isExist(username, email);
        if (flag) {
            //返回失败信息
            return new R<>(409, "用户名或邮箱已被注册");
        }

        UpdateWrapper<User> wrapper = new UpdateWrapper<>();
        wrapper.eq("user_id", user.getUserId());
        boolean result = userService.update(user, wrapper);
        if (!result) {
            return new R<User>(404, "找不到对应的用户id");
        }
        return new R<User>();
    }

    /**
     * 获取用户信息
     *
     * @param userId
     * @return 用户实体信息
     */
    @GetMapping("/{userId}")
    public R<User> getUserById(@PathVariable int userId) {
        log.info(String.valueOf(userId));
        User user = userService.getById(userId);
        if (user == null) {
            return new R<>(404, "用户不存在");
        }

        return new R<>(user);
    }

    /**
     * 用户模糊查询和分页
     *
     * @param keyword
     * @param pages
     * @param pageSize
     * @param field
     * @return 返回模糊查询和分页后的数据
     */
    @GetMapping("/page")
    public R<IPage<User>> getUsers(@RequestParam(value = "start", defaultValue = "0") Integer pages,
                                   @RequestParam(value = "size", defaultValue = "5") Integer pageSize,
                                   @RequestParam(value = "field", required = false)String field,
                                   @RequestParam(value = "keyword", required = false)String keyword) {
        // 构造分页对象
        Page<User> page = new Page<>(pages, pageSize);

        // 构造查询条件
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");

        //模糊查询
        if (StringUtils.isNotBlank(keyword)) {
            queryWrapper.like(field, keyword);
        }

        // 执行分页查询
        IPage<User> userPage = userService.page(page, queryWrapper);

        // 返回结果
        return new R<>(userPage);
    }
}
