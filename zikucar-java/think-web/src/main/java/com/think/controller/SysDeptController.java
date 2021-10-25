package com.think.controller;

import com.think.common.BaseController;
import com.think.entity.SysDept;
import com.think.service.ISysDeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bridge
 * @Date 2021/10/16/14:01
 */
@RestController
@RequestMapping("/dept")
public class SysDeptController extends BaseController<SysDept> {

    @Autowired
    private ISysDeptService service;

    public ISysDeptService getIService() {
        return service;
    }
}
