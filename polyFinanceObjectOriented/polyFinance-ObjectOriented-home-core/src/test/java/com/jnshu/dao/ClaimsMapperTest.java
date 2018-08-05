package com.jnshu.dao;

import com.jnshu.Entry;
import com.jnshu.dto1.ClaimsListRPO;
import com.jnshu.entity.Claims;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class ClaimsMapperTest {
@Autowired
ClaimsMapper claimsMapper;
    @Test
    public void getClaimsListByRpo() {
        ClaimsListRPO rpo=new ClaimsListRPO();
        rpo.setLendDeadlineMin(5);
        rpo.setLendDeadlineMax(18);
        System.out.println(claimsMapper.getClaimsListByRpo(rpo));
    }

    @Test
    public void getClaimsById() {
        System.out.println(claimsMapper.getClaimsById(1));
    }

    @Test
    public void getLendEndById() {
        System.out.println(claimsMapper.getLendEndById(1));
    }

    @Test
    public void getClaimsMatchingById() {
        System.out.println(claimsMapper.getClaimsMatchingById(1));
    }

    @Test
    public void updateClaims() {
        Claims claims=new Claims();
        claims.setUpdateAt(System.currentTimeMillis());
        claims.setUpdateBy(1L);
        claims.setClaimsCode("PHD");
        claims.setCreditor("小旋风");
        claims.setClaimsInterestRate("0.15");
        claims.setId(1);
        claims.setRemark("已公证");
        claims.setCreditorPhoneNumber("13555557777");
        claims.setCreditorIdCard("660523199001011234");
        claims.setLendDeadline(12);
        claims.setLendStartAt(System.currentTimeMillis());
        claims.setLendEndAt(System.currentTimeMillis()+12*30*24*3600*1000L);
        claims.setLendMoney("200000");
        claims.setClaimsNature("保证");
        claims.setRemanentMoney("50000");
        claimsMapper.updateClaims(claims);
    }

    @Test
    public void updateClaimsMoney() {
        Claims claims=new Claims();
        claims.setId(1L);
        claims.setRemanentMoney("30000");
        claims.setStatus(1);
        System.out.println(claimsMapper.updateClaimsMoney(claims));
    }

    @Test
    public void addClaims() {
        Claims claims=new Claims();
        claims.setCreateAt(System.currentTimeMillis());
        claims.setCreateBy(1L);
        claims.setClaimsCode("ZXC");
        claims.setCreditor("小旋风");
        claims.setCreditorPhoneNumber("13555557777");
        claims.setCreditorIdCard("660523199001011234");
        claims.setLendDeadline(12);
        claims.setLendStartAt(System.currentTimeMillis());
        claims.setLendEndAt(System.currentTimeMillis()+12*30*24*3600*1000L);
        claims.setLendMoney("100000");
        claims.setClaimsNature("保证");
        claims.setClaimsInterestRate("0.18");
        claims.setRemark("已公证");
        claimsMapper.addClaims(claims);
        System.out.println(claims.getId());
    }

    @Test
    public void getCreditorInfoByClaimsCode(){
        System.out.println(claimsMapper.getCreditorInfoByClaimsCode("UKZQ18000001"));
    }
}