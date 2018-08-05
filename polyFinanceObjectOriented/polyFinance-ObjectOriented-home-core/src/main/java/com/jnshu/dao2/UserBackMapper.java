package com.jnshu.dao2;

import com.jnshu.Domain2.DomainUserBack;
import com.jnshu.dto2.UserBackListRPO;
import com.jnshu.entity.UserBack;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.jdbc.SQL;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "userBackMapper")
public interface UserBackMapper {

    @Insert("insert into user_back(create_at, update_at,create_by, update_by,login_name, salt,hash_key,phone_number) values (#{createAt},#{updateAt},#{createAt},#{updateAt},#{loginName},#{salt},#{hashKey},#{phoneNumber})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    long saveUserBack(UserBack userBack) throws Exception;

    //删除
    @Delete("delete from user_back where id=#{id}")
    boolean deleteById(Long id) throws Exception;

    //更新
    @Update("update user_back set update_at=#{updateAt}, update_by=#{updateBy},login_name=#{loginName},hash_key=#{hashKey},phone_number=#{phoneNumber} where id=#{id}")
    public boolean updateUserBack(UserBack userBack) throws Exception;

    //查询总数
    @Select("select count(*) from user_back")
    public Integer getTotal() throws Exception;
    //查找by id
    @Select("select id,login_name,hash_key,phone_number from user_back where id=#{id}")
    List<UserBack> getUserBackById(Long id) throws Exception;
    @Select("select id,login_name,hash_key,salt from user_back where login_name=#{loginName}")
    UserBack getUserBackByLoginName(String loginName) throws Exception;
    //查找后台用户列表--查询条件登录名或角色，没有排序。
    @SelectProvider(type = UserBackDaoProvider.class,method = "getUserBacks")
    List<DomainUserBack> getUserBacksByNameAndRole(UserBackListRPO rpo);

    class UserBackDaoProvider{
        public String getUserBacks(UserBackListRPO rpo){
            return new SQL(){{
//                SELECT("*");
                SELECT("a.id,a.login_name,c.role,a.create_at,(select login_name from user_back where id=create_by) as createBy,a.update_at,(select login_name from user_back where id=update_by) as updateBy");
                FROM("user_back a,role_back c");
                WHERE("c.id=(select role_id from role_user_back where user_id=a.id)");
                if (null != rpo.getLoginName()){
                    WHERE("a.login_name = #{loginName}");
                }
                if (null != rpo.getRole()){
                    WHERE(" a.id in (select user_id from role_user_back where role_id=(select id from role_back where role=#{role}))");
                }
            }}.toString();


//            String sql = "select * from user_back ";
////            if (null != loginName)
////                sql += "where login_name like #{loginName} ";
//            if (null != rpo.getLoginName()){
//                sql += "where login_name like #{loginName} ";
//            }
//            if (null != rpo.getRole()){
//                sql += "and id in (" +
//                        "select user_id from role_user_back " +
//                        "where role_id=(select id from role_back where role=#{role}))";
//            }
//            System.out.println(sql);
//            return sql;
        }
    }
}
