package com.think.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.think.common.enums.ThinkErrorEnum;
import com.think.common.exception.ThinkException;
import com.think.entity.SysUser;
import com.think.mapper.SysUserMapper;
import com.think.service.ISysUserService;
import com.think.vo.SysUserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @author bridge
 * @Date 2021/10/16/13:55
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements ISysUserService {

    @Override
    public boolean register(SysUserVO userVO) {
        if(userVO == null){
            throw new ThinkException(ThinkErrorEnum.PARAMS_IS_NULL.getCode(),ThinkErrorEnum.PARAMS_IS_NULL.getMsg());
        }
        if(!userVO.getPwd().equals(userVO.getPwd2())){
            throw new ThinkException(ThinkErrorEnum.INCONSISTENT_PWD.getCode(),ThinkErrorEnum.INCONSISTENT_PWD.getMsg());
        }

        SysUser user = new SysUser();
        BeanUtils.copyProperties(userVO,user);
        user.setCreateBy(-1);
        user.setCreateDate(new Date());
        return this.save(user);
    }


    @Override
    public boolean login(String username, String pwd) {


        return false;
    }
}
