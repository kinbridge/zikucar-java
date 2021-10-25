package com.think.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.think.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * t_sys_user
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_user")
public class SysUser extends BaseEntity {

    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 岗位ID
     */
    private Long positionId;

    /**
     * 用户账号-- 唯一值
     */
    private String uin;

    /**
     * 用户姓名
     */
    private String username;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 电话
     */
    private String phone;

    /**
     * 状态 Y 生效 N 不生效
     */
    private String status;

    /**
     * 创建时间
     */
    private Date createDate;

    /**
     * 创建人ID
     */
    private Integer createBy;

    /**
     * 更新人ID
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private Date updateDate;

    /**
     * 备注
     */
    private String remark;

}