package com.jnshu.service;


import com.jnshu.Domain2.DomainUserFront;
import com.jnshu.Domain2.DomainUserFrontDetail;
import com.jnshu.Domain2.UserBankCard;
import com.jnshu.dto2.UserFrontListRPO;

import com.jnshu.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    List<DomainUserFront> getAllUser(int pageNum, int pageSize, UserFrontListRPO userFrontListRPO) throws Exception;
//        PageHelper.startPage(pageNum,pageSize);
//        System.out.println(pageNum+ "，" + pageSize);
//        List<User> userList = new ArrayList<>();
//        for (int i=1; i< pageSize;i++){
//            User user = new User(Long.valueOf(i),"UK1810"+000+String.valueOf(i),System.currentTimeMillis()+100000000L,"136989",String.valueOf(i),i%2,"张三","3453245234354"+i,String.valueOf(879079834),String.valueOf(4353453),i%2);
//            userList.add(user);
//        }
//        return userList;
    Integer getCount() throws Exception;

    //用户详情
    DomainUserFrontDetail getUserFrontById(Long id) throws Exception;

    List<UserBankCard> getUserFrontBankCardsById(Long id) throws Exception;

    //冻结-解冻用户
    Boolean updateUserStatus(User user) throws Exception;

    //修改手机号
    Boolean updateUserPhone(User user) throws Exception;

    //修改理财经理
    Boolean updateUserFrontReferrerId(User user) throws Exception;

    //取消用户实名，同时删除银行卡
    Boolean updateUserFrontRealStatus(User user) throws Exception;
    Integer deleteUserBankCard(Long id) throws Exception;

    //解绑银行卡
    Boolean untiedUserBankCard(Long id, Long bankId) throws Exception;
    Boolean updateUserDefaultBankCard(User user) throws Exception;
}
