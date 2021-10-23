package com.think.controller;

import com.think.common.BaseController;
import com.think.common.views.Result;
import com.think.entity.SysUser;
import com.think.service.ISysUserService;
import com.think.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bridge
 * @Date 2021/10/16/14:01
 */
@RestController
@RequestMapping("/user")
public class SysUserController extends BaseController<SysUser> {

    @Autowired
    private ISysUserService service;

    public ISysUserService getIService() {
        return service;
    }

    @PostMapping("/register")
    public Result register(@RequestBody SysUserVO userVO) {

        return getIService().register(userVO) ? Result.success("成功") : Result.fail("失败");
    }
}
