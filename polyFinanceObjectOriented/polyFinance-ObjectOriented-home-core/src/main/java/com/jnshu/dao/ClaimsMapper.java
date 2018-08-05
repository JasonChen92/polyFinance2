package com.jnshu.dao;

import com.jnshu.dto1.ClaimsListRPO;
import com.jnshu.entity.Claims;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * claims相关SQL
 * @author wangqichao
 */
@Mapper
@Component(value ="claimsMapper")
public interface ClaimsMapper {
    //按条件查找债权列表
    @SelectProvider(type = ClaimsProvider.class,method = "getClaimsListByRpo")
    List<Claims> getClaimsListByRpo(ClaimsListRPO rpo);

    //按id查找指定债权详情
    @Select("select id,claims_code,creditor,creditor_phone_number,creditor_id_card,lend_deadline,lend_start_at,lend_money,claims_nature,claims_interest_rate,remark from claims where id=#{id}")
    Claims getClaimsById(long id);

    //按id查询债权出借结束时间
    @Select("select lend_end_at from claims where id=#{id}")
    Long getLendEndById(long id);

    //按id查询指定债权匹配相关信息
    // 暂时有问题
    @Select("select claims_code,lend_start_at,lend_end_at,lend_money,remanent_money from claims where id=#{id}")
    Claims getClaimsMatchingById(long id);

//    //按id查询指定债权匹配金额
//    @Select("select remanent_money,lend_money from claims where id=#{id}")
//    Claims getClaimsMoneyById(long id);

    //修改债权信息，需要先计算时间和待匹配金额
    @Update("update claims set update_at=#{updateAt},update_by=#{updateBy},claims_code=#{claimsCode},creditor=#{creditor},creditor_phone_number=#{creditorPhoneNumber},creditor_id_card=#{creditorIdCard},lend_deadline=#{lendDeadline},lend_start_at=#{lendStartAt},lend_end_at=#{lendEndAt},lend_money=#{lendMoney},claims_nature=#{claimsNature},claims_interest_rate=#{claimsInterestRate},remark=#{remark},remanent_money=#{remanentMoney} where id=#{id}")
    int updateClaims(Claims claims);

    //修改债权待匹配金额
    @Update("update claims set remanent_money=#{remanentMoney},status=#{status} where id=#{id}")
    int updateClaimsMoney(Claims claims);

    //新增债权信息,其中lendEndAt需要手动计算后填入
    @Insert("insert into claims (create_at,create_by,claims_code,creditor,creditor_phone_number,creditor_id_card,lend_deadline,lend_start_at,lend_money,claims_nature,claims_interest_rate,remark,lend_end_at,remanent_money) values (#{createAt},#{createBy},#{claimsCode},#{creditor},#{creditorPhoneNumber},#{creditorIdCard},#{lendDeadline},#{lendStartAt},#{lendMoney},#{claimsNature},#{claimsInterestRate},#{remark},#{lendEndAt},#{lendMoney})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int addClaims(Claims claims);

    //获得债权人信息
    @Select("select claims.creditor,claims.creditor_id_card from claims inner join claims_matching on claims.id=claims_matching.claims_id where claims_matching.claims_protocol_code=#{currentClaimsCode}")
    Claims getCreditorInfoByClaimsCode(String currentClaimsCode);

    class ClaimsProvider{
        public String getClaimsListByRpo(ClaimsListRPO rpo){
            return new SQL(){{
                SELECT("id,claims_code,creditor,creditor_phone_number,creditor_id_card,lend_deadline,lend_start_at,lend_end_at,lend_money,status,remanent_money");
                FROM("claims");
                if(rpo.getCreditor()!=null)
                    WHERE("creditor=#{creditor}");
                if(rpo.getCreditorIdCard()!=null)
                    WHERE("creditor_id_card=#{creditorIdCard}");
                if(rpo.getLendStartMin()!=null)
                    WHERE("lend_start_at>=#{lendStartMin}");
                if(rpo.getLendStartMax()!=null)
                    WHERE("lend_start_at<#{lendStartMax}");
                if (rpo.getClaimsCode()!=null)
                    WHERE("claims_code=#{claimsCode}");
                if(rpo.getStatus()!=null)
                    WHERE("status=#{status}");
                if(rpo.getLendEndMin()!=null)
                    WHERE("lend_end_at>=#{lendEndMin}");
                if(rpo.getLendEndMax()!=null)
                    WHERE("lend_end_at<#{lendEndMax}");
                if(rpo.getCreditorPhoneNumber()!=null)
                    WHERE("creditor_phone_number=#{creditorPhoneNumber}");
                if(rpo.getLendMoneyMin()!=null)
                    WHERE("lend_money>=#{lendMoneyMin}");
                if(rpo.getLendMoneyMax()!=null)
                    WHERE("lend_money<#{lendMoneyMax}");
                if(rpo.getLendDeadlineMin()!=null)
                    WHERE("lend_deadline>=#{lendDeadlineMin}");
                if(rpo.getLendDeadlineMax()!=null)
                    WHERE("lend_deadline<#{lendDeadlineMax}");
            }}.toString();
        }
    }

}
