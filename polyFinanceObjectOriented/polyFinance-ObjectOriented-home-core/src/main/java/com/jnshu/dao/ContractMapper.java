package com.jnshu.dao;

import com.jnshu.entity.Contract;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 获得合同相关的SQL
 * @author wangqichao
 */
@Mapper
@Component(value = "contractMapper")
public interface ContractMapper {
   //查找最新合同编号
    @Select("select contract_code from contract order by create_at desc limit 0,1")
    String getNewestContractCode();

    //添加新合同
    @Insert("insert into contract (create_at,create_by,contract_code,is_pay,is_matching_claims,user_sign) values (#{createAt},#{createBy},#{contractCode},#{isPay},#{isMatchingClaims},#{userSign})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int addContractCode(Contract contract);

    //根据合同id查找合同编号
    @Select("select contract_code from contract where id=#{contractId}")
    String getContractCodeById(long contractId);

    //根据合同编号查找id
    @Select("select id from contract where contract_code=#{contractCode}")
    Long getContractIdByCode(String contractCode);

    //根据合同id查找已签署合同相关信息
    @Select("select contract_code,user_sign,current_claims_code,create_at from contract where id=#{id}")
    Contract getHaveSignContractById(long id);

    //根据合同code查找已签署合同相关信息
    @Select("select user_sign,current_claims_code,create_at from contract where contract_code=#{code}")
    Contract getHaveSignContractByCode(String code);

    //根据合同code查找已签署债权协议相关信息
    @Select("select user_sign,current_claims_code,update_at from contract where contract_code=#{code}")
    Contract getClaimsCodeByCode(String code);

    //筛选出未匹配债权的合同编号
    @Select("select contract_code from contract where is_pay=1 and is_matching_claims=0")
    List<String> getContractCodeNotMatching();

    @Update("update contract set is_matching_claims=#{isMatchingClaims},current_claims_code=#{currentClaimsCode},update_at=#{updateAt},update_by=#{updateBy} where contract_code=#{contractCode}")
    int updateClaimsInfo(Contract contract);

    @Select("select current_claims_code from contract where contract_code=#{contractCode}")
    String getClaimsCodeByContractCode(String contractCOde);



}
