package com.jnshu.dao;

import com.jnshu.Entry;
import com.jnshu.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class UserMapperTest {
@Autowired
UserMapper userMapper;
    @Test
    public void getUserRealInfo() {
        System.out.println(userMapper.getUserRealInfo(1));
    }

    @Test
    public void getPropertyById() {
        System.out.println(userMapper.getPropertyById(1));
    }

    @Test
    public void updatePropertyById() {
        User user=new User();
        user.setProperty("7000");
        user.setId(1);
        System.out.println(userMapper.updatePropertyById(user));
    }

    @Test
    public void getDefaultCardById() {
        System.out.println(userMapper.getDefaultCardById(1));
    }

    @Test
    public void getUserInfoByContractCode(){
        System.out.println(userMapper.getUserInfoByContractCode("UKZXC18000001"));
    }
}