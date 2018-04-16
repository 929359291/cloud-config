package com.demo.demologin.exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @desc: 异常集中处理
 * @author: zengxc
 * @date: 2018/4/13
 */
@ControllerAdvice
public class ExceptionFocusHandler {

    @ExceptionHandler(RuntimeException.class)
    @ResponseBody
    public Map<String, Object> exceptionHandler(){
        return new HashMap<String, Object>(){
            {
                put("code", "500");
                put("msg", "system error");
            }
        };
    }
}
