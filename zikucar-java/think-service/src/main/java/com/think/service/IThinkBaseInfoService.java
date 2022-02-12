package com.think.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.think.entity.ThinkBaseInfo;

/**
 * @author bridge
 * 2021/10/16/13:54
 */
public interface IThinkBaseInfoService extends IService<ThinkBaseInfo> {
    IPage<ThinkBaseInfo> pageList(ThinkBaseInfo thinkBaseInfo, int current, int size);
}
