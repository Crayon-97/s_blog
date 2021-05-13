package com.example.blog.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.blog.modules.app.entity.LinkEntity;
import com.example.blog.modules.app.form.PageQuery;
import com.example.blog.modules.app.service.LinkService;
import com.example.blog.utils.Login;
import com.example.blog.utils.PageUtils;
import com.example.blog.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/link")
@Api(tags = "友情链接")
public class LinkControler {

    @Autowired
    LinkService linkService;

    @PostMapping("/save")
    @ApiOperation("添加友情链接")
    @Login
    public R saveLink(@RequestBody LinkEntity linkEntity) {
        linkEntity.setCreateTime(new Date());
        linkService.save(linkEntity);
        return new R();
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    @Login
    public R deleteLeav(@PathVariable String id) {
        linkService.remove(new QueryWrapper<LinkEntity>().eq("id", id));
        return new R();
    }

    @GetMapping("/list")
    @ApiOperation("列表")
    @Login
    public R list(PageQuery form) {
        Page<LinkEntity> page = new Page<>(form.getPage(), form.getLimit());
        Page<LinkEntity> list = linkService.page(page);
        return new R().put("data", new PageUtils(list));
    }

}
