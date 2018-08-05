package com.jnshu.utils;

import com.auth0.jwt.interfaces.Claim;
import org.apache.ibatis.plugin.Intercepts;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

@Component
public class MyInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        System.out.println("你好，我是拦截器。");

        long startTime = System.currentTimeMillis();
        request.setAttribute("startTime", startTime);

        TokenUtil tokenUtil = new TokenUtil();
        Cookie cookie = tokenUtil.getCookie(request);

//        System.out.println("拦截器中打印cookie name="+cookie.getName());
        //验证cookie
        if (!"uid".equals(cookie.getName())){
//            System.out.println("拦截器中验证 cookie name="+cookie.getName());
            //第一种方式，直接设置状态码
//            httpServletResponse.sendError(403, " you need loginIn.");
            //第二种方式。通过接口返回信息。
            System.out.println("hahahhahahha");
            response.sendRedirect("/intercepted?next=" + request.getRequestURI());
            return false;
        }

//        System.out.println("拦截器中打印 cookie 时间="+cookie.getMaxAge());
//        if (System.currentTimeMillis()>cookie.getMaxAge()){
//            System.out.println("拦截器中验证 cookie name="+cookie.getMaxAge());
//            httpServletResponse.sendRedirect("/intercepted?next=" + httpServletRequest.getRequestURI());
//            return false;
//        }

        //验证token
//        String token = tokenUtil.getToken(request);
//        System.out.println(token);
        Map<String, Object> token2 =tokenUtil.deToken(request.getHeader("token"));
        Boolean s = (Boolean) token2.get("verifyResult");
        if (s == false) response.sendRedirect("/intercepted?next=" + request.getRequestURI());
        return s;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

        long startTime = (Long) httpServletRequest.getAttribute("startTime");
        httpServletRequest.removeAttribute("startTime");

        long endTime = System.currentTimeMillis();
//        modelAndView.addObject("totalTime", endTime - startTime);

        System.out.println("Request Precessing Time :: " + (endTime - startTime));

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
    }
}
