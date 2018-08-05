package com.jnshu.controller;

import com.jnshu.entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Controller
public class UserController {

    private static final Logger log= LoggerFactory.getLogger(UserController.class);

    @GetMapping(value = "/find/{id}")
    @ResponseBody
    public Map find(@PathVariable(value = "id")long id ){
        log.info("按照id查询，查询的id为"+id);
        Map map=new HashMap();
        User user=new User();
        user.setId(id);
        user.setUserNumber("UK051111");
        map.put("code",10000);
        map.put("message","ok");
        map.put("data",user);
        return map;
    }
    @GetMapping(value = "/find/all")
    @ResponseBody
    public Map findAll(){
        log.info("查找全部");
        Map map=new HashMap();
        List<User> users=new ArrayList<User>();
        User user1=new User();
        User user2=new User();
        users.add(user1);
        users.add(user2);
        map.put("code",10000);
        map.put("message","ok");
        map.put("data",users);
        return map;
    }



}
