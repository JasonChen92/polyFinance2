package com.jnshu.service.implement;

import com.github.pagehelper.PageHelper;
import com.jnshu.Domain2.DomainApplication;
import com.jnshu.dao2.ApplicationMapper;
import com.jnshu.dto2.ApplicationListRPO;
import com.jnshu.entity.RealNameApplication;
import com.jnshu.service.UserApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Component
public class UserApplicationServiceImpl implements UserApplicationService{

    @Autowired
    ApplicationMapper applicationMapper;

    @Override
    public List<DomainApplication> getAllUser(Integer pageNum, Integer pageSize, ApplicationListRPO rpo) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return applicationMapper.getApplicationList(rpo);
    }

    //获得总数。
    @Override
    public Integer getCount() throws Exception {
        return applicationMapper.getTotal();
    }

    //获得实名详情
    @Override
    public DomainApplication getApplicationById(Long id) throws Exception {
        return applicationMapper.getApplicationById(id);
    }

    //取消实名
    @Override
    public Boolean cancelApplicationStatus(RealNameApplication realNameApplication) throws Exception {
        return applicationMapper.cancelApplicationStatus(realNameApplication);
    }

    //审核实名申请。
    @Override
    public Boolean reviewApplication(RealNameApplication realNameApplication) throws Exception {
        return applicationMapper.reviewApplication(realNameApplication);
    }

    //更新user表
    @Override
    public Boolean updateUserFrontAfterApplication(Long id) throws Exception {
        return applicationMapper.updateUserFrontAfterApplication(id);
    }
}
