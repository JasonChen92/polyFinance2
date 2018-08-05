package com.jnshu.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * 用户注册及登入
 * @return
 */
@Controller
@RequestMapping("/a")
public class UserLoginController {

    private static final Logger log= LoggerFactory.getLogger(UserLoginController.class);

    /**
     * 登入
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public Object login(@RequestParam(value="phoneNumber") String phone_number,
                        HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }


    /**
     * 注册 验证验证码
     * @return
     */
    @PostMapping("/register")
    @ResponseBody
    public Object register(@RequestParam(value="phoneNumber") String phone_number,
                           @RequestParam(value="password") String password,
                           @RequestParam(value="code") String code,
                           HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 注册 发送验证码
     * @return
     */
    @GetMapping("/register/code")
    @ResponseBody
    public Object code(@RequestParam(value="phoneNumber") String phone_number,
                       HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 找回密码
     * @return
     */
    @PutMapping("/user/pswd")
    @ResponseBody
    public Object findBack(@RequestParam(value="phoneNumber") String phone_number,
                           @RequestParam(value="code") String code,
                           HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }





}
