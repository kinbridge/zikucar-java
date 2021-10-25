package com.think.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.entity.Attachment;
import com.think.mapper.AttachmentMapper;
import com.think.service.IAttachmentService;
import com.think.vo.AttachmentListVO;
import org.springframework.stereotype.Service;

/**
 * @author bridge
 * @Date 2021/10/16/13:55
 */
@Service
public class AttachmentServiceImpl extends ServiceImpl<AttachmentMapper, Attachment> implements IAttachmentService {

    @Override
    public IPage<Attachment> pageList(Attachment attachment, int current, int size) {
        current = current > 0 ? current : 1;
        size = size > 0 ? size : 20;
        Wrapper<Attachment> queryWrapper = new QueryWrapper<>();
        if(attachment != null &&
                (!StringUtils.isEmpty(attachment.getOriginName())
                        || attachment.getThinkTypeId()!= null )){
            queryWrapper = new QueryWrapper<>(attachment);
        }
        Page<Attachment> page = new Page<>(current, size);
        return this.baseMapper.selectPage(page, queryWrapper);
    }

}
