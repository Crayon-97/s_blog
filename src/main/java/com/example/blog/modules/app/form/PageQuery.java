package com.example.blog.modules.app.form;

import io.swagger.annotations.ApiModel;
import lombok.Data;

@Data
@ApiModel("分页参数")
public class PageQuery {
    private int page;
    private int limit;
    private String userId;
}
