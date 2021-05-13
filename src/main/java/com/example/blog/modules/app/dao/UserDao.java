package com.example.blog.modules.app.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.blog.modules.app.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserDao extends BaseMapper<UserEntity> {

}