package com.jnshu.controller;

import com.jnshu.entity.Claims;
import com.jnshu.dto1.ClaimsMatchingRO;
import com.jnshu.dto1.ClaimsMatchingRPO;
import com.jnshu.entity.ContractMatchingRO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 债权匹配相关接口
 */
@RestController
public class ClaimsMatchingController {
    private static final Logger log= LoggerFactory.getLogger(ClaimsMatchingController.class);

    /**
     * 获得指定债权匹配列表
     * @param rpo 接收传过来的查询数据
     * @param id 需要查询的债权id
     * @return 返回数据，包括code,message,债权信息，匹配的合同信息
     */

    @GetMapping(value = "/a/u/claims/matching/list/{id}")
    public Map getClaimsMatchingList(@ModelAttribute ClaimsMatchingRPO rpo, @PathVariable(value = "id")long id){
        rpo.setId(id);
        log.info("查找指定债权"+id+"匹配信息");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        map.put("total",10086);
        map.put("size",rpo.getSize());
        Claims claims=new Claims();
        claims.setClaimsCode("ZXC");
        claims.setLendStartAt(System.currentTimeMillis());
        claims.setLendEndAt(System.currentTimeMillis()+12*24*30*3600*1000L);
        claims.setLendMoney("1000000");
        claims.setRemanentMoney("50000");
        map.put("data1",claims);
        List<ClaimsMatchingRO> claimsMatchingROES=new ArrayList<>();
        for (int i=0;i<rpo.getSize();i++) {
            ClaimsMatchingRO matchingRO = new ClaimsMatchingRO();
            matchingRO.setContractCode("UKZXC180004"+i+"");
            matchingRO.setClaimsProtocolCode("UKZQ180004"+i+"");
            matchingRO.setUserName("诸葛亮");
            matchingRO.setProductName("三国绝版");
            matchingRO.setStartAt(System.currentTimeMillis());
            matchingRO.setMoney("150000"+i*1000+"");
            claimsMatchingROES.add(matchingRO);
        }
        map.put("data2",claimsMatchingROES);
        return map;
    }

    /**
     * 获得指定id债权的推荐匹配合同列表
     * @param id 指定债权Id
     * @return 返回参数，包括code,message,推荐合同列表（10条）
     */
    @GetMapping(value = "/a/u/claims/matching/setout/{id}")
    public Map getRecommendContractList(@PathVariable(value = "id")long id){
        log.info("获得指定债权"+id+"匹配合同列表");
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        List<ContractMatchingRO> matchingROList=new ArrayList<>();
        for(int i=0;i<10;i++){
            ContractMatchingRO matchingRO=new ContractMatchingRO();
            matchingRO.setContractCode("UKZXC1800000"+i);
            matchingRO.setContractCode("司马懿");
            matchingRO.setContractCode("桃园结义");
            matchingRO.setEndAt(System.currentTimeMillis()+12*30*24*3600*1000L);
            matchingRO.setMoney(5000*i+"5000");
            matchingRO.setFraction(200*i);
            matchingROList.add(matchingRO);
        }
        map.put("data",matchingROList);
        return map;
    }

    /**
     * 保存匹配的债权信息
     * @param id 债权id
     * @param contractCode 合同编号
     * @return 保存结果，code,message
     */
    @PostMapping(value = "/a/u/claims/matching/save")
    public Map saveMatching(@RequestParam(value = "id")long id,@RequestParam(value = "contractCode")String contractCode){
        log.info("保存匹配信息，债权id为"+id+"，合同编号为"+contractCode);
        Map<String,Object> map=new HashMap<>();
        map.put("code",10000);
        map.put("message","ok");
        log.info("债权协议编号为");
        return map;
    }
}
