package com.jnshu.dao2;

import com.jnshu.Entry;
import com.jnshu.entity.RoleModuleBack;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class RoleModuleBackMapperTest {

    @Resource
    RoleModuleBackMapper roleModuleBackMapper;

    @Test
    public void savaRoleModule() throws Exception {
        RoleModuleBack n = new RoleModuleBack();
        n.setCreateAt(System.currentTimeMillis());
        n.setCreateBy(3L);
        n.setModuleId(9L);
        System.out.println(roleModuleBackMapper.savERoleModule(n));
        System.out.println(n.getId());
    }

    @Test
    public void delete() throws Exception {
        System.out.println(roleModuleBackMapper.delete(1L));
    }

    @Test
    public void getTotal() throws Exception {
        System.out.println(roleModuleBackMapper.getTotal( ));
    }

    @Test
    public void getModuleIds() throws Exception {
        System.out.println(roleModuleBackMapper.getModuleOfRole(1L));
    }
}