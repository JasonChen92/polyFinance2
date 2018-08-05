package com.jnshu.dao;

import com.jnshu.entity.Message;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 消息相关SQL
 * @author wangqichao
 */
@Mapper
@Component(value = "messageMapper")
public interface MessageMapper {
    //新增消息
    @Insert("insert into message (create_at,create_by,title,introduce,transaction_id,user_id) values (#{createAt},#{createBy},#{title},#{introduce},#{transactionId},#{userId})")
    int addMessage(Message message);


}
