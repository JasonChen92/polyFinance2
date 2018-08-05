package com.jnshu.dao2;

import com.jnshu.Domain2.DomainApplication;
import com.jnshu.dto2.ApplicationListRPO;
import com.jnshu.entity.RealNameApplication;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "applicationMapper")
public interface ApplicationMapper {

    //实名列表--取消实名状态。同时需调用用户列表里的取消实名操作。
    @Update("update real_name_application set application_status=3 where id=#{id} and application_status=1")
    Boolean cancelApplicationStatus(RealNameApplication realNameApplication) throws Exception;

    //实名列表--审核
//    @Update("update real_name_application set application_status=#{applicationStatus}, refuse_reason=#{refuseReason}  where id=#{id}")
    @UpdateProvider(type =ReviewApplication.class ,method ="updateSQL" )
    Boolean reviewApplication(RealNameApplication realNameApplication) throws Exception;
    class ReviewApplication{
        public String updateSQL(RealNameApplication realNameApplication){
            return new SQL(){{
                UPDATE("real_name_application");
                SET("application_status=#{applicationStatus}, refuse_reason=#{refuseReason}");
                if (2 == realNameApplication.getApplicationStatus() && null != realNameApplication.getRefuseReason() ){
                    WHERE("application_status =1 and id=#{id}");
                }
                if (1 == realNameApplication.getApplicationStatus() ){
                    WHERE("id=#{id} and application_status=0");
                }
//                if (2 == realNameApplication.getApplicationStatus() && null != realNameApplication.getRealName() ){
//                    SET("application_status=#{applicationStatus}, refuse_reason=#{refuseReason}");
//                    WHERE("id=#{id} and application_status=1");
//                }
//                if (1 == realNameApplication.getApplicationStatus() ){
//                    SET("application_status=#{applicationStatus}");
//                    WHERE("id=#{id} and application_status=0");
//                }
            }}.toString();
        }
    }
    //实名申请通过后，更新user表。
    @Update("update user a , real_name_application b set a.real_name=b.real_name, a.id_card=b.id_card,a.real_status=1, a.update_at=b.update_at, a.update_by=b.update_by where a.id=b.user_id and b.id = #{id} and a.real_status=0")
    Boolean updateUserFrontAfterApplication(Long id) throws Exception;

    //总数
    @Select("select count(*) from real_name_application")
    Integer getTotal() throws Exception;
    //实名详情--id
    @Select("select a.id, a.user_id, b.user_number, a.real_name, a.id_card, b.phone_number, b.create_at, b.email, b.address, a.front_card, a.reverse_card,a.application_status, a.refuse_reason, a.is_first  from real_name_application a inner join user b on a.user_id=b.id where a.id=#{id}")
    DomainApplication getApplicationById(Long id) throws Exception;


    //实名认证列表--多条件
    @SelectProvider(type = ApplicationDaoProvider.class,method = "getApplicationList")
    List<DomainApplication> getApplicationList(ApplicationListRPO rpo) throws Exception;
    class ApplicationDaoProvider{
        public String getApplicationList(ApplicationListRPO rpo){
            return new SQL() {{
                SELECT("a.id, b.user_number, a.create_at, b.phone_number, a.real_name, a.id_card, a.application_status, a.is_first, a.refuse_reason from real_name_application a ");
                INNER_JOIN("user b on a.user_id=b.id");
                ORDER_BY("a.create_at desc");
                if (null != rpo.getUserNumber()){
                    WHERE("b.user_number like'%"+rpo.getUserNumber()+"%'");
                }
                if (null != rpo.getRealName()){
                    WHERE("a.real_name like'%"+rpo.getRealName()+"%'");
                }
                if (null != rpo.getCreateAt1() && null != rpo.getCreateAt2()){
                    System.out.println("FUCK");
                    WHERE("a.create_at between #{createAt1} and #{createAt2}");
                }
                if (null != rpo.getPhoneNumber()){
                    WHERE("b.phone_number like '%"+rpo.getPhoneNumber()+"%'");
                }
                if (null != rpo.getApplicationStatus()){
                    WHERE("a.application_status = #{applicationStatus}");
                }
            }}.toString();
        }
    }
}
