package com.demo.demologin.utils;

import java.util.Map;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/4/23
 */
public final class Console {

    public static final void print(Object obj){
        System.out.print(obj);
    }

    public static final void println(Object obj){
        System.out.println(obj);
    }

    public static final Map<String, String> getenv(){
        Map<String, String> getenv = System.getenv();
        return getenv;
    }
}
