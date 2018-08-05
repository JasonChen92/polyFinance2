package com.jnshu.controller;

import com.jnshu.entity.TransactionLog;
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
 * 交易流水相关接口
 * @author wangqichao
 */
@RestController
public class TransactionLogController {
    private static final Logger log= LoggerFactory.getLogger(TransactionLogController.class);

    /**
     * 获得用户交易流水列表
     * @return 返回参数,data,message,流水列表
     */
    @GetMapping(value = "/a/u/transaction-log/list")
    public Map getTransactionLogList(){
        long id=1L;
        log.info("查找用户"+id+"交易流水列表");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        List<TransactionLog> logs=new ArrayList<>();
        for (int i=0;i<12;i++) {
            TransactionLog log = new TransactionLog();
            log.setId(521);
            log.setProductName("八星报喜");
            log.setTransactionAt(System.currentTimeMillis());
            log.setStatus(0);
            log.setMoney("50000");
            logs.add(log);
        }
        map.put("data",logs);
        return map;
    }

    /**
     * 获得指定id的交易流水
     * @param id 交易流水id
     * @return 返回参数,code,message,交易流水详情
     */
    @GetMapping(value = "/a/u/transaction-log/{id}")
    public Map getTransactionLog(@PathVariable(value = "id")long id){
        long userId=1L;
        log.info("查找用户"+userId+"交易流水号为"+id+"的交易流水");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        TransactionLog log = new TransactionLog();
        log.setId(id);
        log.setProductName("八星报喜");
        log.setTransactionAt(System.currentTimeMillis());
        log.setStatus(0);
        log.setMoney("50000");
        log.setBankLog("12345678912345678912");
        log.setTransactionWay("建设银行，12345678912345678912");
        map.put("data",log);
        return map;
    }
}
