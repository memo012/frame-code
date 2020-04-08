package com.adminsys.mybatis.utils;


import org.apache.commons.lang3.StringUtils;

/**
 * @Author: qiang
 * @Description:
 * @Create: 2020-04-08 11-06
 **/

public class StringUtil {
    /**
     *  字符串分隔符
     */
    public static final String SEPARATOR = String.valueOf((char) 29);

    public static boolean isEmpty(String str){
        if (str != null) {
            str = str.trim();
        }
        return StringUtils.isEmpty(str);
    }

    public static boolean isNotEmpty(String str){
        return !isEmpty(str);
    }

    /**
     *  分割固定格式的字符串
     * @param str
     * @param separator
     * @return
     */
    public static String[] splitString(String str, String separator){
        return StringUtils.splitByWholeSeparator(str, separator);
    }
}
