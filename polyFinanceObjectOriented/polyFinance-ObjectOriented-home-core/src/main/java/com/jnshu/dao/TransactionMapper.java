package com.jnshu.dao;

import com.jnshu.dto1.*;
import com.jnshu.entity.Transaction;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 交易相关SQL
 * @author wangqichao
 */
@Mapper
@Component(value = "transactionMapper")
public interface TransactionMapper {
    //添加新交易订单
    @Insert("insert into transaction (create_at,create_by,user_id,start_at,end_at,renuwal_status,money,expect_earnings,returned,not_return,product_id,status,contract_code) values (#{createAt},#{createBy},#{userId},#{startAt},#{endAt},#{renuwalStatus},#{money},#{expectEarnings},#{returned},#{notReturn},#{productId},#{status},#{contractCode})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int addTransaction(Transaction transaction);
    //修改续投状态
    @Update("update transaction set renuwal_status=#{renuwalStatus},update_at=#{updateAt},update_by=#{updateBy} where id=#{id}")
    int updateRenuwalStatus(Transaction transaction);
//    //获得债权匹配相关信息
//    @Select("select user_id,product_id,start_at,end_at,money from transaction where claims_id=#{id}")
//    ClaimsMatchingRO getClaimsMatchingList(long id);

    //查找原交易信息
    @Select("select user_id,start_at,end_at,money,expect_earnings,product_id from transaction where id=#{id}")
    Transaction getOldTransactionById(long id);

    //查找已经匹配债权且交易正在执行中的用户id
    @Select("select distinct user_id from transaction where claims_id=#{id} and status=0")
    Long[] getUserIdByClaimsId(long id);

    //查询合同编号对应信息
    @Select("select user_id,product_id,end_at,money from transaction where contract_code=#{contractCode}")
    Transaction getContractInfoByContractCode(String contractCode);

    //修改交易表债权信息
    @Update("update transaction set claims_id=#{claimsId},update_at=#{updateAt},update_by=#{updateBy} where contract_code=#{contractCode}")
    int updateClaimsId(Transaction transaction);

    //查询购买人次
    @Select("select count(distinct user_id) from transaction where product_id=#{id}")
    Long getPeopleCountingByProductId(StatisticsSalesListRO ro);

    //查询购买次数
    @Select("select count(id) from transaction where product_id=#{id}")
    Long getNumberOfTimesByProductId(StatisticsSalesListRO ro);

    //查询购买总金额
    @Select("select sum(cast(money as decimal(18,2))) from transaction where product_id=#{id}")
    String getSumMoneyByProductId(StatisticsSalesListRO ro);

    //查询用户投资列表
    @Select("select transaction.id,product.product_name,product.interest_rate,transaction.money,product.mark,transaction.start_at,transaction.end_at,transaction.status from transaction inner join product on transaction.product_id=product.id where transaction.status=#{status} and transaction.user_id=#{userId}")
    List<TransactionListRO> getTransListByUserIdAndStatus(@Param(value = "status") int status,@Param(value = "userId") long userId);

    //查找债权匹配相应数据
    @SelectProvider(type = TransactionProvider.class,method = "getClaimsMatchingList")
    List<ClaimsMatchingRO> getClaimsMatchingList(ClaimsMatchingRPO rpo);

    //查询指定时间段内购买人数
    @SelectProvider(type = TransactionProvider.class,method = "getPeopleCountingByProductIdAndDate")
    Long getPeopleCountingByProductIdAndDate(StatisticsSalesRPO rpo);

    //查询指定时间段内购买次数
    @SelectProvider(type = TransactionProvider.class,method = "getNumberOfTimesByProductIdAndDate")
    Long getNumberOfTimesByProductIdAndDate(StatisticsSalesRPO rpo);

    //查询指定时间段内购买总金额
    @SelectProvider(type = TransactionProvider.class,method = "getSumMoneyByProductIdAndDate")
    String getSumMoneyByProductIdAndDate(StatisticsSalesRPO rpo);

    //获得可续投列表信息
    @Select("select transaction.id,product.product_name,product.interest_rate,transaction.money,product.mark,transaction.start_at,transaction.end_at from transaction inner join product on transaction.product_id=product.id where product.status=0 and transaction.user_id=#{userId}")
    List<TransactionListRO> getRenewalListByUserId(long userId);

    //获得投资详情
    @Select("select transaction.id,product.product_name,product.interest_rate,transaction.money,product.mark,transaction.start_at,transaction.end_at,transaction.status,transaction.expect_earnings,transaction.returned,transaction.not_return,product.investment_amount,product.refund_style,transaction.renuwal_status,product.status,transaction.user_id,transaction.contract_code from transaction inner join product on transaction.product_id=product.id where transaction.id=#{transactionId}")
    TransactionRO getTransInfoByTransId(long transactionId);

    //获得用户投资列表
    @SelectProvider(type = TransactionProvider.class,method = "getTransactionListByUserId")
     List<TransactionListBackRO> getTransactionListByUserId(TransactionListRPO rpo);

    class TransactionProvider{
        public String getClaimsMatchingList(ClaimsMatchingRPO rpo){
            return new SQL(){{
                SELECT("contract_code,start_at,end_at,money,product_id,user_id");
                FROM("transaction");
                if (rpo.getId()!=null)
                    WHERE("claims_id=#{id}");
                if (rpo.getProductId()!=null)
                    WHERE("product_id=#{productId}");
                if(rpo.getUserId()!=null) {
                    String userId="";
                    for(int i=0;i<rpo.getUserId().length;i++)
                    {
                        userId+=""+rpo.getUserId()[i]+"";
                        if(i<rpo.getUserId().length-1){
                            userId=userId+",";
                        }
                    }
                    String finalUserId = userId;
                    WHERE("user_id in (" + finalUserId + ")");
                }
                if(rpo.getStartAtMin()!=null)
                    WHERE("start_at>=#{startAtMin}");
                if(rpo.getStartAtMax()!=null)
                    WHERE("start_at<#{startAtMax}");
                if (rpo.getEndAtMin()!=null)
                    WHERE("end_at>=#{endAtMin}");
                if(rpo.getEndAtMax()!=null)
                    WHERE("end_at<#{endAtMax}");
            }}.toString();
        }

        public String getPeopleCountingByProductIdAndDate(StatisticsSalesRPO rpo){
            return new SQL(){{
                SELECT("count(distinct user_id)");
                FROM("transaction");
                WHERE("product_id=#{id}");
                if(rpo.getDateMin()!=null)
                    WHERE("create_at>=#{dateMin}");
                if (rpo.getDateMax()!=null)
                    WHERE("create_at<#{dateMax}");
            }}.toString();
        }

        public String getNumberOfTimesByProductIdAndDate(StatisticsSalesRPO rpo){
            return new SQL(){{
                SELECT("count(id)");
                FROM("transaction");
                WHERE("product_id=#{id}");
                if(rpo.getDateMin()!=null)
                    WHERE("create_at>=#{dateMin}");
                if (rpo.getDateMax()!=null)
                    WHERE("create_at<#{dateMax}");
            }}.toString();
        }

        public String getSumMoneyByProductIdAndDate(StatisticsSalesRPO rpo){
            return new SQL(){{
                SELECT("sum(cast(money as decimal(18,2)))");
                FROM("transaction");
                WHERE("product_id=#{id}");
                if(rpo.getDateMin()!=null)
                    WHERE("create_at>=#{dateMin}");
                if (rpo.getDateMax()!=null)
                    WHERE("create_at<#{dateMax}");
            }}.toString();
        }
//select product.product_name,transaction.money,transaction.status,transaction.returned,transaction.not_return, transaction.contract_code,contract.current_claims_code from transaction inner join product on transaction.product_id=product.id inner join contract on transaction.contract_code=contract.contract_code where transaction.user_id=#{userId}  and product.product_name=#{productName} and transaction.contract_code=#{contractCode} and transaction.start_at between #{startAtMin} and #{startAtMax} and contract.current_claims_code=#{claimsProtocolCode} and transaction.status=#{status} and transaction.end_at between #{endAtMin} and #{endAtMax} order by transaction.start_at desc
        public String getTransactionListByUserId(TransactionListRPO rpo){
            return new SQL(){{
              SELECT("product.product_name,transaction.money,transaction.start_at,transaction.end_at,transaction.status,transaction.returned,transaction.not_return,transaction.contract_code,contract.current_claims_code");
              FROM("transaction");
              INNER_JOIN("product on transaction.product_id=product.id");
              INNER_JOIN("contract on transaction.contract_code=contract.contract_code");
              WHERE("transaction.user_id=#{id}");
              if(rpo.getProductName()!=null)
                  WHERE("product.product_name=#{productName}");
              if(rpo.getContractCode()!=null)
                  WHERE("transaction.contract_code=#{contractCode}");
              if (rpo.getStartAtMin()!=null)
                  WHERE("transaction.start_at>=#{startAtMin}");
              if (rpo.getStartAtMax()!=null)
                  WHERE("transaction.start_at<#{startAtMax}");
              if(rpo.getClaimsProtocolCode()!=null)
                  WHERE("contract.current_claims_code=#{claimsProtocolCode}");
              if(rpo.getStatus()!=null)
                  WHERE("transaction.status=#{status}");
              if (rpo.getEndAtMin()!=null)
                  WHERE("transaction.end_at>=#{endAtMin}");
              if(rpo.getEndAtMax()!=null)
                  WHERE("transaction.end_at<#{endAtMax}");
              ORDER_BY("transaction.start_at desc");
            }}.toString();
        }
    }
}
