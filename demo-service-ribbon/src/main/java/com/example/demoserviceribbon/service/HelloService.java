package com.example.demoserviceribbon.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/2/27
 */
@Service
public class HelloService {

    @Autowired
    RestTemplate restTemplate;

    public static final ObjectMapper MAPPER = new ObjectMapper();

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name, HttpServletRequest request) {
        return restTemplate.getForObject("http://SERVICE-HI/hi?name=" + name, String.class);
    }

    public String hiError(String name, HttpServletRequest request) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        if (null != request){
            map.put("RequestAddr", request.getRemoteAddr());
            map.put("ReuqestURL", request.getRequestURL());
            map.put("RequestPort", request.getRemotePort());
            map.put("ServerPort", request.getServerPort());
        }
        return "hi," + name + ",sorry,error!, is request params =" + MAPPER.writeValueAsString(map);
    }
}
