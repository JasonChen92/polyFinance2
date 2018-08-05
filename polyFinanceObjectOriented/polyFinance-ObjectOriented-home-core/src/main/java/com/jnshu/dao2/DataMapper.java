package com.jnshu.dao2;

import com.jnshu.entity.SystemData;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DataMapper {

    //参数设置--更新
    @Update("update system_data set data_value=#{dataValue} where data_name=#{dataName}")
    Boolean updateSystemData(SystemData systemData) throws Exception;

    //参数设置--获取
    @Select("select data_value from system_data where data_name=#{dataName}")
    String getSystemData(SystemData systemData) throws Exception;

    //参数设置--更新时，备份.
    @Update("update system_data set data_value=#{dataValue} where data_name=#{dataName}")
    Boolean updateSystemData2(SystemData systemData2) throws Exception;

    //参数设置--还原。
    @Select("select data_value from system_data where data_name=#{dataName}")
    String getSystemData2(SystemData systemData2) throws Exception;

}
