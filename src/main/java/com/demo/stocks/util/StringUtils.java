package com.demo.stocks.util;

public class StringUtils {

    public static boolean isNotBlank(String value) {
        return org.apache.commons.lang3.StringUtils.isNotBlank(value);
    }

    public static boolean isBlank(String value) {
        return org.apache.commons.lang3.StringUtils.isBlank(value);
    }
}
