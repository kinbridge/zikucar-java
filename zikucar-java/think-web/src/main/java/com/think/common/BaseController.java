package com.think.common;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.think.common.views.Result;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author bridge
 * @Date 2021/10/16/13:59
 */
public abstract class BaseController<T> {

    public abstract IService<T> getIService();

    @GetMapping("/list")
    public Result list() {
        return Result.success(getIService().list());
    }

    @GetMapping("/page")
    public IPage<T> page(@RequestParam long current, @RequestParam long size) {
        Page<T> page = new Page(current, size);
        return getIService().page(page);
    }

    @GetMapping("/getById/{id}")
    public Result getById(@PathVariable Long id) {
        return Result.success(getIService().getById(id));
    }


    @PostMapping("/add")
    public Result add(@RequestBody T t) {
        return getIService().save(t) ? Result.success("添加成功") : Result.fail("添加失败");
    }

    @PostMapping("/update")
    public Result update(@RequestBody T t) {
        return getIService().updateById(t) ? Result.success("修改成功") : Result.fail("修改失败");
    }

    @GetMapping("/deleteById/{id}")
    public Result deleteById(@PathVariable Long id) {
        return getIService().removeById(id) ? Result.success("删除成功") : Result.fail("删除失败");
    }

}

