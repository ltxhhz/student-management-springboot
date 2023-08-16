package cn.ltxhhz.springboot_demo.utils;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class JWT {
    /**
     * 密钥
     */
    private static final String SECRET = "67545ddc3d074b6caac6fdc803c28f8567545ddc3d074b6caac6fdc803c28f85";

    /**
     * 从数据声明生成令牌
     *
     * @param claims 数据声明
     * @return 令牌
     */
    static private String generateToken(Map<String, Object> claims) {
        Date expirationDate = new Date(System.currentTimeMillis() + 2592000L * 1000);
        byte[] secret = Base64.getDecoder().decode(SECRET);
        Key key = Keys.hmacShaKeyFor(secret);
        return Jwts.builder().setClaims(claims).setExpiration(expirationDate)
                .signWith(key, SignatureAlgorithm.HS256).compact();
        //下面是使用jwt提供标准的声明
        /**JwtBuilder builder = Jwts.builder().setId(id)
         .setIssuedAt(now)
         .setSubject(subject)
         .setIssuer(issuer)
         .signWith(signatureAlgorithm, signingKey);*/
    }

    /**
     * 从令牌中获取数据声明
     *
     * @param token 令牌
     * @return 数据声明
     */
    static private Claims getClaimsFromToken(String token) {
        Claims claims;
        try {
            claims = Jwts.parser().setSigningKey(SECRET).parseClaimsJws(token).getBody();
        } catch (Exception e) {
            claims = null;
        }
        return claims;
    }

    /**
     * 生成令牌
     *
     * @param account 用户
     * @return 令牌
     */
    static public String generateToken(String account) {
        Map<String, Object> claims = new HashMap<>(2);
        claims.put("sub", account);
        claims.put("created", new Date());
        return generateToken(claims);
    }

    /**
     * 从令牌中获取用户名
     *
     * @param token 令牌
     * @return 用户名
     */
    static public String getUsernameFromToken(String token) {
        String username;
        try {
            Claims claims = getClaimsFromToken(token);
            if (null == claims) {
                return null;
            }
            username = claims.getSubject();
        } catch (Exception e) {
            username = null;
        }
        return username;
    }

    /**
     * 判断令牌是否过期
     *
     * @param token 令牌
     * @return 是否过期
     */
    static public Boolean isTokenExpired(String token) {
        try {
            Claims claims = getClaimsFromToken(token);
            if (null == claims) {
                return false;
            }
            Date expiration = claims.getExpiration();
            return expiration.before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    /**
     * 刷新令牌
     *
     * @param token 原令牌
     * @return 新令牌
     */
    static public String refreshToken(String token) {
        String refreshedToken;
        try {
            Claims claims = getClaimsFromToken(token);
            if (null == claims) {
                return null;
            }
            claims.put("created", new Date());
            refreshedToken = generateToken(claims);
        } catch (Exception e) {
            refreshedToken = null;
        }
        return refreshedToken;
    }

    /**
     * 验证令牌
     *
     * @param token   令牌
     * @param account 用户
     * @return 是否有效
     */
    static public Boolean validateToken(String token, String account) {
        String username = getUsernameFromToken(token);
        return (username.equals(account) && !isTokenExpired(token));
    }
}
