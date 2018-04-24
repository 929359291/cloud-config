package com.demo.demologin.map;

import com.demo.demologin.utils.Console;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/4/24
 */
public class MapTest {
    private final static String[] DIMENSION_TYPE = {"ID", "IM", "PH", "BC", "WF", "IP", "GD"};
    private final static ObjectMapper MAPPER = new ObjectMapper();

    @Test
    public void test01() throws JsonProcessingException {
        Map<String, String> dataSource = new HashMap<String, String>();
        {
            for (String type : DIMENSION_TYPE) {
                dataSource.put(type + ":1", new Random().nextInt(1000) + "_test");
            }
        }
        Console.println(MAPPER.writeValueAsString(dataSource));
    }
}
