package com.jnshu.dao2;

import com.jnshu.Entry;
import com.jnshu.dto2.FeedbackRPO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class FeedbackMapperTest {

    @Resource
    FeedbackMapper mapper;

    @Test
    public void deleteFeedback() throws Exception {
        System.out.println(mapper.deleteFeedback(3L));
    }

    @Test
    public void getFeedbackDetail() throws Exception {
        System.out.println(mapper.getFeedbackDetail(4L));
    }

    @Test
    public void getFeedbackList() throws Exception {
        FeedbackRPO rpo = new FeedbackRPO();
        rpo.setCreateAt1(1532886789406L);
        rpo.setCreateAt2(1532886799406L);
        rpo.setRealName("王大锤");
//        rpo.setPhoneNumber("131");
//        rpo.setEmail("qq");

        System.out.println(mapper.getFeedbackList(rpo));

    }
}