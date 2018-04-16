package com.demo.demologin.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.demo.demologin.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/4/16
 */
@Component
public interface UserMapper extends BaseMapper<User> {

    public List<User> selectUserList();


}
