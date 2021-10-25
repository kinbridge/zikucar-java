package com.think.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * @author bridge
 * @Date 2021/10/24/0:23
 */
@AllArgsConstructor
@Getter
public enum YesOrNo {
    YES(1,"Y","是"),
    NO(0,"N","否");

    private int intValue;
    private String str;
    private String  desc;
}
