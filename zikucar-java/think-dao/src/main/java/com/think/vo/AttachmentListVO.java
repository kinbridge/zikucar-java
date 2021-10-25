package com.think.vo;

import com.baomidou.mybatisplus.annotation.TableName;
import com.think.common.BaseEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.Date;

/**
 * t_attachment
 * @author 
 */
@Data
public class AttachmentListVO implements Serializable {

    private Long pkId;

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
    private long size;

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


    /**
     * 超链接（ext）
     */
    private String href;

    private static final long serialVersionUID = 1L;
}