package com.demo.demologin;

import com.demo.demologin.entity.User;
import com.demo.demologin.mapper.UserMapper;
import com.demo.demologin.service.UserService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoLoginApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
    private UserMapper userMapper;

	@Test
	public void contextLoads() {
        User user = new User();
        user.setId(UUID.randomUUID().toString());
        user.setEmail("929359291@qq.com");
        user.setUsername("zxc");
        user.setPassword("123");
        user.setCreateTime(new Date());
        user.setLastUpdateTime(new Date());
        boolean bool = userService.insert(user);
        Assert.assertTrue("insert fail", bool);
    }

    @Test
    public void testMapper() {
        List<User> users = userMapper.selectUserList();
        User user = userService.selectById(1);
        System.out.println(user);
    }

}
