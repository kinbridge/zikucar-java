package com.think.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.think.common.BaseController;
import com.think.common.views.ResultPage;
import com.think.entity.SysPosition;
import com.think.entity.SysUser;
import com.think.service.ISysPositionService;
import com.think.vo.SysPositionQueryVO;
import com.think.vo.SysUserQueryVO;
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
@RequestMapping("/position")
public class SysPositionController extends BaseController<SysPosition> {

    @Autowired
    private ISysPositionService service;

    public ISysPositionService getIService() {
        return service;
    }

    @PostMapping("/pageList")
    public ResultPage listPage(@RequestBody SysPositionQueryVO queryVO) {

        IPage<SysPosition> sysPositionIPage = service.pageList(queryVO.getSysPosition(), queryVO.getPage(), queryVO.getSize());
        ResultPage page = new ResultPage();
        page.setPage(queryVO.getPage());
        page.setSize(queryVO.getSize());
        page.setTotal(sysPositionIPage.getTotal());
        page.setData(sysPositionIPage.getRecords());
        page.setCode(200);
        return page;
    }
}
