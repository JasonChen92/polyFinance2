package com.jnshu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 银行相关SQL
 * @author  wangqichao
 */
@Mapper
@Component(value = "bankMapper")
public interface BankMapper {
    //获得银行名
    @Select("select bank_name from bank where id=#{bankId}")
    String getBankNameById(long bankId);

    @Select("select bank.payment_id from bank inner join bank_card on bank_card.bank_id=bank.id where bank_card.id=#{bankCardId}")
    String getPayInfoByBankCardId(long bankCard);
}
