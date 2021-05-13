package com.example.blog.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.modules.app.entity.LeavEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LeavDao extends BaseMapper<LeavEntity> {
}
