package com.think.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.think.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * t_sys_position
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_position")
public class SysPosition extends BaseEntity {
    /**
     * 部门ID
     */
    private Long deptId;

    /**
     * 职位编码
     */
    private String positionCode;

    /**
     * 职位名称
     */
    private String positionName;

    /**
     * 部门描述
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}