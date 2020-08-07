package com.isfinal.util;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.serializer.SerializeFilter;
import com.alibaba.fastjson.serializer.SerializerFeature;

import java.util.*;

public class JsonUtils {

    public JsonUtils() {
    }

    public static String jsonArrayString(List data) {
        return JSONArray.toJSONString(data, new SerializerFeature[]{SerializerFeature.WriteTabAsSpecial, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty});
    }

    public static String jsonObjectString(Object obj) {
        return JSONObject.toJSONString(obj, new SerializerFeature[]{SerializerFeature.WriteTabAsSpecial, SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteMapNullValue, SerializerFeature.WriteNullStringAsEmpty, SerializerFeature.DisableCircularReferenceDetect});
    }

    public static String jsonObjectString(Object obj, SerializeFilter filter) {
        JSONObject json = (JSONObject) JSONObject.toJSON(obj);
        return JSONObject.toJSONString(json, filter, new SerializerFeature[]{SerializerFeature.WriteNullBooleanAsFalse, SerializerFeature.WriteNullNumberAsZero, SerializerFeature.WriteNullListAsEmpty, SerializerFeature.WriteNullStringAsEmpty});
    }

    public static <T> T fromJson(String approveData, Class<T> clzz) {
        JSONObject jsonObj = JSONObject.parseObject(approveData);
        return JSONObject.toJavaObject(jsonObj, clzz);
    }

    public static JSONObject parseObject(String json) {
        return JSONObject.parseObject(json);
    }

    public static <T> List<T> parseArray(String jsonArray, Class<T> clzz) {
        return JSONObject.parseArray(jsonArray, clzz);
    }

    public static JSONArray parseJsonArray(String jsonArray) {
        return JSONArray.parseArray(jsonArray);
    }

    public static Map<String, Object> parseMapData(String data) {
        Map<String, Object> context = new HashMap();
        JSONObject jsonObject = JSONObject.parseObject(data);
        Set<String> keys = jsonObject.keySet();
        Iterator var4 = keys.iterator();

        while (var4.hasNext()) {
            String key = (String) var4.next();
            context.put(key, jsonObject.get(key));
        }

        return context;
    }

    public static String toJsonString(Object data) {
        return JSONObject.toJSONString(data);
    }


}
