package com.think.common.utils;

import org.springframework.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author bridge
 * @Date 2021/10/24/12:10
 */
public class DateUtils {

    /**
     * 根据特定格式格式化日期
     *
     * @param date   被格式化的日期
     * @param ex 表达式
     * @return 格式化后的字符串
     */
    public static String format(Date date, String ex) {
        if (!StringUtils.hasText(ex) || null == date) {
            return null;
        }
        SimpleDateFormat format = new SimpleDateFormat(ex);
        return format.format(date);
    }
}
