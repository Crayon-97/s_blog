package com.example.blog.modules.app.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.blog.modules.app.entity.ArticleEntity;
import com.example.blog.modules.app.form.PageQuery;
import com.example.blog.modules.app.service.ArticleService;
import com.example.blog.utils.BaseContextHandler;
import com.example.blog.utils.Login;
import com.example.blog.utils.PageUtils;
import com.example.blog.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Date;

/**
 * 文章类
 */
@RestController
@Api(tags = "文章")
@RequestMapping("/article")
@Slf4j
public class ArticleController {

    @Autowired
    private ArticleService articleService;

    @GetMapping("/list")
    @ApiOperation("列表")
    @Login
    public R getList(PageQuery page) {
        page.setUserId(BaseContextHandler.getUserID());
        PageUtils data = articleService.queryPage(page);
        return new R().put("data", data);
    }

    @PutMapping("/update")
    @ApiOperation("修改")
    @Login
    public R updateArt(@RequestBody ArticleEntity articleEntity) {
        articleEntity.setUpdateTime(new Date());
        return articleService.updateArticle(articleEntity);
    }

    @DeleteMapping("/delete/{id}")
    @ApiOperation("删除")
    @Login
    public R deleteArt(@PathVariable String id) {
        articleService.remove(new QueryWrapper<ArticleEntity>().eq("id", id).eq("u_id", BaseContextHandler.getUserID()));
        return new R();
    }

    @PostMapping("/save")
    @ApiOperation("新增")
    @Login
    public R save(@RequestBody @Valid ArticleEntity articleEntity) {
        articleEntity.setUpdateTime(new Date());
        articleEntity.setCreateTime(new Date());
        articleEntity.setUId(BaseContextHandler.getUserID());
        articleService.save(articleEntity);
        return new R();
    }

    @GetMapping("/all")
    @ApiOperation("公开文章")
    public R allList(PageQuery page) {
        PageUtils data = articleService.queryPage(page);
        return new R().put("data", data);
    }
}
