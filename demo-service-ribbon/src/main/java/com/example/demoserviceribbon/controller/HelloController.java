package com.example.demoserviceribbon.controller;

import com.example.demoserviceribbon.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/2/27
 */
@RestController
public class HelloController {

    @Autowired
    HelloService helloService;

    @GetMapping(value = "/hi")
    public String hi(@RequestParam String name, HttpServletRequest request){
        return helloService.hiService(name, request);
    }
}
