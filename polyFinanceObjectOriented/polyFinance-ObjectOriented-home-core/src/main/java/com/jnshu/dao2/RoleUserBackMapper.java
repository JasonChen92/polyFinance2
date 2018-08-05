package com.jnshu.dao2;

import com.jnshu.entity.RoleUserBack;
import org.apache.ibatis.annotations.*;

@Mapper
public interface RoleUserBackMapper {

    //新增
    @Insert("insert into role_user_back(create_at,create_by,update_at,update_by,user_id,role_id")
    @Options(useGeneratedKeys = true)
    Long saveRoleUserBack(RoleUserBack roleUserBack) throws Exception;

    //删除-一个后台用户只有一个角色。所以通过后台用户的id，删除。
    @Delete("delete from role_user_back where user_id={userId}")
    Boolean deleteRoleUserBackByUser(Long userId) throws Exception;

    //删除-一个后台用户只有一个角色。所以通过后台用户的id，删除。
    @Delete("delete from role_user_back where role_id={roleId}")
    Boolean deleteRoleUserBackByRole(Long roleId) throws Exception;

    //更新--也是通过后台用户id定位。
    @Update("update role_user_back set update_at=#{updateAt},update_by=#{updateBy},role_id=#{roleId}")
    Boolean updateRoleUserBack(Long roleId) throws Exception;
}
