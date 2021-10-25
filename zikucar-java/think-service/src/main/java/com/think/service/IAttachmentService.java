package com.think.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.think.entity.Attachment;

/**
 * @author bridge
 * @Date 2021/10/16/13:54
 */
public interface IAttachmentService extends IService<Attachment> {

    /**
     * 分页查询附件
     * @param Attachment Attachment
     * @param current  当前页
     * @param size     查询大小
     * @return
     */
    IPage<Attachment> pageList(Attachment Attachment, int current, int size);
}
