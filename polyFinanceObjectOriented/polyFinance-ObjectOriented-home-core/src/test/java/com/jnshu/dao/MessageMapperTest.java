package com.jnshu.dao;

import com.jnshu.Entry;
import com.jnshu.entity.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class MessageMapperTest {
@Autowired
MessageMapper messageMapper;
    @Test
    public void addMessage() {
        Message message=new Message();
        message.setCreateAt(System.currentTimeMillis());
        message.setCreateBy(1L);
        message.setTitle("续投成功");
        message.setIntroduce("你的交易"+message.getTitle());
        message.setTransactionId(1);
        message.setUserId(1);
        System.out.println(messageMapper.addMessage(message));
    }
}