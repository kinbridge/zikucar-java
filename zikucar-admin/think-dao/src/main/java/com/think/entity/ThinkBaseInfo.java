package com.think.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.think.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * t_think_base_info
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_think_base_info")
public class ThinkBaseInfo extends BaseEntity {

    /**
     * 产品类型ID
     */
    private Long thinkTypeId;

    /**
     * 产品名称
     */
    private String thinkName;

    /**
     * 创建人ID
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createDate;

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

    private static final long serialVersionUID = 1L;
}