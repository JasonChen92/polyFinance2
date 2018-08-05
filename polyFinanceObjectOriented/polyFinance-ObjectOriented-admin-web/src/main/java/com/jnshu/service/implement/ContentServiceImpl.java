package com.jnshu.service.implement;

import com.github.pagehelper.PageHelper;
import com.jnshu.Domain2.DomainContent;
import com.jnshu.dao2.ContentMapper;
import com.jnshu.dto2.ContentListRPO;
import com.jnshu.entity.Content;
import com.jnshu.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Component
public class ContentServiceImpl implements ContentService{

    @Autowired
    ContentMapper contentMapper;
    //内容列表--多条件查询。
    @Override
    public List<DomainContent> getContentList(Integer pageNum, Integer pageSize,ContentListRPO rpo) throws Exception {
        PageHelper.startPage(pageNum, pageSize);
        return contentMapper.getContentList(rpo);
    }

    //查询内容记录总数。
    @Override
    public Integer getCount() throws Exception {
        return contentMapper.getCount();
    }

    //通过id获取内容详情。
    @Override
    public Content getContentById(Long id) throws Exception {
        return contentMapper.getContentById(id);
    }

    //更新内容。
    @Override
    public Boolean updateContentById(Content content) throws Exception {
        return contentMapper.updateContentById(content);
    }

    //新增内容。
    @Override
    public Long saveContent(Content content) throws Exception {
        return contentMapper.saveContent(content);
    }

    //新增时用来查重。
    @Override
    public Long getContentIdByTitle(String title) throws Exception {
        return contentMapper.getContentIdByTitle(title);
    }

    //上下线操作。
    @Override
    public Boolean updateContentStatusById(Content content) throws Exception {
        return contentMapper.updateContentStatusById(content);
    }

    //删除内容。
    @Override
    public Boolean deleteContentById(Long id) throws Exception {
        return contentMapper.deleteContentById(id);
    }
}
