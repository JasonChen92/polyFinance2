package com.jnshu.dao2;

import com.jnshu.Domain2.DomainContent;
import com.jnshu.dto2.ContentListRPO;
import com.jnshu.entity.Content;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "contentMappper")
public interface ContentMapper {

    //新增--内容
    @Insert("insert into content (create_at, create_by,update_at,update_by,title,type,status,details,banner_cover) values (#{createAt},#{createBy},#{updateAt},#{updateBy},#{title},#{type},#{status},#{details},#{bannerCover})")
    @Options(useGeneratedKeys = true)
    Long saveContent(Content content) throws Exception;

    //删除
    @Delete("delete from content where id=#{id}")
    Boolean deleteContentById(Long id) throws Exception;

    //更新--内容
    @Update("update content set update_at=#{updateAt},update_by=#{updateBy},title=#{title},type=#{type},status=#{status},details=#{details},banner_cover=#{bannerCover} where id=#{id}")
    Boolean updateContentById(Content content) throws Exception;

    //更新-状态-上下线
    @Update("update content set update_at=#{updateAt}, update_by=#{updateBy}, status=#{status} where id=#{id} and status<>#{status}")
    Boolean updateContentStatusById(Content content) throws Exception;

    //查询--总数
    @Select("select count(*) from content")
    Integer getCount() throws Exception;
    //查找--通过id获得
    @Select("select id, title, type, status, details, banner_cover from content where id=#{id}")
    Content getContentById(Long id) throws Exception;

    //查找--通过title
    @Select("select id from content where title =#{title}")
    Long getContentIdByTitle(String title) throws Exception;

    @SelectProvider(type = ContentDaoProvider.class,method = "getContents")
    List<DomainContent> getContentList(ContentListRPO rpo) throws Exception;

    class ContentDaoProvider{
        public String getContents(ContentListRPO rpo){
            return new SQL(){{
                SELECT("a.id,a.title,a.type,a.status,b.login_name as update_by,a.update_at");
                FROM("content a");
                INNER_JOIN("user_back b on a.update_by=b.id");
                if (null != rpo.getTitle()){
                    WHERE("a.title like '%"+rpo.getTitle()+"%'");
                }
                if (null != rpo.getUpdateBy()){
                    WHERE("b.login_name = #{updateBy}");
                }
                if (null != rpo.getUpdateAt1() && null != rpo.getUpdateAt2()){
                    WHERE("a.update_at between #{updateAt1} and #{updateAt2}");
                }
                if (null != rpo.getStatus()){
                    WHERE("a.status =#{status}");
                }
                if (null != rpo.getType()){
                    WHERE("a.type = #{type}");
                }
            }}.toString();
        }

    }
}
