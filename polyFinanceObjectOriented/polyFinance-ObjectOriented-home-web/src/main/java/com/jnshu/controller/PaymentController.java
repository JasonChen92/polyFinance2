package com.jnshu.controller;

import com.jnshu.dto1.BankCardRO;
import com.jnshu.entity.PaymentRPO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 支付模块相关接口
 * @author wangqichao
 */
@RestController
public class PaymentController {
    private static final Logger log= LoggerFactory.getLogger(PaymentController.class);

    /**
     * 获得投资界面用户银行卡信息
     * @return 用户银行卡信息
     */
    @GetMapping(value = "/a/u/r/pay/investment")
    public Map getInvestment(){
        //从cookie获得id
        long id=1L;
        log.info("获得id为"+id+"的用户的银行卡信息");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        List<BankCardRO> ros=new ArrayList<>();
        for(int i=0;i<2;i++) {
            BankCardRO ro = new BankCardRO();
            ro.setId(784126);
            ro.setBankName("中国建设银行");
            ro.setBankCard("12345678912345678945");
            ro.setOrder(1);
            ro.setSingleLimited("50000");
            ro.setDayLimited("100000");
            ro.setIcon("https://jnshuphoto.oss-cn-hangzhou.aliyuncs.com/headphoto/844.png");
            ros.add(ro);
        }
        map.put("data",ros);
        return map;
    }

    /**
     * 添加续投订单
     * @param id 原订单id
     * @param userSign 用户签名
     * @return 返回参数，code,message
     */
    @PostMapping(value = "/a/u/r/pay/continue")
    public Map addRenewal(@RequestParam(value = "id")long id,@RequestParam(value="userSign")String userSign){
        log.info("添加续投订单，原交易id为"+id);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        return map;
    }

    /**
     * 创建合同并返回用户信息
     * @param userSign 用户签名
     * @return 返回参数，code,message,合同id,用户名，用户身份证号
     */
    @PostMapping(value = "/a/u/r/pay/contract")
    public Map addUserSign(@RequestParam(value="userSign")String userSign){
        log.info("用户签署合同，开始支付");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        map.put("contractId",123456);
        map.put("userName","王大锤");
        map.put("userIdCard","330512196908195487");
        return map;
    }

    /**
     * 获得第三方银行验证码
     * @param phone 手机号
     * @param bankCardId 银行卡id
     * @return code,message
     */
    @PostMapping(value = "/a/u/r/pay/code")
    public Map sendCode(@RequestParam(value="phone")String phone,@RequestParam(value="bankCardId")Long bankCardId){
        long id=1L;
        log.info("用户"+id+"发送银行短信,手机号为"+phone+"，银行卡id为"+bankCardId);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        return map;
    }

    /**
     * 用户支付
     * @param rpo 用户支付信息
     * @return 支付结果,code,message,生成的交易号
     */
    @PostMapping(value = "/a/u/r/pay/payment")
    public Map pay(@ModelAttribute PaymentRPO rpo){
        long id=1L;
        log.info("用户"+id+"支付，支付信息为"+rpo);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        map.put("transactionId",4568752);
        return map;
    }

}
