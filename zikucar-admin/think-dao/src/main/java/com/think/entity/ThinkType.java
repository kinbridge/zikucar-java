package com.think.entity;

import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableName;
import com.think.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * t_think_type
 *
 * @author
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_think_type")
public class ThinkType extends BaseEntity {

    /**
     * 类型编码
     */
    private Long thinkCode;

    /**
     * 产品类型
     */
    private String thinkType;

    /**
     * 备注
     */
    private String remark;

    private static final long serialVersionUID = 1L;
}