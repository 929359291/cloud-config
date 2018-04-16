package com.demo.demologin.config;

import com.demo.demologin.authIntercept.LoginIntercept;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.DispatcherServlet;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @desc: 拦截请求路径
 * @author: zengxc
 * @date: 2018/4/13
 */
@Configuration
public class WebAppConfigurer extends WebMvcConfigurationSupport {
    @Autowired
    private LoginIntercept loginIntercept;

    @Bean
    public DispatcherServlet dispatcherServlet(){
        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        dispatcherServlet.setThrowExceptionIfNoHandlerFound(true);
        return dispatcherServlet;
    }

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginIntercept).addPathPatterns(
                "/**"
        );
        super.addInterceptors(registry);
    }
}
