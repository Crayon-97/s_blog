package com.example.blog.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Data
@ApiModel("注册表单")
public class RegisterFrom {

    @ApiModelProperty("用户名")
    @NotEmpty(message = "用户名不能为空")
    @Size(min = 3, message = "用户名不能少于3个字符")
    private String userName;

    @NotEmpty(message = "密码不能为空")
    @ApiModelProperty("密码")
    private String pwd;

    @ApiModelProperty("昵称")
    private String nickName;
}
