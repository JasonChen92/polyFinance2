package com.jnshu.service.implement;

import com.github.pagehelper.PageHelper;
import com.jnshu.Domain2.DomainUserFront;
import com.jnshu.Domain2.DomainUserFrontDetail;
import com.jnshu.Domain2.UserBankCard;
import com.jnshu.dao2.UserFrontMapper;
import com.jnshu.dto2.UserFrontListRPO;

import com.jnshu.entity.User;
import com.jnshu.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Component
public class UserFrontServiceImpl implements UserService {

    @Autowired
    UserFrontMapper userFrontMapper;
    //用户列表
    @Override
    public List<DomainUserFront> getAllUser(int pageNum, int pageSize,UserFrontListRPO userFrontListRPO) throws Exception {
        List<DomainUserFront> users = new ArrayList<>();
        PageHelper.startPage(pageNum, pageSize);
        users=userFrontMapper.getUserFrontList(userFrontListRPO);
        return users;
    }

    //用户列表--总数
    @Override
    public Integer getCount() throws Exception {
        return userFrontMapper.getTotal();
    }

    //用户详情--id
    @Override
    public DomainUserFrontDetail getUserFrontById(Long id) throws Exception{
        return userFrontMapper.getUserFrontDetailById(id);
    }

    //获取用户详情时同时获取银行卡
    @Override
    public List<UserBankCard> getUserFrontBankCardsById(Long id) throws Exception {
        return userFrontMapper.getUserFrontBankCardsById(id);
    }

    //用户冻结-解冻
    @Override
    public Boolean updateUserStatus(User user) throws Exception {
        return userFrontMapper.updateUserStatus(user);
    }

    //更新用户手机号
    @Override
    public Boolean updateUserPhone(User user) throws Exception {
        return userFrontMapper.updateUserFrontPhone(user);
    }

    //更换用户产品经理。
    @Override
    public Boolean updateUserFrontReferrerId(User user) throws Exception {
        return userFrontMapper.updateUserFrontReferrerId(user);
    }

    //取消用户实名，同时删除银行卡
    @Override
    public Boolean updateUserFrontRealStatus(User user) throws Exception {
        return userFrontMapper.updateUserFrontRealStatus(user);
    }

    @Override
    public Integer deleteUserBankCard(Long id) throws Exception{
        return userFrontMapper.deleteUserBankCard(id);
    }

    //用户详情--解绑银行卡
    @Override
    public Boolean untiedUserBankCard(Long id, Long bankId) throws Exception {
        return userFrontMapper.untiedUserBankCard(id, bankId);
    }

    @Override
    public Boolean updateUserDefaultBankCard(User user) throws Exception{
        return userFrontMapper.updateUserDefaultBankCard(user);
    }
}
