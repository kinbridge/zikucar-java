package com.think.controller;

import com.think.common.views.Result;
import com.think.entity.SysUser;
import com.think.service.ISysUserService;
import com.think.vo.LoginVO;
import com.think.vo.SysUserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

/**
 * @author bridge
 * @Date 2021/10/16/14:01
 */
@RestController
@RequestMapping("/user")
public class SysUserController {

    @Autowired
    private ISysUserService service;

    public ISysUserService getIService() {
        return service;
    }


    @PostMapping("/login")
    public Result login(@RequestBody LoginVO userVO) {

        return service.login(userVO.getUsername(),userVO.getPwd()) ? Result.success("成功") : Result.fail("失败");
    }


    @PostMapping("/register")
    public Result register(@RequestBody SysUserVO userVO) {

        return service.register(userVO) ? Result.success("成功") : Result.fail("失败");
    }

    @PostMapping("/edit")
    public Result edit(@RequestBody SysUserVO userVO) {

        return service.edit(userVO) ? Result.success("成功") : Result.fail("失败");
    }

    @GetMapping("/list")
    public Result list() {
        return Result.success(getIService().list());
    }


    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Long id) {
        SysUser user = getIService().getById(id);
        user.setPwd("");
        return Result.success(user);
    }


    @GetMapping("/editUserStatus/{id}")
    public Result editUserStatus(@PathVariable(value = "id")Long id,
                           @RequestParam(value = "status")String status) {

        if(!StringUtils.hasText(status)){
            return Result.fail();
        }
        SysUser user = new SysUser();
        user.setPkId(id);
        user.setStatus(status);
        return Result.success(service.editUserStatus(user));
    }
}
