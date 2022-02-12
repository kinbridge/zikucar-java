package com.think.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.think.common.BaseController;
import com.think.common.views.ResultPage;
import com.think.entity.ThinkBaseInfo;
import com.think.entity.ThinkType;
import com.think.service.IThinkTypeService;
import com.think.vo.ThinkTypeQueryVO;
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
@RequestMapping("/thinkType")
public class ThinkTypeController extends BaseController<ThinkType> {

    @Autowired
    private IThinkTypeService service;

    public IThinkTypeService getIService() {
        return service;
    }

    @PostMapping("/pageList")
    public ResultPage listPage(@RequestBody ThinkTypeQueryVO queryVO) {

        IPage<ThinkType> thinkTypeIPage = service.pageList(queryVO.getThinkType(), queryVO.getPage(), queryVO.getSize());
        ResultPage page = new ResultPage();
        page.setPage(queryVO.getPage());
        page.setSize(queryVO.getSize());
        page.setTotal(thinkTypeIPage.getTotal());
        page.setData(thinkTypeIPage.getRecords());
        page.setCode(200);
        return page;
    }
}
