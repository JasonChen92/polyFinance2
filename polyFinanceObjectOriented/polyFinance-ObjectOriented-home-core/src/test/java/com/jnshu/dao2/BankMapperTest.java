package com.jnshu.dao2;

import com.jnshu.Entry;
import com.jnshu.dto2.BankListRPO;
import com.jnshu.entity.Bank;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class BankMapperTest {

    @Resource
    BankMapper2 mapper;
    @Test
    public void saveBank() throws Exception {
        Long crateTime=System.currentTimeMillis();
        Bank bank = new Bank();
        bank.setCreateAt(crateTime);
        bank.setCreateBy(1);
        bank.setUpdateAt(crateTime);
        bank.setUpdateBy(1);
        bank.setBankName("工商银行");
        bank.setPaymentId("IOU798732457902");
        bank.setWithdrawalId("WER579345203458");
        bank.setSingleLimited("300000");
        bank.setDayLimited("10000000");
        bank.setIcon("www.baidu.com");
        mapper.saveBank(bank);
        System.out.println(bank.getId());
        crateTime=System.currentTimeMillis();
        bank.setCreateAt(crateTime);
        bank.setCreateBy(2);
        bank.setUpdateAt(crateTime);
        bank.setUpdateBy(2);
        bank.setBankName("农业银行");
        bank.setSingleLimited("100000");
        bank.setDayLimited("2000000");
//        mapper.saveBank(bank);
        crateTime=System.currentTimeMillis();
        bank.setCreateAt(crateTime);
        bank.setCreateBy(3);
        bank.setUpdateAt(crateTime);
        bank.setUpdateBy(3);
        bank.setBankName("兴业银行");
        bank.setSingleLimited("500000");
        bank.setDayLimited("6000000");
//        mapper.saveBank(bank);
        crateTime=System.currentTimeMillis();
        bank.setCreateAt(crateTime);
        bank.setCreateBy(4);
        bank.setUpdateAt(crateTime);
        bank.setUpdateBy(4);
        bank.setBankName("建设银行");
        bank.setSingleLimited("230000");
        bank.setDayLimited("6600000");
//        mapper.saveBank(bank);

        crateTime=System.currentTimeMillis();
        bank.setCreateAt(crateTime);
        bank.setCreateBy(5);
        bank.setUpdateAt(crateTime);
        bank.setUpdateBy(5);
        bank.setBankName("光大银行");
        bank.setSingleLimited("1200000");
        bank.setDayLimited("5400000");
//        mapper.saveBank(bank);
        crateTime=System.currentTimeMillis();
        bank.setCreateAt(crateTime);
        bank.setCreateBy(6);
        bank.setUpdateAt(crateTime);
        bank.setUpdateBy(6);
        bank.setBankName("中信银行");
        bank.setSingleLimited("890000");
        bank.setDayLimited("9900000");
//        mapper.saveBank(bank);
    }

    @Test
    public void deleteBank() {
    }

    @Test
    public void updateBank() throws Exception {
        Bank bank = mapper.getBankById((long) 8);
        System.out.println(bank);
        bank.setBankName("呵呵呵");
        System.out.println(mapper.updateBank(bank));
        System.out.println(mapper.getTotal());
    }

    @Test
    public void getTotal() {
    }

    @Test
    public void getBankById() {
    }

    @Test
    public void getBankList() throws Exception {
        BankListRPO rpo = new BankListRPO();
        rpo.setBankName("银");
        rpo.setUpdateBy("admin");
//        rpo.setUpdateAt1(1532887064915L);
//        rpo.setUpdateAt2(1532887114897L);
//        rpo.setDayLimited1("3000000");
//        rpo.setDayLimited2("6600000");
//        rpo.setSingleLimited1("300000");
//        rpo.setSingleLimited2("500000");

        System.out.println(mapper.getBankList(rpo).size());
    }
}