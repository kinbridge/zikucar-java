package com.think.vo;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_sys_user
 * @author 
 */
@Data
public class LoginVO implements Serializable {

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;
}