package com.jnshu.dao2;

import com.jnshu.Entry;
import com.jnshu.entity.RoleBack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class RoleBackMapperTest {

    @Resource
    RoleBackMapper roleBackMapper;
    @Test
    public void saveRoleBack() throws Exception {
        RoleBack n = new RoleBack();
        n.setCreateAt(System.currentTimeMillis());
        n.setCreateBy(1L);
        n.setRole("管理员");
        System.out.println(roleBackMapper.saveRoleBack(n));
        n.setRole("运营");
        roleBackMapper.saveRoleBack(n);
        System.out.println(n.getId());
    }

    @Test
    public void deleteRoleBack() throws Exception {
        System.out.println(roleBackMapper.deleteRoleBack(3L));
    }

    @Test
    public void getRoleNameById() throws Exception {
        System.out.println(roleBackMapper.getRoleNameById(4L));
    }

    @Test
    public void getRoleBacks() throws Exception {
        System.out.println(roleBackMapper.getRoleBacks());
        System.out.println(roleBackMapper.getTotal());
    }

    @Test
    public void getTotal() throws Exception {
        System.out.println(roleBackMapper.getRoleIdByRole("超级管理员"));
    }

}