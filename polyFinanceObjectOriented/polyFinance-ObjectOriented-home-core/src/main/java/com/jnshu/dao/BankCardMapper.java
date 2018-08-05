package com.jnshu.dao;

import com.jnshu.dto1.BankCardRO;
import com.jnshu.dto1.PaymentDto;
import com.jnshu.entity.BankCard;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 银行卡表相关SQL
 * @author wangqichao
 */
@Mapper
@Component(value = "bankCardMapper")
public interface BankCardMapper {
    //通过银行卡id获得银行id
   @Select("select bank_id,bank_card from bank_card where id=#{bankCardId}")
    BankCard getBankIdById(long bankCardId);

    //通过用户id获得用户银行卡相关信息
    @Select("select bank_card.id,bank.bank_name,bank_card.bank_card,bank_card.order,bank.icon,bank.single_limited,bank.day_limited from bank_card inner join bank on bank_card.bank_id=bank.id where bank_card.user_id=#{userId}")
    List<BankCardRO> getBankCardInfoByUserId(long userId);

    //查找交易方式
    @Select("select bank_card.bank_card,bank.bank_name from bank_card inner join bank on bank_card.bank_id=bank.id where bank_card.id=#{bankCardId}")
    PaymentDto getBankCardInfoById(long bankCardId);
}
