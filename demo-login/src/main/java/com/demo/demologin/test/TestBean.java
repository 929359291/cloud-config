package com.demo.demologin.test;

import lombok.Data;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/4/23
 */
@Data
public class TestBean {
    private String content;

    public TestBean(String content){
        super();
        this.content = content;
    }

}
