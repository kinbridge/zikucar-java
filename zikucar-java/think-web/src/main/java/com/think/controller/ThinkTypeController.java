package com.think.controller;

import com.think.common.BaseController;
import com.think.entity.ThinkType;
import com.think.service.IThinkTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bridge
 * @Date 2021/10/16/14:01
 */
@RestController
@RequestMapping("/thinkType")
public class ThinkTypeController extends BaseController<ThinkType> {

    @Autowired
    private IThinkTypeService service;

    public IThinkTypeService getIService() {
        return service;
    }
}
