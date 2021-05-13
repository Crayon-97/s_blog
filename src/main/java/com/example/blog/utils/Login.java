package com.example.blog.utils;

import java.lang.annotation.*;

// 作用于方法
@Target(ElementType.METHOD)
// 运行时有效
@Retention(RetentionPolicy.RUNTIME)
public @interface Login {
}
