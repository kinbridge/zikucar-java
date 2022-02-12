package com.think.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.think.common.BaseController;
import com.think.common.views.ResultPage;
import com.think.entity.SysDept;
import com.think.entity.SysUser;
import com.think.service.ISysDeptService;
import com.think.vo.SysDeptQueryVO;
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
@RequestMapping("/dept")
public class SysDeptController extends BaseController<SysDept> {

    @Autowired
    private ISysDeptService service;

    public ISysDeptService getIService() {
        return service;
    }

    @PostMapping("/pageList")
    public ResultPage listPage(@RequestBody SysDeptQueryVO queryVO) {

        IPage<SysDept> sysDeptIPage = service.pageList(queryVO.getSysDept(), queryVO.getPage(), queryVO.getSize());
        ResultPage page = new ResultPage();
        page.setPage(queryVO.getPage());
        page.setSize(queryVO.getSize());
        page.setTotal(sysDeptIPage.getTotal());
        page.setData(sysDeptIPage.getRecords());
        page.setCode(200);
        return page;
    }
}
