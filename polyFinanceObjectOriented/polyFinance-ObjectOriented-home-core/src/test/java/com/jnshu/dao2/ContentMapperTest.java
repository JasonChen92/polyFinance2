package com.jnshu.dao2;

import com.jnshu.Domain2.DomainContent;
import com.jnshu.Entry;
import com.jnshu.dto2.ContentListRPO;
import com.jnshu.entity.Content;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Entry.class)
public class ContentMapperTest {

    @Resource
    ContentMapper mapper;
    @Test
    public void saveContent() throws Exception {
        Long createTime=System.currentTimeMillis();
        Content n = new Content();
        n.setTitle("合同有效吗？");
        n.setType(1);
        n.setStatus(0);
        n.setDetails("有效。有效。");
        n.setCreateAt(createTime);
        n.setCreateBy(1);
        n.setUpdateAt(createTime);
        n.setUpdateBy(1);
        mapper.saveContent(n);
        System.out.println(n.getId());
    }

    @Test
    public void deleteContentById() {
    }

    @Test
    public void updateContentById() throws Exception {
        Long createTime=System.currentTimeMillis();
        Content n = mapper.getContentById(3L);
        n.setUpdateBy(2);
        n.setUpdateAt(System.currentTimeMillis());
        n.setCreateBy(3);
        n.setCreateAt(System.currentTimeMillis());
        n.setBannerCover("123");
        System.out.println(mapper.updateContentById(n));

    }

    @Test
    public void updateContentStatusById() throws Exception {
//        Content n = mapper.getContentById(3L);
//        n.setStatus(1);
//        System.out.println(mapper.updateContentStatusById(n));
        System.out.println(mapper.getCount());
    }

    @Test
    public void selectContentList() throws Exception {
        ContentListRPO rpo = new ContentListRPO();
        DomainContent content = new DomainContent();
//        rpo.setStatus(1);
        rpo.setTitle("合同");
//        rpo.setType(1);
//        rpo.setUpdateAt1(1532878620146L);
//        rpo.setUpdateAt2(1532878722570L);
//        rpo.setUpdateBy(1L);

        System.out.println(mapper.getContentList(rpo));
    }
}