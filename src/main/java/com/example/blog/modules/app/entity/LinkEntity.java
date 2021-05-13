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
@ApiModel("友情链接")
@TableName("link")
public class LinkEntity {

    // 生成UUID
    @TableId(type = IdType.ASSIGN_UUID)
    private String id;

    @ApiModelProperty("网站名称")
    @NotEmpty(message = "网站名称不能为空")
    private String title;

    @ApiModelProperty("网站链接")
    @NotEmpty(message = "网站链接不能为空")
    private String url;

    private Date createTime;

    @ApiModelProperty("描述")
    private String remark;

}
