package com.think.controller;

import com.think.common.BaseController;
import com.think.entity.Attachment;
import com.think.service.IAttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author bridge
 * @Date 2021/10/16/14:01
 */
@RestController
@RequestMapping("/attach")
public class AttachmentController extends BaseController<Attachment> {

    @Autowired
    private IAttachmentService service;

    public IAttachmentService getIService() {
        return service;
    }
}
