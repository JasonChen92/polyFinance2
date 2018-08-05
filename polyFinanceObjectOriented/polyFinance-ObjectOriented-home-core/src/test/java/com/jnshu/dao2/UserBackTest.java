package com.jnshu.dao2;

import com.jnshu.Domain2.DomainUserBack;
import com.jnshu.Entry;
import com.jnshu.dto2.UserBackListRPO;
import com.jnshu.entity.UserBack;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class UserBackTest {
    @Resource
    UserBackMapper userBackMapper;

    @Test
    public void insertTest() throws Exception{
        UserBack userBack = new UserBack();
        userBack.setCreateAt(System.currentTimeMillis());
        userBack.setLoginName("admin");
        userBackMapper.saveUserBack(userBack);
        System.out.println(userBack.getId());
    }

    @Test
    public void deleteTest() throws Exception{
        System.out.println(userBackMapper.deleteById(6L));
    }

    @Test
    public void updateUserBack() throws Exception{
        UserBack userBack = new UserBack();
        userBack.setId(2);
        userBack.setLoginName("豆豆");
        userBack.setHashKey("2343");
        System.out.println(userBackMapper.updateUserBack(userBack));
    }

    @Test
    public void getUserBacksByNameAndRoleTest() throws Exception{
        UserBackListRPO userBackListRPO = new UserBackListRPO();
//        userBackListRPO.setLoginName("admin");
//        userBackListRPO.setRole("超级管理员");
        List<DomainUserBack> userBacks = new ArrayList<>();
                userBacks=userBackMapper.getUserBacksByNameAndRole(userBackListRPO);
        System.out.println("----------------------------------------");
        System.out.println(userBacks);

        System.out.println(userBacks);
        for (int i=0;i<userBacks.size();i++)
            System.out.println(userBacks.get(i));
    }
}
