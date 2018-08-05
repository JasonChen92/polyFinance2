package com.jnshu.dao2;

import com.jnshu.Domain2.DomainUserFront;
import com.jnshu.Domain2.DomainUserFrontDetail;
import com.jnshu.Domain2.UserBankCard;
import com.jnshu.dto2.UserFrontListRPO;
import com.jnshu.entity.User;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userFrontMapper")
public interface UserFrontMapper {

    //用户列表--冻结/解冻
    @Update("update user set status=#{status}, update_at=#{updateAt}, update_by=#{updateBy} where id=#{id} and not(status = #{status})")
    Boolean updateUserStatus(User user) throws Exception;

    //用户列表查询--多条件
    @SelectProvider(type = UserFrontDaoProvider.class, method = "getUserFronts")
    List<DomainUserFront> getUserFrontList(UserFrontListRPO rpo) throws Exception;

    class UserFrontDaoProvider {
        public String getUserFronts(UserFrontListRPO rpo) {
            return new SQL() {{
                SELECT("id, user_number, create_at, phone_number, referrer_id, real_name, property, cumulative_income, status");
                FROM("user");
//                ORDER_BY("create_at desc");
                if (rpo.getPhoneNumber() != null) {
                    WHERE("phone_number like '%" + rpo.getPhoneNumber() + "%'");
                }
                if (rpo.getRealName() != null) {
                    WHERE("real_name like '%" + rpo.getRealName() + "%'");
                }
                if (rpo.getCreateAt1() != null && rpo.getCreateAt2() != null) {
                    System.out.println("fuck");
                    WHERE("create_at between #{createAt1} and #{createAt2}");
                }
                if (rpo.getReferrerId() != null) {
                    WHERE("referrer_id like '%" + rpo.getReferrerId() + "%'");
                }
                if (rpo.getStatus() != null) {
                    WHERE("status = #{status}");
                }
            }}.toString();
        }
    }

    //用户列表--用户总数
    @Select("select count(*) from user")
    Integer getTotal() throws Exception;

    //用户列表--通过id查询
    @Select("select a.id, a.user_number, a.real_name, a.id_card, a.phone_number, a.create_at, a.email, a.address, a.property, a.cumulative_income, a.referrer_id, b.front_card, b.reverse_card, b.application_status, a.default_card from user a inner join real_name_application b on b.user_id=a.id where a.id=#{id}")
//    @Select("select a.id, a.user_number, a.real_name, a.id_card, a.phone_number, a.create_at, a.email, a.address, a.property, a.cumulative_income, a.referrer_id, (select front_card, reverse_card, application_status from real_name_application where real_name_application.user_id=a.id),(select bank_id, bank_card, (select bank_name from bank where bank.id=bank_card.bank_id) from bank_card where bank_card.user_id=a.id) from user a where a.id=#{id}")
    DomainUserFrontDetail getUserFrontDetailById(Long id) throws Exception;

    //用户详情--获取银行卡
    @Select("select a.user_id, a.id as card_id, a.bank_card, b.bank_name from bank_card a inner join bank b on a.bank_id=b.id where a.user_id=#{id}")
    List<UserBankCard> getUserFrontBankCardsById(Long id) throws Exception;

    //用户详情--修改手机号
    @Update("update user set phone_number=#{phoneNumber}, update_at=#{updateAt}, update_by=#{updateBy} where id=#{id} and not(phone_number=#{phoneNumber})")
    Boolean updateUserFrontPhone(User user) throws Exception;

    //用户详情--更换理财经理
    @Update("update user set referrer_id=#{referrerId}, update_at=#{updateAt}, update_by=#{updateBy} where id=#{id} and not(referrer_id=#{referrerId}")
    Boolean updateUserFrontReferrerId(User user) throws Exception;

    //用户详情--取消实名
    @Update("update user set real_name=null, id_card=null ,real_status=0, default_card =null, update_at=#{updateAt}, update_by=#{updateBy} where id=#{id} and real_status=1")
    Boolean updateUserFrontRealStatus(User user) throws Exception;

    //用户详情--删除银行卡
    @Delete("delete from bank_card where user_id=#{id}")
    Integer deleteUserBankCard(Long id) throws Exception;

    //解绑银行卡。如果需要更新用户默认银行卡。
    @Delete("delete from bank_card where id=#{bankId}")
    Boolean untiedUserBankCard(@Param("id") Long id, @Param("bankId") Long bankId) throws Exception;

    @Update("update user set default_card=#{defaultCard},update_at=#{updateAt}, update_by=#{updateBy} where id=#{id}")
    Boolean updateUserDefaultBankCard(User user) throws Exception;
}