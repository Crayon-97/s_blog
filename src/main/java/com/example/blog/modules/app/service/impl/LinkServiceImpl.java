package com.example.blog.modules.app.service.impl;

import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.modules.app.dao.LinkDao;
import com.example.blog.modules.app.entity.LinkEntity;
import com.example.blog.modules.app.service.LinkService;
import org.springframework.stereotype.Service;

@Service
public class LinkServiceImpl extends ServiceImpl<LinkDao, LinkEntity> implements LinkService {
}
