package com.jnshu.service;

import com.jnshu.Domain2.DomainApplication;
import com.jnshu.dto2.ApplicationListRPO;
import com.jnshu.entity.RealNameApplication;
import org.springframework.stereotype.Service;

import java.util.List;


public interface UserApplicationService {

    //实名列表
    List<DomainApplication> getAllUser(Integer pageNum, Integer pageSize, ApplicationListRPO rpo) throws Exception;

    //列表总数
    Integer getCount() throws Exception;

    //实名详情
    DomainApplication getApplicationById(Long id) throws Exception;

    //取消实名
    Boolean cancelApplicationStatus(RealNameApplication realNameApplication) throws Exception;

    //审核实名申请。
    Boolean reviewApplication(RealNameApplication realNameApplication) throws Exception;

    //更新user表
    Boolean updateUserFrontAfterApplication(Long id) throws Exception;
}
