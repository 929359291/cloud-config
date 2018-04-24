package com.demo.demologin;

import com.demo.demologin.controller.UserController;
import com.demo.demologin.entity.User;
import com.demo.demologin.mapper.UserMapper;
import com.demo.demologin.service.UserService;
import com.demo.demologin.test.TestBean;
import com.demo.demologin.test.TestConfig;
import com.demo.demologin.utils.Console;
import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoLoginApplicationTests {

	@Autowired
	private UserService userService;
	@Autowired
    private UserMapper userMapper;
    @Autowired
    private UserController userController;

    @Test
    public void test01() {
        User user = userController.userLogin("admin");
        Console.println(user);
    }

    @Test
    public void testUserController() {
        WebClient webClient = WebClient.create("http://127.0.0.1:8081");
        Flux<User> flux = webClient.get()
                .uri("login/user/login?name=admin")
                .accept(MediaType.APPLICATION_JSON_UTF8)
                .retrieve()
                .bodyToFlux(User.class);
        User user = flux.blockFirst();
        Console.println(user);
    }

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
    public void testMapper() throws SQLException {
        List<User> users = userMapper.selectUserList();
        User user = userService.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testBean() throws SQLException {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.getEnvironment().setActiveProfiles("dev");
        context.register(TestConfig.class);
        context.refresh();
        TestBean bean = context.getBean(TestBean.class);
        Console.println(bean);

        MysqlDataSource mysqlDataSource = new MysqlDataSource();
        Connection connection = mysqlDataSource.getConnection();
    }

    @Test
    public void testConsole() {
        Map<String, String> getenv = Console.getenv();
        Console.println(getenv);
    }

}
