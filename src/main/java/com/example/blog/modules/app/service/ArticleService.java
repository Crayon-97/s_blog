package com.example.blog.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.modules.app.entity.ArticleEntity;
import com.example.blog.modules.app.form.PageQuery;
import com.example.blog.utils.PageUtils;
import com.example.blog.utils.R;

public interface ArticleService extends IService<ArticleEntity> {
    PageUtils queryPage(PageQuery query);
    R updateArticle(ArticleEntity form);
}
