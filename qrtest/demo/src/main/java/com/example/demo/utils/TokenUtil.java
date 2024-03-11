package com.example.demo.utils;

import java.util.Date;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.interfaces.DecodedJWT;

public class TokenUtil {
  private static final long EXPIRE_TIME= 15*60*1000;
    private static final String TOKEN_SECRET="token123";  //密钥盐

    /**
     * 签名生成
     * @return
     */
    public static String sign(String name,Long id){

        String token = null;
        try {
            Date expiresAt = new Date(System.currentTimeMillis() + EXPIRE_TIME);
            token = JWT.create()
                    .withIssuer("auth0")
                    .withClaim("username",name)
                    .withClaim("id",id.toString())
                    .withExpiresAt(expiresAt)
                    // 使用了HMAC256加密算法。
                    .sign(Algorithm.HMAC256(TOKEN_SECRET));
        } catch (Exception e){
            e.printStackTrace();
        }
        return token;

    }
    /**
     * 签名验证
     * @param token
     * @return
     */
    public static boolean verify(String token){

        try {
            JWTVerifier verifier = JWT.require(Algorithm.HMAC256(TOKEN_SECRET)).withIssuer("auth0").build();
            DecodedJWT jwt = verifier.verify(token);
            System.out.println("认证通过：");
            System.out.println("issuer: " + jwt.getIssuer());
            System.out.println("username: " + jwt.getClaim("username").asString());
            System.out.println("id"+jwt.getClaim("id").asString());
            System.out.println("过期时间：      " + jwt.getExpiresAt());
            return true;
        } catch (Exception e){
            return false;
        }
    }
 
    public static String getUserData(String token) {
        DecodedJWT jwt = JWT.decode(token);
        String userId = jwt.getClaim("id").asString();
        String userName  = jwt.getClaim("username").asString();
        if(userId.equals("6")) {
            return userId + "&" + userName;
        }
        return null;
    }
}
