package com.jnshu.service.implement;

import com.github.pagehelper.PageHelper;
import com.jnshu.Domain2.DomainBank;
import com.jnshu.dao2.BankMapper2;
import com.jnshu.dto2.BankListRPO;
import com.jnshu.entity.Bank;
import com.jnshu.service.BankService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class BankServiceImpl implements BankService {

    @Autowired
    BankMapper2 bankMapper2;


    @Override
    public List<DomainBank> getBankList(Integer pageNum, Integer pageSize, BankListRPO rpo) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return bankMapper2.getBankList(rpo);
    }

    //查询银行总数。
    @Override
    public Integer getTotal() throws Exception {
        return bankMapper2.getTotal();
    }

    //银行详情
    @Override
    public Bank getBankById(Long id) throws Exception {
        return bankMapper2.getBankById(id);
    }

    //更新银行信息
    @Override
    public Boolean updateBank(Bank bank) throws Exception {
        return bankMapper2.updateBank(bank);
    }

    //新增银行记录。
    @Override
    public Long saveBank(Bank bank) throws Exception {
        return bankMapper2.saveBank(bank);
    }

    @Override
    public Long getBankIdByBankName(String bankName) throws Exception {
        return bankMapper2.getBankIdByBankName(bankName);
    }
}
