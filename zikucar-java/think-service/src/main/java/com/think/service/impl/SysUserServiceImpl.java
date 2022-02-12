package com.think.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.common.enums.ThinkErrorEnum;
import com.think.common.enums.YesOrNo;
import com.think.common.exception.ThinkException;
import com.think.entity.Attachment;
import com.think.entity.SysUser;
import com.think.mapper.SysUserMapper;
import com.think.service.ISysUserService;
import com.think.vo.SysUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Date;

/**
 * @author bridge
 * @Date 2021/10/16/13:55
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {


    @Override
    public boolean register(SysUserVO userVO) {
        if (userVO == null) {
            throw new ThinkException(ThinkErrorEnum.PARAMS_IS_NULL.getCode(), ThinkErrorEnum.PARAMS_IS_NULL.getMsg());
        }
        if (!userVO.getPwd().equals(userVO.getPwd2())) {
            throw new ThinkException(ThinkErrorEnum.INCONSISTENT_PWD.getCode(), ThinkErrorEnum.INCONSISTENT_PWD.getMsg());
        }
        SysUser user = getSysUser(userVO);
        return this.save(user);
    }


    @Override
    public boolean login(String username, String pwd) {

        if (!StringUtils.hasText(username)) {
            throw new ThinkException(ThinkErrorEnum.USER_PWD_OR_IS_NULL.getCode(),
                    ThinkErrorEnum.USER_PWD_OR_IS_NULL.getMsg());
        }
        SysUser sysUser = getSysUserByUsername(username);
        if (sysUser == null) {
            throw new ThinkException(ThinkErrorEnum.USER_ERROR.getCode(), ThinkErrorEnum.USER_ERROR.getMsg());
        }
        if(YesOrNo.NO.getStr().equals(sysUser.getStatus())){
            throw new ThinkException(ThinkErrorEnum.USER_INVALID.getCode(), ThinkErrorEnum.USER_INVALID.getMsg());
        }

        if (!sysUser.getPwd().equals(pwd)) {
            throw new ThinkException(ThinkErrorEnum.PWD_ERROR.getCode(), ThinkErrorEnum.PWD_ERROR.getMsg());
        }
        return true;
    }

    private SysUser getSysUserByUsername(String username) {
        SysUser user = new SysUser();
        user.setUsername(username);
        Wrapper<SysUser> queryWrapper = new QueryWrapper<SysUser>(user);
        return this.getOne(queryWrapper);
    }

    @Override
    public boolean edit(SysUserVO userVO) {

        SysUser sysUser = getSysUserByUsername(userVO.getUsername());
        if (sysUser == null) {
            SysUser user = getSysUser(userVO);
            return this.save(user);
        }
        // 输入旧密码是否正确
        if (StringUtils.hasText(userVO.getPwd())) {
            if (!sysUser.getPwd().equals(userVO.getPwd())) {
                throw new ThinkException(ThinkErrorEnum.OLD_PWD_ERROR.getCode(), ThinkErrorEnum.OLD_PWD_ERROR.getMsg());
            }
        }
        SysUser user = new SysUser();
        BeanUtils.copyProperties(userVO, user);
        // 新的为空，继续使用旧密码
        if (StringUtils.hasText(userVO.getPwdNew())) {
            user.setPwd(userVO.getPwdNew());
        }else{
            user.setPwd(sysUser.getPwd());
        }
        user.setPkId(sysUser.getPkId());
        user.setCreateBy(sysUser.getCreateBy());
        user.setCreateDate(sysUser.getCreateDate());
        user.setUpdateBy(-1);
        user.setUpdateDate(new Date());
        return this.updateById(user);
    }

    @Override
    public int editUserStatus(SysUser user) {

        return this.baseMapper.editUserStatus(user);
    }

    @Override
    public IPage<SysUser> pageList(SysUser sysUser, int current, int size) {
        current = current > 0 ? current : 1;
        size = size > 0 ? size : 20;
        QueryWrapper<SysUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(StringUtils.hasText(sysUser.getUsername()), "username", sysUser.getUsername());
        Page<SysUser> page = new Page<>(current, size);
        return this.baseMapper.selectPage(page, queryWrapper);
    }


    private SysUser getSysUser(SysUserVO userVO) {
        SysUser user = new SysUser();
        BeanUtils.copyProperties(userVO, user);
        user.setCreateBy(-1);
        user.setCreateDate(new Date());
        return user;
    }
}
