package io.xianzhi.cms.bootstrap.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import io.xianzhi.cms.bootstrap.model.XianZhiUserDetails;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

/**
 * @author Max
 * @since 1.0.0
 */
@Slf4j
@Component
@ConfigurationProperties(prefix = "xianzhi.security.jwt")
public class JwtUtil {


    /**
     * 加密盐值
     */
    @Getter
    @Setter
    private String secretKey = "xianzhiasd5sssssssssssaaaawwwwwwwwww55555555555555555552222222222qqqds";

    /**
     * Token失效时间
     */
    @Getter
    @Setter
    private long jwtExpiration = 2;

    /**
     * Token刷新时间
     */
    @Getter
    @Setter
    private long refreshExpiration = jwtExpiration * 2;


    /**
     * 验证Token是否过期
     * @param token Token
     * @return boolean
     */
    public boolean validateToken(String token) {
        return extractExpiration(token).before(new Date());
    }


    /**
     * 从Token中获取Username
     *
     * @param token Token
     * @return String
     */
    public String getId(String token) {
        return extractClaim(token, Claims::getSubject);
    }

    /**
     * 从Token中回去数据,根据传入不同的Function返回不同的数据
     * eg: String extractUsername(String token)
     */
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        final Claims claims = extractAllClaims(token);
        return claimsResolver.apply(claims);
    }


    /**
     * 生成Token
     *
     * @param userDetails 用户信息
     * @return String
     */
    public String generateToken(XianZhiUserDetails userDetails) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("tokenType", "access");
        return buildToken(extraClaims, userDetails, jwtExpiration);
    }

    /**
     * 生成刷新用的Token
     *
     * @param userDetails 用户信息
     * @return String
     */
    public String generateRefreshToken(XianZhiUserDetails userDetails) {
        Map<String, Object> extraClaims = new HashMap<>();
        extraClaims.put("tokenType", "refresh");
        return buildToken(extraClaims, userDetails, refreshExpiration);
    }

    /**
     * 构建Token方法
     *
     * @param extraClaims 额外信息
     * @param userDetails //用户信息
     * @param expiration  //失效时间
     * @return String
     */
    private String buildToken(Map<String, Object> extraClaims, XianZhiUserDetails userDetails, long expiration) {
        extraClaims.put("id", userDetails.getId());
        return Jwts.builder()
                .setClaims(extraClaims)
                .setIssuer("https://xianzhi.io")
                .setSubject(userDetails.getId())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + expiration * 60 * 60))
                .signWith(getSignInKey(), SignatureAlgorithm.HS256)
                .compact();
    }

    /**
     * 从Token中获取失效时间
     */
    private Date extractExpiration(String token) {
        //通用方法,传入一个Function,返回一个T
        return extractClaim(token, Claims::getExpiration);
    }

    /**
     * 从Token中获取所有数据
     */
    private Claims extractAllClaims(String token) {
        return Jwts
                .parserBuilder()
                .setSigningKey(getSignInKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    /**
     * 获取签名Key
     * Token 加密解密使用
     */
    private Key getSignInKey() {
        byte[] keyBytes = Decoders.BASE64.decode(secretKey);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
