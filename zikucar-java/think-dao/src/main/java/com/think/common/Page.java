package com.think.common;

import lombok.Data;

import java.io.Serializable;

/**
 * @author bridge
 * @Date 2022/02/12/14:00
 */
@Data
public class Page implements Serializable {
    private int page;

    private int size;
}
