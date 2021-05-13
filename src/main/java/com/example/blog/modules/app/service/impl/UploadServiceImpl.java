package com.example.blog.modules.app.service.impl;

import com.example.blog.modules.app.service.UploadService;
import com.example.blog.utils.BlException;
import com.example.blog.utils.DateUtils;
import com.example.blog.utils.UUIDUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

@Service
public class UploadServiceImpl implements UploadService {
    @Override
    public String upload(MultipartFile multipartFile) {
        if (multipartFile.isEmpty()) {
            throw new BlException("文件不能为空", 401);
        }
        String baseDir = File.separator + "up" + File.separator + DateUtils.getYearMonth() + File.separator;
        File file = new File(baseDir);
        if (!file.isDirectory()) {
            file.mkdirs();
        }
        File target = new File(baseDir + UUIDUtils.generateShortUuid() + multipartFile.getOriginalFilename().substring(multipartFile.getOriginalFilename().lastIndexOf(".")));
        try {
            multipartFile.transferTo(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return baseDir.substring(3) + target.getName();
    }
}
