package com.jnshu.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * 用户资料
 * @return
 */
@Controller
@RequestMapping("/a/u")
public class UserDataController {
    private static final Logger log= LoggerFactory.getLogger(UserDataController.class);
    /**
     * 获得用户我的页面信息
     * @return 用户信息
     */
    @GetMapping(value = "/user/{id}")
    @ResponseBody
    public Object user(@PathVariable(value="id") int id,HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"的信息");
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        Map<String, String> map=new HashMap<String, String>();
        map.put("realName"," 罗佳超");
        map.put("property","aaa");
        map.put("cumulativeIncome","12222");
        map.put("realStatus","111");
        json.put("data",map);
        return json;
    }


    /**
     * 获得用户个人信息
     * @return 用户个人信息
     */
    @GetMapping("/user/set/{id}")
    @ResponseBody
    public Object userSet(@PathVariable(value="id") int id,HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"的个人信息");
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        Map<String, String> map=new HashMap<String, String>();
        map.put("phoneNumber","11111");
        map.put("idCard","222222");
        map.put("email","11@qq.com");
        map.put("address","www.wiwj2s.coma");
        map.put("realName","罗佳超");
        map.put("defaultcard","农业银行(2222)");
        json.put("data",map);
        return json;
    }
    /**
     * 实名验证
     * @return 状态码
     */
    @PostMapping("/user/verification/{id}")
    @ResponseBody
    public Object verification(@PathVariable(value="id") int id,HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"实名验证");
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 修改资料
     * @return 状态码
     */
    @PutMapping("/user/set/{id}")
    @ResponseBody
    public Object updateUser(@PathVariable(value="id") int id,
                             @RequestParam(value="email") String email,
                             @RequestParam(value="defaultCard") String defaultCard,
                             @RequestParam(value="address") String address,
                             HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"资料修改页面。email="+email+".defaultCard="+defaultCard+".address="+address);
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 修改密码
     * @return 状态码
     */
    @PutMapping("/user/pasd/{id}")
    @ResponseBody
    public Object pasdUp(@PathVariable(value="id") int id,
                         @RequestParam(value="newPassword") String newPassword,
                         @RequestParam(value="password") String password,
                         HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"资料修改页面。newPassword="+newPassword+".password="+password);

        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 设置手势密码
     * @return 状态码
     */
    @PostMapping("/user/gesture/new")
    @ResponseBody
    public Object gestureNew(@PathVariable(value="id") int id,
                             @RequestParam(value="gesturePassword") String gesturePassword,
                             HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"。gesturePassword="+gesturePassword);
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 原手势密码
     * @return 状态码
     */
    @PostMapping("/user/gesture")
    @ResponseBody
    public Object gesture(@PathVariable(value="id") int id,
                          @RequestParam(value="gesturePassword") String gesturePassword,
                          HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"。gesturePassword="+gesturePassword);
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 修改手势密码
     * @return 状态码
     */
    @PutMapping("/user/gesture")
    @ResponseBody
    public Object gestureUp(@PathVariable(value="id") int id,
                            @RequestParam(value="gestureNewPassword") String gestureNewPassword,
                            HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"。gestureNewPassword="+gestureNewPassword);
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 忘记手势密码
     * @return 状态码
     */
    @PostMapping("/user/gesture/forget")
    @ResponseBody
    public Object gestureForget(@PathVariable(value="id") int id,
                                @RequestParam(value="password") String password,
                                HttpServletRequest request) throws JSONException {
        log.info("获得用户id为"+id+"。password="+password);
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
}
