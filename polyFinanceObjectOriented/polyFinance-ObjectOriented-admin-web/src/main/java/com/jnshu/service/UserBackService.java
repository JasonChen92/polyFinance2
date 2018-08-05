package com.jnshu.service;



import com.jnshu.Domain2.DomainUserBack;
import com.jnshu.dto2.UserBackListRPO;
import com.jnshu.entity.UserBack;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

public interface UserBackService {

    //后台账户验证。
    List<Object> verifyUserBack(UserBack userBack, HttpServletRequest request, HttpServletResponse response) throws Exception;
    //账户列表
    List<DomainUserBack> getUserBackList(UserBackListRPO rpo) throws Exception;

    //新增账户
    Long saveUserBack(UserBack userBack) throws Exception;

}