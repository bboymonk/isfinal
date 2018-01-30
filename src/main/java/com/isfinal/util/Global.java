package com.isfinal.util;

import java.util.UUID;

/**
 * Created by wjb on 2018/1/29.
 */
public class Global {
    public static final String APPID = "wx27bd0a5e2a28f8d0";
    public static final String SECRET = "931445a58f7a8b06d3f08509e9f78b72";

    public static String getRandom(){
        return UUID.randomUUID().toString();
    }

}
