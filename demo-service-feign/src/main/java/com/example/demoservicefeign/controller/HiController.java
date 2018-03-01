package com.example.demoservicefeign.controller;

import com.example.demoservicefeign.service.MyHealthChecker;
import com.example.demoservicefeign.service.SchedualServiceHi;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/2/28
 */
@Slf4j
@RestController
public class HiController {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    SchedualServiceHi schedualServiceHi;

    @Autowired
    MyHealthChecker myHealthChecker;

    @Autowired
    private ServletContext servletContext;

    @GetMapping(value = "/hi")
    public String sayHi(@RequestParam String name, HttpServletRequest request) throws JsonProcessingException {
        Map<String, Object> map = new HashMap<>();
        if (null != request){
            map.put("RequestAddr", request.getRemoteAddr());
            map.put("ReuqestURL", request.getRequestURL());
            map.put("RequestPort", request.getRemotePort());
            map.put("ServerPort", request.getServerPort());
        }
        servletContext.setAttribute("params", map);
        log.info("request params: {}",MAPPER.writeValueAsString(map) );
        return schedualServiceHi.sayHiFromClientOne(name);
    }

    @GetMapping(value = "/up")
    public String up(@RequestParam("up") Boolean up){
        myHealthChecker.setUp(up);
        return up.toString();
    }
}
