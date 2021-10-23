package com.think.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.entity.Attachment;
import com.think.mapper.AttachmentMapper;
import com.think.service.IAttachmentService;
import org.springframework.stereotype.Service;

/**
 * @author bridge
 * @Date 2021/10/16/13:55
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {

}
