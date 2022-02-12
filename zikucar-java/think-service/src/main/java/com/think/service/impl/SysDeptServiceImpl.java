package com.think.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.entity.SysDept;
import com.think.entity.SysUser;
import com.think.mapper.SysDeptMapper;
import com.think.service.ISysDeptService;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * @author bridge
 * @Date 2021/10/16/13:55
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<SysDeptMapper, SysDept> implements ISysDeptService {

    @Override
    public IPage<SysDept> pageList(SysDept sysDept, int current, int size) {
        current = current > 0 ? current : 1;
        size = size > 0 ? size : 20;
        QueryWrapper<SysDept> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(sysDept.getDeptName()), "dept_name", sysDept.getDeptName());
        Page<SysDept> page = new Page<>(current, size);
        return this.baseMapper.selectPage(page, queryWrapper);
    }
}
