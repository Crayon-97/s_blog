package com.example.blog.modules.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.util.Date;


@Data
@TableName("user")
public class UserEntity {

    // 生成UUID
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    private String userName;

    @JsonIgnore
    private String pwd;

    private String nickName;

    private Date createTime;

    private String avatar;
}
