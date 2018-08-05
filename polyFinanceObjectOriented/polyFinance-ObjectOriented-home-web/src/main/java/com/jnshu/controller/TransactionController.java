package com.jnshu.controller;

import com.jnshu.dto1.TransactionListRO;
import com.jnshu.dto1.TransactionRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 投资信息相关接口
 * @author wangqichao
 */
@RestController
public class TransactionController {
    private static final Logger log= LoggerFactory.getLogger(TransactionController.class);

    /**
     * 获得续投列表
     * @return 返回参数,code,message,续投
     */
    @GetMapping(value = "/a/u/transaction/list/continue")
    public Map getContinueInvList(){
        //注意要判断续投时间
        long id=1L;
        log.info("获得用户"+id+"的可续投列表");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        List<TransactionListRO> ros=new ArrayList<>();
        for(int i=0;i<10;i++){
            TransactionListRO ro=new TransactionListRO();
            ro.setId(1245+i);
            ro.setProductName("金玉满堂");
            ro.setInterestRate("0.18");
            ro.setMoney("50000");
            ro.setMark(2);
            ro.setStartAt(System.currentTimeMillis());
            ro.setEndAt(System.currentTimeMillis()+6*30*24*3600*1000L);
            ros.add(ro);
        }
        map.put("data",ros);
        return map;
    }

    /**
     * 获得用户投资列表
     * @param status 投资状态
     * @return 返回参数，code,message,投资列表
     */
    @GetMapping(value = "/a/u/transaction/list/{status}")
    public Map getTransactionList(@PathVariable(value = "status")Integer status){
        long id=1L;
        log.info("获得用户"+id+"的投资列表列表，投资状态为"+status);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        List<TransactionListRO> ros=new ArrayList<>();
        for(int i=0;i<10;i++){
            TransactionListRO ro=new TransactionListRO();
            ro.setId(1245+i);
            ro.setProductName("金玉满堂");
            ro.setInterestRate("0.18");
            ro.setMoney("50000");
            ro.setMark(2);
            ro.setStartAt(System.currentTimeMillis());
            ro.setEndAt(System.currentTimeMillis()+6*30*24*3600*1000L);
            ro.setStatus(status);
            ros.add(ro);
        }
        map.put("data",ros);
        return map;
    }

    /**
     * 获得用户投资详情
     * @param id 交易id
     * @return code,message,交易详情data
     */
    @GetMapping(value = "/a/u/transaction/{id}")
    public Map getTransaction(@PathVariable(value = "id")long id){
        log.info("获得用户的具体投资详情，交易id为"+id);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        TransactionRO ro=new TransactionRO();
        ro.setId(id);
        ro.setProductName("太平盛世");
        ro.setInterestRate("0.15");
        ro.setMoney("10000");
        ro.setMark(1);
        ro.setStartAt(System.currentTimeMillis());
        ro.setEndAt(System.currentTimeMillis()+6*30*24*3600*1000L);
        ro.setStatus(0);
        ro.setExceptEarnings("300");
        ro.setReturned("200");
        ro.setNotReturn("100");
        ro.setInvestmentAmount("50000");
        ro.setDefaultCardBankName("建设银行");
        ro.setDefaultCardId("12345678912345678912");
        ro.setRefundStyle(1);
        ro.setContractId(123456);
        ro.setRenuwalStatus(1);
        ro.setProductStatus(0);
        map.put("data",ro);
        return map;
    }
}
