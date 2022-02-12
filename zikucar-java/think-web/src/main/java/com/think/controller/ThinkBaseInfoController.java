package com.think.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.think.common.BaseController;
import com.think.common.views.ResultPage;
import com.think.entity.ThinkBaseInfo;
import com.think.service.IThinkBaseInfoService;
import com.think.vo.ThinkBaseInfoQueryVO;
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
@RequestMapping("/thinkBaseInfo")
public class ThinkBaseInfoController extends BaseController<ThinkBaseInfo> {

    @Autowired
    private IThinkBaseInfoService service;

    public IThinkBaseInfoService getIService() {
        return service;
    }

    @PostMapping("/pageList")
    public ResultPage listPage(@RequestBody ThinkBaseInfoQueryVO queryVO) {

        IPage<ThinkBaseInfo> thinkBaseInfoIPage = service.pageList(queryVO.getThinkBaseInfo(), queryVO.getPage(), queryVO.getSize());
        ResultPage page = new ResultPage();
        page.setPage(queryVO.getPage());
        page.setSize(queryVO.getSize());
        page.setTotal(thinkBaseInfoIPage.getTotal());
        page.setData(thinkBaseInfoIPage.getRecords());
        page.setCode(200);
        return page;
    }
}
