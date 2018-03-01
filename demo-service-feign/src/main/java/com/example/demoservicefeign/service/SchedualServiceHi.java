package com.example.demoservicefeign.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/2/28
 */
@FeignClient(value = "service-hi", fallback = SchedualServiceHiHystric.class)
@Service
public interface SchedualServiceHi {

    @GetMapping(value = "/hi")
    String sayHiFromClientOne(@RequestParam("name") String name);
}
