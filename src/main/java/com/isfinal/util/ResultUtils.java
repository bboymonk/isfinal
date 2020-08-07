/**
 * <br>
 * Copyright 2013 IFlyTek. All rights reserved.<br>
 * <br>
 * Package: com.iflytek.utils <br>
 * FileName: ResultUtil.java <br>
 * <br>
 *
 * @version
 * @author yfcheng@iflytek.com
 * @created 2013-3-21
 * @last Modified
 * @history
 */

package com.isfinal.util;

import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

/**
 * 结果构造工具
 *
 * @author yfcheng@iflytek.com
 */

public class ResultUtils {

    /**
     *
     * 返回json格式
     *
     * @param flag
     *            返回结果状态
     * @param result
     *            结果
     * @return json str
     * @author yfcheng@iflytek.com
     * @created 2013-3-21 上午09:56:01
     * @lastModified
     * @history
     */
    private static String jsonResult(String flag, String result) {
        return "{\"returnFlag\":" + flag + ",\"data\":\"" + result + "\"}";
    }

    /**
     *
     * 返回json格式
     *
     * @param result
     * @return
     * @author yfcheng
     * @created 2014年9月2日 下午4:16:34
     * @lastModified
     * @history
     */
    private static String jsonResult(ResultDto result) {
        return "{\"returnFlag\":" + result.getFlag() + ",\"data\":\"" + result.getResult() + "\"}";
    }

    /**
     *
     * 构造空page
     *
     * @param <T>
     *            模板
     * @param page
     *            分页实体
     * @return 构造后page
     * @author xkfeng@iflytek.com
     * @created 2013-11-22 下午01:10:46
     * @lastModified
     * @history
     */
//	public static <T> Page<T> emptyPage(Page<T> page) {
//		page.setResult(new ArrayList<T>(0));
//		page.setTotalCount(0l);
//		return page;
//	}

    /**
     *
     * 回复结果到页面ajax请求
     *
     * @param response
     *            回执消息
     * @param result
     *            结果
     * @author yfcheng@iflytek.com
     * @created 2013-4-3 上午09:52:24
     * @lastModified
     * @history
     */
    public static void sendResult(HttpServletResponse response, String flag, String result) {
        WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
                WebUtils.CONTENT_CHARSET_UTF8, jsonResult(flag, result));
    }

    /**
     *
     * 回复结果到页面ajax请求
     *
     * @param response
     * @param result
     * @author yfcheng
     * @created 2014年9月2日 下午4:17:29
     * @lastModified
     * @history
     */
    public static void sendResult(HttpServletResponse response, ResultDto result) {
        WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
                WebUtils.CONTENT_CHARSET_UTF8, jsonResult(result));
    }

    /**
     *
     * 回复结果到页面ajax请求
     *
     * @param response
     *            回执消息
     * @param result
     *            结果
     * @author xmzhu2
     * @created 2013-4-15 下午3:51:09
     * @lastModified
     * @history
     */
    public static void sendString(HttpServletResponse response, String result) {
        WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
                WebUtils.CONTENT_CHARSET_UTF8, result);
    }

    /**
     *
     * 回复消息到页面ajax请求
     *
     * @param response
     *            回执对象
     * @param msg
     *            消息
     * @author yfcheng@iflytek.com
     * @created 2013-4-3 上午09:54:04
     * @lastModified
     * @history 2014-08-07 msg -> jsonResult(msg) modify by jnli2
     */
    public static void sendMsg(HttpServletResponse response, String flag, String msg) {
        WebUtils.sendDirectToClient(response, WebUtils.APPLICATIONTYPE_JSON,
                WebUtils.CONTENT_CHARSET_UTF8, jsonResult(flag, msg));
    }

    /**
     *
     * 回复消息到页面ajax请求
     *
     * @param response
     * @param dto
     * @author yfcheng
     * @created 2014年9月2日 下午4:18:09
     * @lastModified
     * @history
     */
    public static void sendMsg(HttpServletResponse response, ResultDto dto) {
        WebUtils.sendDirectToClient(response, WebUtils.APPLICATIONTYPE_JSON,
                WebUtils.CONTENT_CHARSET_UTF8, jsonResult(dto));
    }

    /**
     *
     * 回复列表
     *
     * @param response
     *            回执对象
     * @param list
     *            列表
     * @author yfcheng@iflytek.com
     * @created 2013-4-3 上午10:05:37
     * @lastModified
     * @history
     */
    @SuppressWarnings("rawtypes")
    public static void sendList(HttpServletResponse response, List list) {
        WebUtils.sendDirectToClient(response, WebUtils.APPLICATIONTYPE_JSON,
                WebUtils.CONTENT_CHARSET_UTF8, JsonUtils.jsonArrayString(list));
    }

    /**
     *
     * 回复列表 返回text/html类型
     *
     * @param response
     *            回执对象
     * @param list
     *            列表
     * @author yfcheng@iflytek.com
     * @created 2013-4-3 上午10:05:37
     * @lastModified
     * @history
     */
    @SuppressWarnings("rawtypes")
    public static void sendListHtml(HttpServletResponse response, List list) {
        WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
                WebUtils.CONTENT_CHARSET_UTF8, JsonUtils.jsonArrayString(list));
    }

    /**
     *
     * 回复对象
     *
     * @param response
     *            回执对象
     * @param obj
     *            对象
     * @author yfcheng@iflytek.com
     * @created 2013-4-3 上午10:16:09
     * @lastModified
     * @history
     */
    public static void sendObject(HttpServletResponse response, Object obj) {
        String str;
        try {
            str = JsonUtils.jsonObjectString(obj);
        } catch (Exception e) {
            str = GsonUtils.toJsonString(obj);
        }
        WebUtils.sendDirectToClient(response, WebUtils.APPLICATIONTYPE_JSON,
                WebUtils.CONTENT_CHARSET_UTF8, str);
    }


    /**
     *
     * 回复对象
     *
     * @param response
     *            回执对象
     * @param obj
     *            对象
     * @author yfcheng@iflytek.com
     * @created 2013-4-3 上午10:16:09
     * @lastModified
     * @history
     */
    public static void sendObjectText(HttpServletResponse response, Object obj) {
        WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
                WebUtils.CONTENT_CHARSET_UTF8, JsonUtils.jsonObjectString(obj));
    }

    /**
     *
     * 回复分页
     *
     * @param response
     *            回执对象
     * @param page
     *            分页对象
     * @author yfcheng@iflytek.com
     * @created 2013-4-3 上午11:06:45
     * @lastModified
     * @history
     */
//	@SuppressWarnings("rawtypes")
//	public static void sendPage(HttpServletResponse response, Page page) {
//		String pageJson = (new StringBuilder("{\"total\":")).append(page.getTotalCount())
//				.append(",\"rows\":").append(JsonUtils.jsonArrayString(page.getResult()))
//				.append("}").toString();
//		WebUtils.sendDirectToClient(response, WebUtils.APPLICATIONTYPE_JSON,
//				WebUtils.CONTENT_CHARSET_UTF8, pageJson);
//	}

    /**
     *
     * 回复分页
     *
     * @param response
     *            回执对象
     * @param page
     *            分页对象
     * @author yfcheng@iflytek.com
     * @created 2013-4-3 上午11:06:45
     * @lastModified
     * @history
     */
//	@SuppressWarnings("rawtypes")
//	public static void sendHTMLPage(HttpServletResponse response, Page page) {
//		WebUtils.sendDirectToClient(response, WebUtils.CONTENTTYPE_TEXTHTML,
//				WebUtils.CONTENT_CHARSET_UTF8, page.getJartJsonResult());
//	}

    /**
     *
     * 回复MAP
     *
     * @param response
     * @param map
     * @author yfcheng
     * @created 2014年9月2日 下午4:18:47
     * @lastModified
     * @history
     */
    @SuppressWarnings("rawtypes")
    public static void sendMap(HttpServletResponse response, Map map) {
        WebUtils.sendDirectToClient(response, WebUtils.APPLICATIONTYPE_JSON,
                WebUtils.CONTENT_CHARSET_UTF8, JsonUtils.jsonObjectString(map));
    }

    /**
     * 包装list返回page信息
     *
     * @param response
     * @param page
     * @author Administrator
     * @created 2014年9月26日 下午4:51:41
     * @lastModified
     * @history
     */
//	@SuppressWarnings("unchecked")
//	public static void sendPageWrapperList(HttpServletResponse response, List<?> data) {
//		@SuppressWarnings("rawtypes")
//		Page page = new Page();
//		page.setResult(data);
//		String pageJson = (new StringBuilder("{\"total\":")).append(page.getTotalCount())
//				.append(",\"rows\":").append(JsonUtils.jsonArrayString(page.getResult()))
//				.append("}").toString();
//		WebUtils.sendDirectToClient(response, WebUtils.APPLICATIONTYPE_JSON,
//				WebUtils.CONTENT_CHARSET_UTF8, pageJson);
//
//	}

    /**
     *
     * 封装失败消息
     *
     * @param result
     *            消息
     * @return
     * @author hyzha
     * @created 2014年9月2日 下午4:15:12
     * @lastModified
     * @history
     */
    public static ResultDto fail(String result) {
        ResultDto dto = new ResultDto();
        dto.setFlag("false");
        dto.setResult(result);
        return dto;
    }

    /**
     *  封装失败消息
     *  @param result 消息结果
     *  @param data 需要返回的数据
     *  @return 结果对象
     *  @author ycli7
     *  @created 2014年9月5日 下午2:24:04
     *  @lastModified
     *  @history
     */
    public static ResultDto fail(String result, Object data) {
        return new ResultDto("false", result, data);
    }

    /**
     *  封装成功消息
     *  @param result 消息结果
     *  @param data 需要返回的数据
     *  @return 结果对象
     *  @created 2014年9月5日 下午2:23:49
     *  @lastModified
     *  @history
     */
    public static ResultDto success(String result, Object data) {
        return new ResultDto("true", result, data);
    }

    /**
     * 本月，区县 受理，办结 办件总量,环比比率 ,专用返回对象
     * @param response
     */
    public static void sendWorkPagess(HttpServletResponse response, String flag, List result1, List result2, String rate, String doneRate) {
        String pageJson = (new StringBuilder("{\"flag\":" + '"')).append(flag + '"')
                .append(",\"rate\":").append('"' + rate + '"')
                .append(",\"doneRate\":").append('"' + doneRate + '"')
                .append(",\"data\":[").append(JsonUtils.jsonArrayString(result1) + ',')
                .append(JsonUtils.jsonArrayString(result2))
                .append("]}").toString();
        WebUtils.sendDirectToClient(response, WebUtils.APPLICATIONTYPE_JSON,
                WebUtils.CONTENT_CHARSET_UTF8, pageJson);
    }
}
