package com.isfinal.util;

import com.google.gson.*;

/**
 * GSON工具类
 */
public class GsonUtils {

    private static final Gson gsonBuilder = new GsonBuilder().serializeNulls().disableHtmlEscaping().create();

    private static final Gson GSON = new Gson();

    /**
     * 【GSON】String转json对象
     */
    public static JsonObject toGsonObject(String str){
        return gsonBuilder.fromJson(str, JsonObject.class);
    }

    /**
     * 【GSON】String转json数组
     */
    public static JsonArray toGsonArray(String str){
        return gsonBuilder.fromJson(str, JsonArray.class);
    }

    /**
     * 【GSON】String转gson对象，包含对象和数组
     */
    public static JsonElement toGsonElement(String str){
        return gsonBuilder.fromJson(str, JsonElement.class);
    }

    /**
     * 使用GSON将javaObject转换成字符串，保留null值
     */
    public static String toJsonString(Object obj) {
        return gsonBuilder.toJson(obj);
    }

    /**
     * 使用GSON将javaObject转换成字符串
     * @param obj 字符串
     * @param abandonNull 是否丢弃NULL值
     */
    public static String toJsonString(Object obj, Boolean abandonNull) {
        return abandonNull ? GSON.toJson(obj) : toJsonString(obj);
    }

    /**
     * 获取JsonObject的属性
     * @param json json对象
     * @param key key值
     * @return value，不存在该属性时返回空字符串
     */
    public static String getStringValue(JsonObject json, String key){
        Object value = json.get(key);
        if (value==null || value instanceof JsonNull){
            return "";
        }
        return json.get(key).getAsString();
    }
}

