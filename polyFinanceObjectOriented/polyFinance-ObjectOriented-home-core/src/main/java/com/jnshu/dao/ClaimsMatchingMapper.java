package com.jnshu.dao;

import com.jnshu.entity.ClaimsMatching;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * ClaimsMatching相关SQL
 * @author wangqichao
 */
@Mapper
@Component(value = "claimsMatchingMapper")
public interface ClaimsMatchingMapper {
    //获得最新的债权协议
    @Select("select claims_protocol_code from claims_matching order by create_at desc limit 0,1")
    String getNewestClaimsProtocolCode();

//   //插入债权匹配数据
    @Insert("insert into claims_matching (create_at,create_by,claims_id,contract_code,claims_protocol_code) values (#{createAt},#{createBy},#{claimsId},#{contractCode},#{claimsProtocolCode})")
    @Options(useGeneratedKeys=true,keyProperty="id")
    int addClaimsMatching(ClaimsMatching claimsMatching);


}
