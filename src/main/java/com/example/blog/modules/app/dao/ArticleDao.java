package com.example.blog.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.blog.modules.app.entity.ArticleEntity;
import com.example.blog.modules.app.form.PageQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ArticleDao extends BaseMapper<ArticleEntity> {
    IPage<ArticleEntity> pageList(@Param("page") IPage<ArticleEntity> page, @Param("form") PageQuery form);
}
