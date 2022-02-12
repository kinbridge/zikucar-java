package com.think.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.entity.SysPosition;
import com.think.entity.SysUser;
import com.think.mapper.SysPositionMapper;
import com.think.service.ISysPositionService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author bridge
 * @Date 2021/10/16/13:55
 */
@Service
public class SysPositionServiceImpl extends ServiceImpl<SysPositionMapper, SysPosition> implements ISysPositionService {

    @Override
    public IPage<SysPosition> pageList(SysPosition sysPosition, int current, int size) {
        current = current > 0 ? current : 1;
        size = size > 0 ? size : 20;
        QueryWrapper<SysPosition> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(sysPosition.getPositionName()), "position_name", sysPosition.getPositionName());
        Page<SysPosition> page = new Page<>(current, size);
        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
