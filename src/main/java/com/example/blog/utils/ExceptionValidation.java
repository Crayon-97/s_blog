package com.example.blog.utils;

import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 全局异常处理器
 * @author Crayon
 */
@RestControllerAdvice
public class ExceptionValidation {

    /**
     * 处理所有校验失败的异常（MethodArgumentNotValidException异常）
     * @param result
     * @return
     */
    @ExceptionHandler(value = MethodArgumentNotValidException.class)
    public R handleNotValidException(MethodArgumentNotValidException result) {
        // 捕获所有异常
        List<String> errors = result.getBindingResult()
            .getFieldErrors()
            .stream()
            .map(item -> item.getDefaultMessage())
            .collect(Collectors.toList());
        return R.error(401, String.join(",", errors));
    }

    /**
     * 处理自定义异常
     */
    @ExceptionHandler(value = BlException.class)
    public R handleRRException(BlException e){
        R r = new R();
        r.put("code", e.getCode());
        r.put("msg", e.getMsg());
        return r;
    }
}