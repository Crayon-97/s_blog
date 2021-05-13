package com.example.blog.utils;

/**
 * 自定义异常BlException
 */
public class BlException extends RuntimeException {

    private String msg;
    private int code = 500;

    public String getMsg() {
        return msg;
    }

    public int getCode() {
        return code;
    }

    public BlException(String msg, Throwable e) {
        super(msg, e);
        this.msg = msg;
    }

    public BlException(String msg, int code) {
        super(msg);
        this.msg = msg;
        this.code = code;
    }
}
