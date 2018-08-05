package com.jnshu.controller;

import com.jnshu.dto1.TransactionListBackRO;
import com.jnshu.dto1.TransactionListRPO;
import com.jnshu.dto1.TransactionLogRPO;
import com.jnshu.entity.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *后台用户管理获得指定用户交易和投资记录相关接口
 * @author wangqichao
 */
@RestController
public class UserTransactionController {
    private static final Logger log= LoggerFactory.getLogger(UserTransactionController.class);

    /**
     * 获得指定用户e
     * @param rpo 接收前端分页参数的对象
     * @param id 指定用户id
     * @return 返回参数，code,message,用户流水列表
     */
    @GetMapping(value = "/a/u/user/transaction-log/list/{id}")
    public Map getTransactionLogList(@ModelAttribute TransactionLogRPO rpo, @PathVariable(value = "id")long id){
        rpo.setId(id);
        log.info("查询指定用户"+id+"流水记录，查询条件为"+rpo);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        map.put("total",10086);
        map.put("size",rpo.getSize());
        List<TransactionLog> logs=new ArrayList<>();
        for(int i=0;i<rpo.getSize();i++){
            TransactionLog log=new TransactionLog();
            log.setId(521+i);
            log.setProductName("八星报喜");
            log.setTransactionAt(System.currentTimeMillis());
            log.setBankLog("00001234567812345678");
            log.setStatus(0);
            log.setTransactionWay("农业银行，452185793465125");
            logs.add(log);
        }
        map.put("data",logs);
        return map;
    }

    /**
     * 获得指定用户投资列表
     * @param rpo 接收参数的对象
     * @param id 用户id
     * @return 返回参数，code,message,投资列表
     */
    @GetMapping(value = "/a/u/user/transaction/list/{id}")
    public Map getTransactionList(@ModelAttribute TransactionListRPO rpo, @PathVariable(value = "id")long id){
        rpo.setId(id);
        log.info("查询指定用户"+id+"投资列表");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        map.put("total",rpo.getSize()*3);
        map.put("size",rpo.getSize());
        List<TransactionListBackRO> ros=new ArrayList<>();
        for(int i=0;i<rpo.getSize();i++){
            TransactionListBackRO ro=new TransactionListBackRO();
            ro.setProductName("太平盛世");
            ro.setMoney("10000");
            ro.setStartAt(System.currentTimeMillis());
            ro.setEndAt(System.currentTimeMillis()+6*30*24*3600*1000L);
            ro.setStatus(0);
            ro.setReturned("200");
            ro.setNotReturn("100");
            ro.setContractCode("UKZXC1801000"+i);
            ro.setCurrentClaimsCode("UKZQ1801542"+i);
            ros.add(ro);
        }
        map.put("data",ros);
        return map;
    }

    /**
     * 获得用户指定合同信息
     * @param code 合同编号
     * @return 合同相关信息
     */
    @GetMapping(value = "/a/u/user/transaction/contract/{code}")
    public Map getContract(@PathVariable(value = "code")String code){
        log.info("查看合同编号为"+code+"的合同");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        ContractRO ro=new ContractRO();
        ro.setContractCode(code);
        ro.setContractCreateAt(System.currentTimeMillis());
       ro.setUserName("哼哈");
       ro.setUserIdCard("220513199511110321");
       ro.setCreditor("奔波儿霸");
       ro.setCreditorIdCard("2222222199611111111");
       ro.setUserSign("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/841.png");
       ro.setCompanyCachet("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/842.png");
       ro.setContract("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/840.png");
       map.put("data",ro);
       return map;
    }

    /**
     * 获得指定债权转让协议内容
     * @param code 债权转让协议编号
     * @return 返回参数,code,message,协议内容
     */
    @GetMapping(value = "/a/u/user/transaction/claims/{code}")
    public Map getClaimsProtocolCode(@PathVariable(value = "code")String code){
        log.info("查看债权协议编号为"+code+"的债权转让协议");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        ClaimsProtocolCodeRO ro=new ClaimsProtocolCodeRO();
        ro.setClaimsProtocolCode(code);
        ro.setClaimsCreateAt(System.currentTimeMillis());
        ro.setUserName("哼哈");
        ro.setUserIdCard("220513199511110321");
        ro.setCreditor("奔波儿霸");
        ro.setCreditorIdCard("2222222199611111111");
        ro.setUserSign("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/841.png");
        ro.setCompanyCachet("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/842.png");
        ro.setContract("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/840.png");
        map.put("data",ro);
        return map;
    }

}
