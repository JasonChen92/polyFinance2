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

//用户设置
@Controller
@RequestMapping("/a/u")
public class UserSiteController {
    private static final Logger log= LoggerFactory.getLogger(UserSiteController.class);
    /**
     * 帮助中心
     * @return dataValue
     */
    @GetMapping("/user/help")
    @ResponseBody
    public Object help(@RequestParam(value="dataName") String dataName,
                       HttpServletRequest request) throws JSONException {
        log.info("dataName为"+dataName);
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        Map<String, String> map=new HashMap<String, String>();
        map.put("dataValue","https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/823.png");
        json.put("data",map);
        return json;
    }
    /**
     * 关于我们
     * @return dataValue
     */
    @GetMapping("/user/about")
    @ResponseBody
    public Object about(@RequestParam(value="dataName") String dataName,
                        HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        Map<String, String> map=new HashMap<String, String>();
        map.put("dataValue","https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/823.png");
        json.put("date",map);
        return json;
    }
    /**
     * 意见反馈
     * @return 状态码
     */
    @PostMapping("/user/feedback")
    @ResponseBody
    public Object feedback(@RequestParam(value="id") String id,
                           @RequestParam(value="content") String content,
                           HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 登出
     * @return
     */
    @GetMapping("/user/logout")
    @ResponseBody
    public Object logout(HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
    /**
     * 更新
     * @return dataValue
     */
    @GetMapping("/user/Update")
    @ResponseBody
    public Object Update(@RequestParam(value="dataName") String dataName,
                         HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        Map<String, String> map=new HashMap<String, String>();
        map.put("dataValue","更新");
        json.put("date",map);
        return json;
    }
}
