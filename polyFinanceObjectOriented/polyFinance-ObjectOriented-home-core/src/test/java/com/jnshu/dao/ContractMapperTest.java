package com.jnshu.dao;

import com.jnshu.Entry;
import com.jnshu.entity.Claims;
import com.jnshu.entity.Contract;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class ContractMapperTest {
@Autowired
ContractMapper contractMapper;
    @Test
    public void getNewestContractCode() {
        System.out.println(contractMapper.getNewestContractCode());
    }

    @Test
    public void addContractCode() {
        for(int i=0;i<10;i++) {
            Contract contract=new Contract();
            contract.setCreateAt(System.currentTimeMillis());
            contract.setCreateBy(1L);
            contract.setContractCode("UKZXC1800000"+i);
            contract.setIsPay(1);
            contract.setIsMatchingClaims(0);
            contract.setUserSign("王二狗");
            contractMapper.addContractCode(contract);
            System.out.println(contract.getId());
        }
    }

    @Test
    public void getContractCodeById() {
        System.out.println(contractMapper.getContractCodeById(10));
    }

    @Test
    public void getContractIdByCode() {
        System.out.println(contractMapper.getContractIdByCode("UKZXC18000009"));
    }

    @Test
    public void getHaveSignContractById() {
        System.out.println(contractMapper.getHaveSignContractById(9));
    }

    @Test
    public void getHaveSignContractByCode() {
        System.out.println(contractMapper.getHaveSignContractByCode("UKZXC18000009"));
    }

    @Test
    public void getClaimsCodeByCode() {
        System.out.println(contractMapper.getClaimsCodeByCode("UKZXC18000009"));
    }

    @Test
    public void getContractCodeNotMatching(){
        System.out.println(contractMapper.getContractCodeNotMatching());
    }

    @Test
    public void updateClaimsInfo(){
       Contract contract=new Contract();
       contract.setUpdateAt(System.currentTimeMillis());
       contract.setUpdateBy(1);
       contract.setIsMatchingClaims(1);
       contract.setCurrentClaimsCode("UKZX18000002");
       contract.setContractCode("UKZXC18000002");
        System.out.println(contractMapper.updateClaimsInfo(contract));
    }

    @Test
    public void getClaimsCodeByContractCode(){
        System.out.println(contractMapper.getClaimsCodeByContractCode("UKZXC18000002"));
    }
}