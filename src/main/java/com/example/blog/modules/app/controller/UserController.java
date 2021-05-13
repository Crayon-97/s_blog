package com.example.blog.modules.app.controller;

import com.example.blog.modules.app.entity.UserEntity;
import com.example.blog.modules.app.form.LoginForm;
import com.example.blog.modules.app.form.RegisterFrom;
import com.example.blog.modules.app.form.UpdatePwd;
import com.example.blog.modules.app.service.UserService;
import com.example.blog.utils.BaseContextHandler;
import com.example.blog.utils.Login;
import com.example.blog.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * 用户类
 */
@RestController
@Api(tags = "用户")
@Slf4j
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping ("/login")
    @ApiOperation("用户登录")
    public R login(@Valid @RequestBody LoginForm form) {
        return userService.login(form);
    }

    @PostMapping("/register")
    @ApiOperation("注册用户")
    public R register(@Valid @RequestBody RegisterFrom form) {
        return userService.register(form);
    }

    @PostMapping("/pwd")
    @ApiOperation("修改密码")
    @Login
    public R updatePwd(@Valid @RequestBody UpdatePwd form) {
        return userService.updatePwd(form);
    }

    @GetMapping("/info")
    @ApiOperation("用户信息")
    @Login
    public R userInfo() {
        return new R().put("data", userService.getById(BaseContextHandler.getUserID()));
    }

    @PostMapping("/update")
    @ApiOperation("修改用户信息")
    @Login
    public R upInfo(@RequestBody UserEntity form) {
        UserEntity newUser = new UserEntity();
        newUser.setNickName(form.getNickName());
        newUser.setAvatar(form.getAvatar());
        newUser.setId(BaseContextHandler.getUserID());
        userService.updateById(newUser);
        return new R();
    }

}
