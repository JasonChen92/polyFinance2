package com.jnshu.dao;

import com.jnshu.Entry;
import com.jnshu.dto1.TransactionLogRPO;
import com.jnshu.entity.TransactionLog;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class TransactionLogMapperTest {
    @Autowired
    TransactionLogMapper transactionLogMapper;
    @Test
    public void getTransLogLitByUserId() {
        System.out.println(transactionLogMapper.getTransLogLitByUserId(1));
    }

    @Test
    public void getTransLogById() {
        System.out.println(transactionLogMapper.getTransLogById(1));
    }

    @Test
    public void addTransactionLog() {
        TransactionLog log=new TransactionLog();
        log.setCreateAt(System.currentTimeMillis());
        log.setCreateBy(2L);
        log.setUserId(2L);
        log.setProductName("五谷丰登");
        log.setTransactionAt(System.currentTimeMillis());
        log.setStatus(3);
        log.setMoney("50000");
        log.setBankLog("12345678912345678912");
        log.setTransactionWay("建设银行，12345678912345678912");
        transactionLogMapper.addTransactionLog(log);
        System.out.println(log.getId());
    }

    @Test
    public void getTransLogListByRpo() {
        TransactionLogRPO rpo=new TransactionLogRPO();
        rpo.setId(1L);
        rpo.setProductName("八星报喜");
        rpo.setStatus(0);
        System.out.println(transactionLogMapper.getTransLogListByRpo(rpo));

    }
}