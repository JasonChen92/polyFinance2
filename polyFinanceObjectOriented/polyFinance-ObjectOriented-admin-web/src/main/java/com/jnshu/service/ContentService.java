package com.jnshu.service;

import com.jnshu.Domain2.DomainContent;
import com.jnshu.dto2.ContentListRPO;
import com.jnshu.model.content.Content;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public interface ContentService {

    //内容列表--多条件查询
    List<DomainContent> getContentList(Integer pageNum, Integer pageSize,ContentListRPO rpo) throws Exception;

    //查询内容记录总数。
    Integer getCount() throws Exception;

    //查询内容详情。
    com.jnshu.entity.Content getContentById(Long id) throws Exception;

    //更新内容
    Boolean updateContentById(com.jnshu.entity.Content content) throws Exception;

    //新增内容。
    Long saveContent(com.jnshu.entity.Content content) throws Exception;

    //新增时使用。
    Long getContentIdByTitle(String title) throws Exception;

    //上下线操作
    Boolean updateContentStatusById(com.jnshu.entity.Content content) throws Exception;

    //删除内容
    Boolean deleteContentById(Long id) throws Exception;
}
