package com.example.blog.modules.app.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.modules.app.dao.UserDao;
import com.example.blog.modules.app.entity.UserEntity;
import com.example.blog.modules.app.form.LoginForm;
import com.example.blog.modules.app.form.RegisterFrom;
import com.example.blog.modules.app.form.UpdatePwd;
import com.example.blog.modules.app.service.UserService;
import com.example.blog.jwt.JwtUtil;
import com.example.blog.utils.BaseContextHandler;
import com.example.blog.utils.R;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, UserEntity> implements UserService {

    @Override
    public R login(LoginForm form) {
        // 验证用户
        UserEntity haveUser = baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("user_name", form.getUserName()));
        if (Objects.isNull(haveUser)) {
            return R.error(401, "用户名不存在");
        }
        // 验证用户和密码
        UserEntity userEntity = baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("user_name", form.getUserName()).eq("pwd", DigestUtils.sha256Hex(form.getPwd())));
        if (!Objects.isNull(userEntity)) {
            R r = new R();
            Map<String, Object> result = new HashMap<>();
            result.put("userinfo", userEntity);
            // 生成Token
            result.put("token", JwtUtil.generateJWT(userEntity.getId()));
            r.put("data", result);
            return r;
        }
        return R.error(401, "密码或用户名错误");
    }

    @Override
    public R register(RegisterFrom form) {
        UserEntity userEntity = baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("user_name", form.getUserName()));
        // 判断用户是否存在
        if (Objects.isNull(userEntity)) {
            UserEntity user = new UserEntity();
            user.setUserName(form.getUserName());
            user.setPwd(DigestUtils.sha256Hex(form.getPwd()));
            user.setNickName(form.getNickName());
            user.setCreateTime(new Date());
            baseMapper.insert(user);
            return new R();
        }
        return R.error(400, "用户名已存在");
    }

    @Override
    public R updatePwd(UpdatePwd form) {
        // 获取登录用户ID
        String uderId = BaseContextHandler.getUserID();
        // 加密密码
        String pwd = DigestUtils.sha256Hex(form.getOldPwd());
        String newPwd = DigestUtils.sha256Hex(form.getNewPwd());
        // 比对用户密码是否正确
        UserEntity user = baseMapper.selectOne(new QueryWrapper<UserEntity>().eq("id", uderId).eq("pwd", pwd));
        if (Objects.isNull(user)) {
            return R.error(401, "旧密码错误");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setId(uderId);
        userEntity.setPwd(newPwd);
        // 执行更新操作
        baseMapper.updateById(userEntity);
        return new R();
    }
}