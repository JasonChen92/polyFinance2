package com.jnshu.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 用户消息
 * @return
 */
@Controller
@RequestMapping("/a/u")
public class UserMessageController {
    private static final Logger log= LoggerFactory.getLogger(UserMessageController.class);
    /**
     * 用户消息中心
     * @return 消息列表
     */
    @GetMapping("/user/userMessage/list/{id}")
    @ResponseBody
    public Object messageUser(@PathVariable(value="id") int id, HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        Map<String, String> map=new HashMap<String, String>();


        map.put("title","消息1");
        map.put("introduce","这是消息");
        map.put("id","11");
        map.put("content","www.wiwjs.coma");
        json.put("data",map);
        return json;
    }
}
