package com.jnshu.dao;

import com.jnshu.Entry;
import com.jnshu.dto1.*;
import com.jnshu.entity.Transaction;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class TransactionMapperTest {
  @Autowired
  TransactionMapper transactionMapper;
    @Test
    public void addTransaction() {
        for(int i=0;i<10;i++) {
            Transaction transaction = new Transaction();
            transaction.setCreateAt(System.currentTimeMillis());
            transaction.setCreateBy(1L+i);
            transaction.setUserId(12L+i);
            transaction.setStartAt(System.currentTimeMillis());
            transaction.setEndAt(System.currentTimeMillis() + 6 * 30 * 24 * 3600 * 1000L);
            transaction.setRenuwalStatus(0);
            transaction.setMoney("50000");
            transaction.setExpectEarnings("300");
            transaction.setReturned("0");
            transaction.setNotReturn("300");
            transaction.setProductId(1+i);
            transaction.setStatus(0);
            transaction.setContractCode("UKZXC1800000"+i);
            transactionMapper.addTransaction(transaction);
            System.out.println(transaction.getId());
        }
    }

    @Test
    public void updateRenuwalStatus() {
        Transaction transaction = new Transaction();
       transaction.setUpdateAt(System.currentTimeMillis());
       transaction.setUpdateBy(1);
        transaction.setRenuwalStatus(1);
        transaction.setId(2);
        System.out.println(transactionMapper.updateRenuwalStatus(transaction));
    }

    @Test
    public void getOldTransById() {
        System.out.println(transactionMapper.getOldTransactionById(1));
    }

    @Test
    public void getUserIdByClaimsId() {
        Long[] longs=transactionMapper.getUserIdByClaimsId(1);
        for(int i=0;i<longs.length;i++){
            System.out.println(longs[i]);
        }
    }

    @Test
    public void getContractInfoByContractCode() {
        System.out.println(transactionMapper.getContractInfoByContractCode("UKZXC18000001"));
    }

    @Test
    public void updateClaimsId() {
        Transaction transaction = new Transaction();
        transaction.setUpdateAt(System.currentTimeMillis());
        transaction.setUpdateBy(1);
        transaction.setClaimsId(100);
        transaction.setContractCode("UKZXC18000001");
        transactionMapper.updateClaimsId(transaction);
    }

    @Test
    public void getPeopleCountingByProductId() {
        StatisticsSalesListRO ro=new StatisticsSalesListRO();
        ro.setId(1);
        System.out.println(transactionMapper.getPeopleCountingByProductId(ro));
    }

    @Test
    public void getNumberOfTimesByProductId() {
        StatisticsSalesListRO ro=new StatisticsSalesListRO();
        ro.setId(1);
        System.out.println(transactionMapper.getNumberOfTimesByProductId(ro));
    }

    @Test
    public void getSumMoneyByProductId() {
        StatisticsSalesListRO ro=new StatisticsSalesListRO();
        ro.setId(1);
        System.out.println(transactionMapper.getSumMoneyByProductId(ro));
    }

    @Test
    public void getClaimsMatchingList() {
        ClaimsMatchingRPO rpo=new ClaimsMatchingRPO();
        rpo.setId(1L);
        Long userId[]={12L,13L};
        rpo.setUserId(userId);
        System.out.println(transactionMapper.getClaimsMatchingList(rpo));

    }

    @Test
    public void getPeopleCountingByProductIdAndDate() {
        StatisticsSalesRPO rpo=new StatisticsSalesRPO();
        rpo.setId(1);
        rpo.setDateMin(0L);
        System.out.println(transactionMapper.getPeopleCountingByProductIdAndDate(rpo));
    }

    @Test
    public void getNumberOfTimesByProductIdAndDate() {
        StatisticsSalesRPO rpo=new StatisticsSalesRPO();
        rpo.setId(1);
        rpo.setDateMin(1532715124856L);
        rpo.setDateMax(1532715124870L);
        System.out.println(transactionMapper.getNumberOfTimesByProductIdAndDate(rpo));
    }

    @Test
    public void getSumMoneyByProductIdAndDate() {
        StatisticsSalesRPO rpo=new StatisticsSalesRPO();
        rpo.setId(1);
        rpo.setDateMin(153271512485L);
        rpo.setDateMax(1532715124870L);
        System.out.println(transactionMapper.getSumMoneyByProductIdAndDate(rpo));
    }

    @Test
    public void getRenewalListByUserId(){
        System.out.println(transactionMapper.getRenewalListByUserId(12));
    }

    @Test
    public void getTransListByUserIdAndStatus(){
        System.out.println(transactionMapper.getTransListByUserIdAndStatus(0,1));
    }

    @Test
    public void getTransInfoByTransId(){
        System.out.println(transactionMapper.getTransInfoByTransId(1));
    }

    @Test
    public void getTransactionListByUserId(){
        TransactionListRPO rpo=new TransactionListRPO();
        rpo.setId(1);
        System.out.println(transactionMapper.getTransactionListByUserId(rpo));
    }
}