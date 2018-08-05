package com.jnshu.controller;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.jnshu.entity.Message;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;


@Controller
@RequestMapping("/admin/a/u")
public class MessageController {

    private static final Logger log= LoggerFactory.getLogger(MessageController.class);
    /**
     * 多条件查询消息列表
     * @return 消息列表
     */
    @GetMapping("/messages")
    @ResponseBody
    public Object messages(@RequestParam(value = "pageNum")int pageNum,
                           @RequestParam(value = "pageSize")int pageSize,
                           @ModelAttribute Message Message,
                           HttpServletRequest request) throws JSONException {
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        Map<String, String> map=new HashMap<String, String>();
        map.put("total","9");
        map.put("pageSize","8");
        map.put("id","1");
        map.put("title","更新");
        map.put("sentPersonType","0");
        map.put("isSent","0");
        map.put("loginName","luojiac");
        map.put("createAt","1998/01/01");
        map.put("messageType","1");
        map.put("isPush","1");
        json.put("更新",map);
        return json;
    }

    /**
     * 消息编辑，查看详情
     * @return 消息
     */
    @GetMapping("/messages/{id}")
    @ResponseBody
    public Object getMessage(@PathVariable(value="id") int id,
                             HttpServletRequest request) throws JSONException{
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        Map<String, String> map=new HashMap<String, String>();
        map.put("id","1");
        map.put("title","标题");
        map.put("sentPersonType","0");
        map.put("introduce","简述");
        map.put("content","www.17173.com");
        map.put("isSent","0");
        map.put("loginName","luojiac");
        map.put("createAt","1998/01/01");
        map.put("messageType","1");
        map.put("isPush","1");
        map.put("updateAt","10/1");
        json.put("更新",map);
        return json;
    }
    /**
     * 新增消息
     * @return
     */
    @PostMapping("/messages")
    @ResponseBody
    public Object newMessage(@ModelAttribute Message Message,
                             HttpServletRequest request) throws JSONException{
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }

    /**
     * 消息上下线
     * @return
     */
    @PutMapping("/messages/{id}")
    @ResponseBody
    public Object upMessage(@PathVariable(value="id") int id,
                            HttpServletRequest request) throws JSONException{
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }
//    删除指定消息
    @DeleteMapping("/messages/{id}")
    @ResponseBody
    public Object deleteMessage(@PathVariable(value="id") int id,
                                HttpServletRequest request) throws JSONException{
        JSONObject json = new JSONObject();
        json.put("code",1);
        json.put("message","ok");
        return json;
    }

}
