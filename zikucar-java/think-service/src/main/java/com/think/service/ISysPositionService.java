package com.think.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.think.entity.SysPosition;

/**
 * @author bridge
 * @Date 2021/10/16/13:54
 */
public interface ISysPositionService extends IService<SysPosition> {

    IPage<SysPosition> pageList(SysPosition sysPosition, int current, int size);
}
