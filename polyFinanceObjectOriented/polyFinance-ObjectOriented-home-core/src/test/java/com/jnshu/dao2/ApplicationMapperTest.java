package com.jnshu.dao2;

import com.jnshu.Entry;
import com.jnshu.dto2.ApplicationListRPO;
import com.jnshu.entity.RealNameApplication;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class ApplicationMapperTest {

    @Resource
    ApplicationMapper mapper;
    @Test
    public void updateApplicationStatus() throws Exception {
        System.out.println(mapper.getTotal());
        System.out.println(mapper.getApplicationById(4L));

        RealNameApplication n= new RealNameApplication();
        n.setId(3);
        n.setApplicationStatus(3);
        System.out.println(mapper.cancelApplicationStatus(n));
    }

    @Test
    public void reviewApplication() throws Exception {
        RealNameApplication n= new RealNameApplication();
        n.setId(4);
        n.setApplicationStatus(3);
        n.setRefuseReason("图片违规");
        System.out.println(mapper.reviewApplication(n));
    }

    @Test
    public void getApplicationById() {

    }

    @Test
    public void getApplicationList() throws Exception {
        ApplicationListRPO n= new ApplicationListRPO();
//        n.setApplicationStatus(3);
//        n.setCreateAt1(1532884769406L);
//        n.setCreateAt2(1532886769406L);
//        n.setPhoneNumber("13101496674");
//        n.setRealName("卡卡");
        n.setUserNumber("05");
        System.out.println(mapper.getApplicationList(n));
    }
}