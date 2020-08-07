package com.isfinal.util;

import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public final class WebUtils {
    public static final String CONTENTTYPE_TEXTHTML = "text/html";
    public static final String APPLICATIONTYPE_JSON = "application/json";
    public static final String CONTENTTYPE_TEXTJSON = "text/json";
    public static final String CONTENTTYPE_TEXTXML = "text/xml";
    public static final String CONTENT_CHARSET_GBK = "GBK";
    public static final String CONTENT_CHARSET_GB2312 = "GB2312";
    public static final String CONTENT_CHARSET_UTF8 = "UTF-8";

    private WebUtils() {
    }


    public static void sendDirectToClient(HttpServletResponse response, String contentType, String charset, String s) {
        Assert.notNull(response);
        String charsetPrefix = ";charset=";
        String contentHead = contentType + charsetPrefix + charset;
        response.setContentType(contentHead);

        try {
            PrintWriter writer = response.getWriter();
            writer.write(s);
            writer.flush();
        } catch (IOException var7) {
            var7.printStackTrace();
        }

    }
}
