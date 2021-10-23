package com.think.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.think.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * @author bridge
 * @Date 2021/10/16/13:47
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_sys_dept")
public class SysDept extends BaseEntity {

    /**
     * 部门编码
     */
    private String deptCode;
    /**
     * 部门名称
     */
    private String deptName;

    /**
     * 备注
     */
    private String remark;

}
