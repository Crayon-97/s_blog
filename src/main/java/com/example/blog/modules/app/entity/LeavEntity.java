package com.example.blog.modules.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@ApiModel("留言板")
@TableName("leav")
public class LeavEntity {

    // 生成UUID
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("邮箱")
    @NotEmpty(message = "邮箱不能为空")
    private String email;

    @ApiModelProperty("内容")
    @NotEmpty(message = "内容不能为空")
    private String content;

    private Date createTime;

    private String uId;
}
