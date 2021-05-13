package com.example.blog.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.modules.app.entity.ArticleEntity;
import com.example.blog.modules.app.entity.LeavEntity;
import com.example.blog.modules.app.form.PageQuery;
import com.example.blog.modules.app.service.LeavService;
import com.example.blog.utils.BaseContextHandler;
import com.example.blog.utils.Login;
import com.example.blog.utils.PageUtils;
import com.example.blog.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

/**
 * 留言板
 */
@RestController
@Api(tags = "留言板")
@RequestMapping("/leav")
public class LeavController {

    @Autowired
    LeavService leavService;

    @PostMapping("/save")
    @ApiOperation("添加留言板")
    @Login
    public R saveLeav(@RequestBody LeavEntity leavEntity) {
        leavEntity.setUId(BaseContextHandler.getUserID());
        leavEntity.setCreateTime(new Date());
        leavService.save(leavEntity);
        return new R();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    @Login
    public R deleteLeav(@PathVariable String id) {
        leavService.remove(new QueryWrapper<LeavEntity>().eq("id", id));
        return new R();
    }

    @GetMapping("/list")
    @ApiOperation("列表")
    @Login
    public R list(PageQuery form) {
        Page<LeavEntity> page = new Page<>(form.getPage(), form.getLimit());
        Page<LeavEntity> list = leavService.page(page);
        return new R().put("data", new PageUtils(list));
    }
}
