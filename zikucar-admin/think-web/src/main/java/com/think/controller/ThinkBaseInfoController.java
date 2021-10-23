package com.think.controller;

import com.think.common.BaseController;
import com.think.entity.ThinkBaseInfo;
import com.think.service.IThinkBaseInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bridge
 * @Date 2021/10/16/14:01
 */
@RestController
@RequestMapping("/thinkBaseInfo")
public class ThinkBaseInfoController extends BaseController<ThinkBaseInfo> {

    @Autowired
    private IThinkBaseInfoService service;

    public IThinkBaseInfoService getIService() {
        return service;
    }
}
