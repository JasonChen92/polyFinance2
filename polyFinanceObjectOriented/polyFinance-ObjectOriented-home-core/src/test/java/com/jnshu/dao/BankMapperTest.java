package com.jnshu.dao;

import com.jnshu.Entry;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class BankMapperTest {
@Autowired
BankMapper bankMapper;
    @Test
    public void getBankNameById() {
        System.out.println(bankMapper.getBankNameById(1));
    }

    @Test
    public void getPayInfoByBankCardId(){
        System.out.println(bankMapper.getPayInfoByBankCardId(1));
    }
}