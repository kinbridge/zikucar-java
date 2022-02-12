package com.think.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.entity.SysPosition;
import com.think.entity.ThinkBaseInfo;
import com.think.entity.ThinkType;
import com.think.mapper.ThinkTypeMapper;
import com.think.service.IThinkTypeService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author bridge
 * @Date 2021/10/16/13:55
 */
@Service
public class ThinkTypeServiceImpl extends ServiceImpl<ThinkTypeMapper, ThinkType> implements IThinkTypeService {

    @Override
    public IPage<ThinkType> pageList(ThinkType thinkType, int current, int size) {
        current = current > 0 ? current : 1;
        size = size > 0 ? size : 20;
        QueryWrapper<ThinkType> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(thinkType.getThinkType()), "think_type", thinkType.getThinkType());
//        Wrapper<ThinkType> queryWrapper = new QueryWrapper<>();
//        if(thinkType != null &&
//                (!com.baomidou.mybatisplus.core.toolkit.StringUtils.isEmpty(thinkType.getThinkCode()))){
//            queryWrapper = new QueryWrapper<>(thinkType);
//        }
        Page<ThinkType> page= new Page<>(current, size);
        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
