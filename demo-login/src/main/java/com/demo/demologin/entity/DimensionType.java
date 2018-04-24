package com.demo.demologin.entity;


import java.util.ArrayList;
import java.util.List;

/**
 * Created by zengxc on 2018/4/19.
 * 多维度类型
 */
public final class DimensionType {
    //身份证号
    public static final String ID = "ID";
    //设备标识(imei)
    public static final String IM = "IM";
    //手机号
    public static final String PH = "PH";
    //银行卡号
    public static final String BC = "BC";
    //wifi(mac地址)
    public static final String WF = "WF";
    //ip地址
    public static final String IP = "IP";
    //GeoHash(“lat<wgs84纬度>,lng< wgs84经度>”, 7)
    public static final String GD = "GD";

    // 多维度类型集合
    public static final List<String> FIELDS_VALUE = new ArrayList<>();

    static {
        FIELDS_VALUE.add(ID);
        FIELDS_VALUE.add(IM);
        FIELDS_VALUE.add(PH);
        FIELDS_VALUE.add(BC);
        FIELDS_VALUE.add(WF);
        FIELDS_VALUE.add(IP);
        FIELDS_VALUE.add(GD);
    }

    private DimensionType(){};
}
