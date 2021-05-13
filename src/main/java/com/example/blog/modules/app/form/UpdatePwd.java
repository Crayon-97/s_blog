package com.example.blog.modules.app.form;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@ApiModel("修改密码")
public class UpdatePwd {

    @ApiModelProperty("旧密码")
    @NotEmpty(message = "旧密码不能为空")
    private String oldPwd;

    @ApiModelProperty("新密码")
    @NotEmpty(message = "新密码不能为空")
    private String newPwd;
}
