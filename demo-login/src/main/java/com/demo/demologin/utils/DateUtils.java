package com.demo.demologin.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * @desc:
 * @author: zengxc
 * @date: 2018/3/23
 */
public class DateUtils {

    /**
     * 获取当前系统时间的下一天
     * @param date
     * @return
     */
    public static Date getNextDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);
        date = calendar.getTime();
        return date;
    }
}
