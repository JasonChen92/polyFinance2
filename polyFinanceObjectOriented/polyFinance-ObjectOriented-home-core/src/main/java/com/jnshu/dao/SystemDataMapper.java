package com.jnshu.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

/**
 * 获取系统参数相关sql
 * @author wangqichao
 */
@Mapper
@Component(value = "systemDataMapper")
public interface SystemDataMapper {
    //获得原合同url
    @Select("select data_value from system_data where data_name='contract '")
    String getContractUrl();

    //获得续投提醒天数
    @Select("select data_value from system_data where data_name='investment_day'")
    String getInvestmentDay();

   //获得公司公章
    @Select("select data_value from system_data where data_name='official_seal'")
    String getCompanyCachet();

    //获得总债权投满警戒线
    @Select("select data_value from system_data where data_name='creditor_line'")
    String getCreditorLine();

    //获得债权到期提前天数
    @Select("select data_value from system_data where data_name='creditor_day'")
    String getCreditorDay();


}
