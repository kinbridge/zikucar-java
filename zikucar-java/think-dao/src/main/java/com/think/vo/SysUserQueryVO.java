package com.think.vo;

import com.think.common.Page;
import com.think.entity.SysUser;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * t_sys_user
 * @author 
 */
@Data
public class SysUserQueryVO extends Page {

    private SysUser sysUser;

}