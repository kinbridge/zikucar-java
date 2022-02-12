package com.think.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.think.entity.Attachment;
import com.think.entity.SysUser;
import com.think.vo.SysUserVO;

/**
 * @author bridge
 * @Date 2021/10/16/13:54
 */
public interface ISysUserService extends IService<SysUser> {

    boolean register(SysUserVO userVO);

    boolean login(String username, String pwd);

    boolean edit(SysUserVO userVO);

    int editUserStatus(SysUser user);

    IPage<SysUser> pageList(SysUser sysUser, int current, int size);
}
