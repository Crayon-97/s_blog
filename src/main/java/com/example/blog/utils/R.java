package com.example.blog.utils;

import java.util.HashMap;

/**
 * 返回数据格式
 */
public class R extends HashMap<String, Object> {

    public R() {
        put("code", 200);
        put("msg", "success");
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }

    public static R error(int code, String msg) {
        R r = new R();
        r.put("code", code);
        r.put("msg", msg);
        return r;
    }
}
