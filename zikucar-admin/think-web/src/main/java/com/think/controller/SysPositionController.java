package com.think.controller;

import com.think.common.BaseController;
import com.think.entity.SysPosition;
import com.think.service.ISysPositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bridge
 * @Date 2021/10/16/14:01
 */
@RestController
@RequestMapping("/position")
public class SysPositionController extends BaseController<SysPosition> {

    @Autowired
    private ISysPositionService service;

    public ISysPositionService getIService() {
        return service;
    }
}
