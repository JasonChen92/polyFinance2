package com.jnshu.dao2;

import com.jnshu.Domain2.DomainFeedBackDetail;
import com.jnshu.dto2.FeedbackRPO;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.jdbc.SQL;

import java.util.List;

@Mapper
public interface FeedbackMapper {

    //删除
    @Delete("delete from feedback where id=#{id}")
    Boolean deleteFeedback(Long id) throws Exception;

    //查询--id
    @Select("select a.id,b.phone_number, b.real_name, b.email, a.content as feedback_content from feedback a inner join user b  on a.user_id=b.id where a.id=#{id}")
    DomainFeedBackDetail getFeedbackDetail(Long id) throws Exception;

    //查询--多条件
    @SelectProvider(type = FeedbackDaoProvider.class ,method = "getFeedbackList")
    List<DomainFeedBackDetail> getFeedbackList(FeedbackRPO rpo) throws Exception;

    class FeedbackDaoProvider{
        public String getFeedbackList(FeedbackRPO rpo) {
            return new SQL(){{
                SELECT("a.id, b.phone_number, b.real_name, b.email, a.create_at");
                FROM("feedback a");
                INNER_JOIN("user b on a.user_id=b.id");
                if (null != rpo.getPhoneNumber()){
                    WHERE("user_id = (select id from user where phone_number=#{phoneNumber})");
                }
                if (null != rpo.getRealName()){
                    WHERE("user_id = (select id from user where real_name=#{realName})");
                }
                if (null != rpo.getEmail()){
                    WHERE("user_id = (select id from user where email=#{email})");
                }
                if (null != rpo.getCreateAt1() && null != rpo.getCreateAt2()){
                    WHERE("a.create_at between #{createAt1} and #{createAt2}");
                }
            }}.toString();
        }
    }
}
