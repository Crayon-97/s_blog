package com.example.blog.modules.app.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.blog.modules.app.dao.LeavDao;
import com.example.blog.modules.app.entity.LeavEntity;
import com.example.blog.modules.app.service.LeavService;
import org.springframework.stereotype.Service;

@Service
public class LeavServiceImpl extends ServiceImpl<LeavDao, LeavEntity> implements LeavService {
}
