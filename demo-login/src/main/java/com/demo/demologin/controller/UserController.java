package com.demo.demologin.controller;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.demo.demologin.entity.User;
import com.demo.demologin.service.UserService;
import com.demo.demologin.utils.Console;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/4/23
 */
@RequestMapping("/user")
@Controller
public class UserController {

    @Autowired
    private UserService userService;

    /**
     * 用户登录
     * @return
     */
    @GetMapping("/login")
    @ResponseBody
    public User userLogin(@RequestParam("name") String name){
        User user = new User();
        user.setUsername(name);
        EntityWrapper<User> wrapper = new EntityWrapper<>(user);
        User findUser = userService.selectOne(wrapper);
        Console.println(findUser);
        return findUser;
    }
}
