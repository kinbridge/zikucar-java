package com.think.common.utils;

import java.util.UUID;

/**
 * @author bridge
 * @Date 2021/10/24/11:00
 */
public class ThinkStrUtils {

    public static String getUUID() {
        return UUID.randomUUID().toString().replace("_", "");
    }
}
