package com.jnshu.controller;

import com.github.pagehelper.Page;
import com.jnshu.entity.Claims;
import com.jnshu.dto1.ClaimsListRPO;
import com.jnshu.service1.ClaimsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 债权管理相关接口
 * @author  wangqichao
 */
@RestController
public class ClaimsController {
    private static final Logger log= LoggerFactory.getLogger(ClaimsController.class);
    @Autowired
    ClaimsService claimsService;
    /**
     * 获得债权列表
     * @param rpo 接收前端查询数据
     * @return 返回参数，包括code,message,债权列表
     */
    @GetMapping(value = "/a/u/claims/list")
    public Map getClaimsList(@ModelAttribute ClaimsListRPO rpo){
        log.info("查询债权列表，条件是"+rpo);
        Page<Claims> claimsPage=claimsService.getClaimsList(rpo);
        Map<String,Object> map=new HashMap<>();
        map.put("code",0);
        map.put("message","success");
        map.put("total",claimsPage.getTotal());
        map.put("size",claimsPage.getPageSize());
//        List<Claims> claimsList=new ArrayList<Claims>();
//        for(int i=0;i<rpo.getSize();i++){
//            Claims claims=new Claims();
//            claims.setId(1000L+i);
//            claims.setClaimsCode("XTR");
//            claims.setCreditor("小旋风");
//            claims.setCreditorPhoneNumber("13555557777");
//            claims.setCreditorIdCard("660523199001011234");
//            claims.setLendDeadline(12);
//            claims.setLendStartAt(System.currentTimeMillis());
//            claims.setLendEndAt(System.currentTimeMillis()+12*30*24*3600*1000L);
//            claims.setLendMoney("100000");
//            claims.setStatus(1);
//            claims.setRemanentMoney("50000");
//            claimsList.add(claims);
//        }
        System.out.println(claimsPage);
        map.put("data",claimsPage);
        return map;
    }

    /**
     * 获得具体指定债权
     * @param id 指定债权Id
     * @return 返回参数，包括code,message,指定债权数据
     */
    @GetMapping(value = "/a/u/claims/{id}")
    public  Map getClaims(@PathVariable(value = "id")long id){
        log.info("查询债权详情，债权id为"+id);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        Claims claims=new Claims();
        claims.setId(id);
        claims.setClaimsCode("XTR");
        claims.setCreditor("小旋风");
        claims.setCreditorPhoneNumber("13555557777");
        claims.setCreditorIdCard("660523199001011234");
        claims.setLendDeadline(12);
        claims.setLendStartAt(System.currentTimeMillis());
        claims.setLendEndAt(System.currentTimeMillis()+12*30*24*3600*1000L);
        claims.setLendMoney("100000");
        claims.setClaimsNature("自然");
        claims.setClaimsInterestRate("0.18");
        claims.setRemark("无");
        claims.setRemanentMoney("50000");
        map.put("data",claims);
        return map;
    }

    /**
     * 修改指定债权
     * @param claims 接收修改内容
     * @param id 指定债权id
     * @return 修改结果，包括code ,message
     */
    @PutMapping(value = "/a/u/claims/{id}")
    public Map updateClaims(@ModelAttribute Claims claims,@PathVariable(value = "id")long id){
        claims.setId(id);
        log.info("修改债权，修改内容为"+claims);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        return map;
    }

    /**
     * 新增债权
     * @param claims 接收新增内容
     * @return 新增结果，包括code,message，id看情况返回
     */
    @PostMapping(value = "/a/u/claims")
    public Map addClaims(@ModelAttribute Claims claims){
        log.info("新增债权，内容为"+claims);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        log.info("新增债权id为"+1L);
        return map;
    }


}
