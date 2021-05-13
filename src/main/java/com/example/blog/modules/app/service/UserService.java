package com.example.blog.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.blog.modules.app.entity.UserEntity;
import com.example.blog.modules.app.form.LoginForm;
import com.example.blog.modules.app.form.RegisterFrom;
import com.example.blog.modules.app.form.UpdatePwd;
import com.example.blog.utils.R;

import java.io.Serializable;
import java.util.List;

public interface UserService extends IService<UserEntity> {
    R login(LoginForm form);
    R register(RegisterFrom user);
    R updatePwd(UpdatePwd form);
}
