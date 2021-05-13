package com.example.blog.modules.app.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
@TableName("article")
@ApiModel("文章")
public class ArticleEntity {

    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("标题")
    @NotEmpty(message = "文章标题不能为空")
    private String title;

    @ApiModelProperty("内容")
    @NotEmpty(message = "内容不能为空")
    private String content;

    private Date updateTime;

    private Date createTime;

    @JsonIgnore
    private String uId;

    @ApiModelProperty("标签")
    private String tag;

    private String remark;
}
