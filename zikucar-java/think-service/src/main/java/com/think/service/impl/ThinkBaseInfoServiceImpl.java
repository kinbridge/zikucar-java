package com.think.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.entity.SysDept;
import com.think.entity.ThinkBaseInfo;
import com.think.entity.ThinkType;
import com.think.mapper.ThinkBaseInfoMapper;
import com.think.service.IThinkBaseInfoService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author bridge
 * 2021/10/16/13:55
 */
@Service
public class ThinkBaseInfoServiceImpl extends ServiceImpl<ThinkBaseInfoMapper, ThinkBaseInfo> implements IThinkBaseInfoService {

    @Override
    public IPage<ThinkBaseInfo> pageList(ThinkBaseInfo thinkBaseInfo, int current, int size) {
        current = current > 0 ? current : 1;
        size = size > 0 ? size : 20;
        QueryWrapper<ThinkBaseInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(thinkBaseInfo.getThinkName()), "think_name", thinkBaseInfo.getThinkName());
        Page<ThinkBaseInfo> page= new Page<>(current, size);
        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
