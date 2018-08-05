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
public class SystemDataMapperTest {
@Autowired
SystemDataMapper systemDataMapper;
    @Test
    public void getContractUrl() {
        System.out.println(systemDataMapper.getContractUrl());
    }

    @Test
    public void getInvestmentDay() {
        System.out.println(systemDataMapper.getInvestmentDay());
    }

    @Test
    public void getCompanyCachet() {
        System.out.println(systemDataMapper.getCompanyCachet());
    }

    @Test
    public void getCreditorLine() {
        System.out.println(systemDataMapper.getCreditorLine());
    }

    @Test
    public void getCreditorDay() {
        System.out.println(systemDataMapper.getCreditorDay());
    }
}