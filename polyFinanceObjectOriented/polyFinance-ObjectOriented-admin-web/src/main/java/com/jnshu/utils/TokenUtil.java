package com.jnshu.utils;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.TokenExpiredException;
import com.auth0.jwt.interfaces.Claim;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.*;

public class TokenUtil {

    //生成cookie
    public Cookie createCookie(Long userId){
        Cookie cookie = new Cookie("uid", String.valueOf(userId));
        cookie.setPath("/");
        cookie.setMaxAge(60*60*60);
        System.out.println("生成cookie："+cookie.getMaxAge());
        return cookie;
    }

    //生成JWT token
    public String createToken(Long userId,String loginName, String role){
        //添加token。
        String secret = "ihLs9rFF9qB!E-x5N5<3lF.{iV<c,\"M2";

        //签发时间
        Date iatDate = new Date();

        //过期时间-10秒过期；
        Calendar nowTime = Calendar.getInstance();
        nowTime.add(Calendar.MINUTE, 1*60*24*3);
//        nowTime.add(Calendar.MINUTE, (int) 0.01);
        Date expiresDate = nowTime.getTime();
//        System.out.println("过期时间="+nowTime.getTimeInMillis());
//        System.out.println("签发时间="+iatDate.getTime());

        String token = null;
        try {
            token = JWT.create()
                    .withIssuer("聚金融后台")
                   .withClaim("uid", userId)
                    .withClaim("loginName", loginName)
                    .withClaim("role", role)
                    .withExpiresAt(expiresDate)      //设置过期时间
                    .withIssuedAt(iatDate)
                   .sign(Algorithm.HMAC384(secret));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return token;
    }

    //从request中获取cookie
    public Cookie getCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies){
            if ("uid".equals(cookie.getName())){
                return cookie;
            }
        }
        return null;
    }

    //从如request中获取token
    public String getToken(HttpServletRequest request){
        return request.getHeader("token");
    }

    //验证token
    public Map<String, Object> deToken(String token)  {
        Map<String, Object> result = new HashMap<>();
        Boolean verifyResult = false;
        String secret = "ihLs9rFF9qB!E-x5N5<3lF.{iV<c,\"M2";
        JWTVerifier verifier = null;

        try {
            verifier = JWT.require(Algorithm.HMAC384(secret)).build();
        } catch (UnsupportedEncodingException e) {

        }

        DecodedJWT jwt = null;
        try {
            jwt=verifier.verify(token);
            verifyResult =true;
            result.put("claims", jwt.getClaims());
        }catch (TokenExpiredException e){

        }catch (NullPointerException e){

        }
        result.put("verifyResult", verifyResult);
        return result;
    }

    //获取登录账户的id,loginName和role
    public Map<String,Object> getAccount(HttpServletRequest request) {
        Map<String,Object> account = new HashMap<>();
        Cookie cookie = getCookie(request);
        Map<String, Object> token2 =deToken(request.getHeader("token"));
        Map<String, Claim> token = (Map<String, Claim>) token2.get("claims");
        account.put("uid", token.get("uid").asLong());
        account.put("loginName", token.get("loginName").asString());
        account.put("role", token.get("role").asString());
        return account;
    }

    public static void main(String[] args) throws Exception {
        TokenUtil u = new TokenUtil();
        String token = u.createToken((long) 1,"admin", "超级管理员");
        System.out.println("token："+token);

//        Map<String,Claim> claimMap =u.deToken(token);
//        System.out.println(header);
        System.out.println(System.currentTimeMillis());
        String expireToken="eyJ0eXAiOiJKV1QiLCJhbGciOiJIUzI1NiJ9.eyJ1aWQiOjIsInJvbGUiOiLogIHomY4iLCJpc3MiOiLogZrph5Hono3lkI7l" +
                "j7AiLCJleHAiOjE1MzMwNDg2MTQsImlhdCI6MTUzMzA0ODYxNH0.X19hJFWJviyYkanlZKtmifoc7rU8j06NKhaUIWnLIDo";
    }
}
