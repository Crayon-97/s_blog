package com.example.blog.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.modules.app.dao.ArticleDao;
import com.example.blog.modules.app.entity.ArticleEntity;
import com.example.blog.modules.app.form.PageQuery;
import com.example.blog.modules.app.service.ArticleService;
import com.example.blog.utils.BaseContextHandler;
import com.example.blog.utils.PageUtils;
import com.example.blog.utils.R;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArticleServiceImpl extends ServiceImpl<ArticleDao, ArticleEntity> implements ArticleService {

    @Override
    public PageUtils queryPage(PageQuery query) {
        Page<ArticleEntity> page = new Page<>(query.getPage(), query.getLimit());
        IPage<ArticleEntity> list = baseMapper.pageList(page, query);
        return new PageUtils(list);
    }

    @Override
    public R updateArticle(ArticleEntity form) {
        baseMapper.update(form, new QueryWrapper<ArticleEntity>().eq("id", form.getId()).eq("u_id", BaseContextHandler.getUserID()));
        return new R();
    }
}
