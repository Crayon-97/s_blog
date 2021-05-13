package com.example.blog.modules.app.controller;

import com.example.blog.modules.app.service.UploadService;
import com.example.blog.utils.Login;
import com.example.blog.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件服务
 */
@RestController
@Api(tags = "文件服务")
@RequestMapping("/oss")
public class UploadController {

    @Autowired
    UploadService uploadService;

    @PostMapping("/upload")
    @ApiOperation("上传文件")
    @Login
    public R fileUpload(MultipartFile file) {
        String url = uploadService.upload(file);
        return new R().put("url", url);
    }

}
