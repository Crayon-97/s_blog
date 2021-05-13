package com.example.blog.jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * jwt
 */
@Slf4j
@Component
public class JwtUtil {

    // 主题
    public static final String SUBJECT = "blog";

    // 密钥
    public static final String SECRET = "8888";

    // 过期时间（一周）
    public static final long EXPIRE = 1000 * 60 * 60 * 24 * 7;

    // 生成 JWT
    public static String generateJWT(String userId) {
        String token = Jwts.builder()
            .setSubject(SUBJECT)
            .claim("userId", userId)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRE))
            .signWith(SignatureAlgorithm.HS256, SECRET).compact();
        return token;
    }

    // 获取Token的信息
    public static Claims checkJWT(String token) {
        try {
            Claims claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
            return claims;
        } catch (Exception e) {
            // e.printStackTrace();
            log.info("Token is error：{}", e);
            return null;
        }
    }

    // 校验Token是否过期
    public static boolean isTokenExpired (Date expirationTime) {
        return expirationTime.before(new Date());
    }
}
