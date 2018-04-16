package com.demo.demologin.service;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.demo.demologin.entity.User;
import com.demo.demologin.mapper.UserMapper;
import org.springframework.stereotype.Service;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/4/13
 */
@Service
public class UserService extends ServiceImpl<UserMapper, User>{

}
