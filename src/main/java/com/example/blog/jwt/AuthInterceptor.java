package com.example.blog.jwt;

import com.example.blog.utils.BaseContextHandler;
import com.example.blog.utils.BlException;
import com.example.blog.utils.CommonConstants;
import com.example.blog.utils.Login;
import io.jsonwebtoken.Claims;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

/**
 * 全局拦截器
 */
@Component
@Slf4j
public class AuthInterceptor implements HandlerInterceptor {

    public static final String USER_KEY = "userId";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 有Login注解需要Token
        Login login;
        if(handler instanceof HandlerMethod) {
            login = ((HandlerMethod) handler).getMethodAnnotation(Login.class);
        } else {
            return true;
        }
        if (login == null) {
            return true;
        }
        // Token 验证
        String token = request.getHeader("token");
        if (StringUtils.isEmpty(token)) {
            throw new BlException("token不能为空", HttpStatus.UNAUTHORIZED.value());
        }
        Claims claims = JwtUtil.checkJWT(token);
        // 验证token是否过期
        if(claims == null || JwtUtil.isTokenExpired(claims.getExpiration())){
            throw new BlException("token失效，请重新登录", HttpStatus.UNAUTHORIZED.value());
        }
        // 保存UserID
        BaseContextHandler.set(CommonConstants.CONTEXT_KEY_USER_ID, claims.get("userId"));
        return true;
    }

}