package com.think.entity;

import java.io.Serializable;
import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableName;
import com.think.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * t_attachment
 * @author 
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("t_attachment")
public class Attachment extends BaseEntity {

    /**
     * 业务ID
     */
    private Long thinkBaseInfoId;

    /**
     * 业务类型ID
     */
    private Long thinkTypeId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 原始名字
     */
    private String originName;

    /**
     * 文件类型
     */
    private String fileType;

    /**
     * 文件大小
     */
    private Long size;

    /**
     * 文件路径
     */
    private String url;


    /**
     * 在线URL
     */
    private String onlineUrl;

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

    private static final long serialVersionUID = 1L;
}