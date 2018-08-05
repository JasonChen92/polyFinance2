package com.jnshu.dao;

import com.jnshu.dto1.TransactionLogRPO;
import com.jnshu.entity.TransactionLog;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 交易流水相关SQL
 * @author wangqichao
 */
@Mapper
@Component(value ="transactionLogMapper")
public interface TransactionLogMapper {

    //前台查找指定用户交易流水
    @Select("select id,product_name,transaction_at,money,status from transaction_log where user_id=#{userId} order by create_at desc")
    List<TransactionLog> getTransLogLitByUserId(long userId);

     //按照交易流水id查找交易流水详情
    @Select("select id,product_name,transaction_at,money,status,transaction_way,bank_log from transaction_log where id=#{id}")
    TransactionLog getTransLogById(long id);

    //新增交易流水
    @Insert("insert into transaction_log (create_at,create_by,user_id,product_name,transaction_at,transaction_way,money,status,bank_log) values (#{createAt},#{createBy},#{userId},#{productName},#{transactionAt},#{transactionWay},#{money},#{status},#{bankLog})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int addTransactionLog(TransactionLog transactionLog);

    //后台按条件查找指定用户
    //需手动转化style和status为StyleStatus,12种情况
    @SelectProvider(type = TransactionLogProvider.class,method = "getTransLogListByRpo")
    List<TransactionLog> getTransLogListByRpo(TransactionLogRPO rpo);

    class TransactionLogProvider{
        public String getTransLogListByRpo(TransactionLogRPO rpo){
            return new SQL(){{
                SELECT("id,product_name,transaction_at,money,status,transaction_way,bank_log");
                FROM("transaction_log");
                if (rpo.getId()!=null)
                    WHERE("user_id=#{id}");
                if (rpo.getProductName()!=null)
                    WHERE("product_name=#{productName}");
                if (rpo.getStatus()!=null)
                    WHERE("status=#{status}");
                if (rpo.getTransactionAtMin()!=null)
                    WHERE("transaction_at>=#{transactionAtMin}");
                if (rpo.getTransactionAtMax()!=null)
                    WHERE("transaction_at<##{transactionAtMax}");
                ORDER_BY("create_at desc");
            }}.toString();

        }

    }
}
