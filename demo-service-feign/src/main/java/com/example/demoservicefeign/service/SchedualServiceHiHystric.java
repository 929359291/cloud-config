package com.example.demoservicefeign.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.ServletContext;
import java.util.Map;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/2/28
 */
@Component
public class SchedualServiceHiHystric implements SchedualServiceHi {

    private static final ObjectMapper MAPPER = new ObjectMapper();

    @Autowired
    private ServletContext servletContext;

    @Override
    public String sayHiFromClientOne(String name) {
        Map<String, Object> map = (Map<String, Object>) this.servletContext.getAttribute("params");
        String jsonMap = null;
        try {
            jsonMap = MAPPER.writeValueAsString(map);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return "sorry error" + name + ", request params = " + map.toString() + "===" + jsonMap;
    }
}
