package com.jnshu.service;

import com.jnshu.Domain2.DomainBank;
import com.jnshu.dto2.BankListRPO;
import com.jnshu.entity.Bank;

import java.util.List;

public interface BankService {

    //银行列表
    List<DomainBank> getBankList(Integer pageNum, Integer pageSize,BankListRPO rpo) throws Exception;

    //查询银行总数。
    Integer getTotal() throws Exception;

    //银行详情
    Bank getBankById(Long id) throws Exception;

    //更新银行信息
    Boolean updateBank(Bank bank) throws Exception;

    //新增银行记录
    Long saveBank(Bank bank) throws Exception;

    //通过银行名查询。如果存在不新增
    Long getBankIdByBankName(String bankName) throws Exception;
}
