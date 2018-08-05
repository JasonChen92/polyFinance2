package com.jnshu.dao;

import com.jnshu.Entry;
import com.jnshu.entity.ClaimsMatching;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//classes后面是启动类.class
@SpringBootTest(classes = Entry.class)
public class ClaimsMatchingMapperTest {
@Autowired
ClaimsMatchingMapper claimsMatchingMapper;
    @Test
    public void getNewestClaimsProtocolCode() {
        System.out.println(claimsMatchingMapper.getNewestClaimsProtocolCode());
    }

    @Test
    public void addClaimsMatching() {
        ClaimsMatching claimsMatching=new ClaimsMatching();
        claimsMatching.setCreateAt(System.currentTimeMillis());
        claimsMatching.setCreateBy(1);
        claimsMatching.setContractCode("UKZXC18000000");
        claimsMatching.setClaimsId(1);
        claimsMatching.setClaimsProtocolCode("UKZQ18000002");
        System.out.println(claimsMatchingMapper.addClaimsMatching(claimsMatching));
    }
}