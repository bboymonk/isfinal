package com.isfinal.util;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;
import org.apache.commons.codec.binary.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;


public class AesUtil {

    /**
     *  AES加密
     *  @param content
     *  @param key
     *  @return
     */
    public static String encryptAES(String content, String key)
            throws NoSuchAlgorithmException, NoSuchPaddingException, UnsupportedEncodingException,
            InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException {
        byte[] byteContent = content.getBytes("UTF-8");
        // 注意，为了能与 iOS 统一
        // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
        byte[] enCodeFormat = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
        byte[] initParam = key.getBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        // 指定加密的算法、工作模式和填充方式
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, secretKeySpec, ivParameterSpec);
        byte[] encryptedBytes = cipher.doFinal(byteContent);
        // 同样对加密后数据进行 base64 编码
        Base64 base64 = new Base64();
        return base64.encodeToString(encryptedBytes);
    }

    /**
     *  AES解密
     *  @param content
     *  @param key
     *  @return
     */
    public static String decryptAES(String content,String key) throws Exception{
        Base64 base64 = new Base64();
        byte[] byteContent = base64.decode(content);
//        byte[] byteContent = content.getBytes("UTF-8");
        // 注意，为了能与 iOS 统一
        // 这里的 key 不可以使用 KeyGenerator、SecureRandom、SecretKey 生成
        byte[] enCodeFormat = key.getBytes();
        SecretKeySpec secretKeySpec = new SecretKeySpec(enCodeFormat, "AES");
        byte[] initParam = key.getBytes();
        IvParameterSpec ivParameterSpec = new IvParameterSpec(initParam);
        //实例化
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        //使用密钥初始化，设置为解密模式
        cipher.init(Cipher.DECRYPT_MODE, secretKeySpec, ivParameterSpec);
        //执行操作
        byte[] encryptedBytes = cipher.doFinal(byteContent);
        // 同样对加密后数据进行 base64 编码
        return new String(encryptedBytes,"utf-8");
    }


    public static void main(String[] args) throws Exception {
        String first=AesUtil.encryptAES("aaaaaaaaaa","iflytekmmp123456");
        System.out.println(first);

        String aaa = "mIdvD7+wg7xwWeSSVdH0s17eRQu94QRKdVD5Md31zXPX4OfNP8YjIvppGIvh1+N7tVe5O7mi3t4Y%20%20LN/IEqL775YtgjYbpRR9WazWi4V5PR/Rnb9lA+Ldva7EQcPoyOndbqXay6WDG3+6f10G3XN9tciD%20%20MreT9DQiMINfoh3sov5CY++2q3YHjKnrJ+V7ObMCNycl0n1FhjIczNnGs41ub7eAZkOgUnS/8l/e%20%203zV1jxE7Hsb4YhYj9vCtwW7mddU/QGy6JZZcHiKJiF81OouOmajhrrAUy9ljHdodUpa5OBMx1U7t%20%20v6xbVuCiNV+ToN3EhxRKTymH1W//zfgbnbvzk71RxO1K9MfQeSx8GWApo73hpEPEsuZEfuoJpnvT%20%20lsUvsH5GnUsX/FLlrwwnIDmKXha5qW4Z34hcqjzyVJXEYHazlrq2VV2vd8KJB+1ZCOYQIpJXQHNh%20%20lq9Ti/i1HtobEx6egufehYKhTUgilWhwS22iP1HwRx9d72/H/uoRmMXO/YrP/vOjSv9Me3H8YKc1%20%20qE2tompLEDkr2EEiMQMIG6r8SsAj9CvGN8/Z5wbVg6lT3OqydDVLucQpiiaRS86nJJiABoCLG0Z0%20%20w5AnfwcS5wZcKwP+QOaQahPVFpiKgZ+1CEE+cM248npO0VxVfmbRBzYbuMZc/sIf9nJHl4KGVxB/%20%20uKRh1SZFam/5nb9m7/GbldFUIaQof8/gxugOA31xJI2cHjnm++Vdo3RdAYmLmCXafSatX2yh1OuE%20%20BU6viKc9qtVjRXjcEQlJqaOmdZFyymluXMuDQxsoFt2+gXTHJ8Ef0nqRxXWFoxpxZpTTonP1hIk5%20%20WQWYj8g45UDE7nXoem9+V/LlvAGdHuVqBWTfzS/uNHyazyRlrngK1gtGsyWq5h0POhdBgt49UW2x%20%20GXIyBy9zQTplz8paFzBOWMLlXOmUtB3J9dJ90AeZpp/jJq6pPaJfcKjPQxW1POz0RP6b793tGJHy%20%20y9u/VNp9Kin9yJZ0323GXHA7r4JflvrQIOr6BZd+ukfFM0/jetWB9+MsAjH2Wl7W0lpDgt25WCrq%20%20A84dHeXb01+J7/0PqQHZ/7Wdw923x6rzaTDvW+ML2UkpBODjn+LPsyFiqIEODEdyo1cpQ+oe0h7w%20%20uq7EOGGqlzn3bt/U7MIR4cbf+B3yw7ujn0ZCDvxmEHHy/9h7Wa0awGQtcdRme0omQi66DGwVy13D%20%2023SCAYShCMVQxIRsNdYIEp8B5u3X2edNGBegOtJEdTVbLLmVf6G9AsWGg/7sBaYCanIVlvK2ZWKe%20%20Lx76ufilyxtq2lKCITUv+Y1EGjtAIH6qRv4I6YoCw4EuegJJz7gctieuIqMsR/oF5YtnmPuU3Jvi%20%20Sg8Bq5hpjaRi0pdQfwuwsnw4MKqryyFxqJgQg0jxsK3YB2aFZwVS4gW1M3CeOzW3rd0m14zrYyJn%20%206PDM+aY4CJN80QcZp5dKS71XjBk2N7wbgY6S3lZ9O6hLh9YbBzPQRWNQExVnH38aVOO9Is9p6je1%20%20zTisLpqEmmFjZmht";


        String second=AesUtil.decryptAES(aaa, "iflytekmmp123456");
        System.out.println(second);

    }


}
