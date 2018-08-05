package com.jnshu.dao2;

import com.jnshu.Domain2.DomainModuleBackForLogin;
import com.jnshu.entity.ModuleBack;
import com.jnshu.entity.RoleModuleBack;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component(value = "roleModuleBackMapper")
public interface RoleModuleBackMapper {

    //新增
    @Insert("insert into  role_module_back (create_at, create_by, update_at, update_by, role_id, module_id) values (#{createAt},#{createBy}, #{updateAt},#{updateBy}, #{roleId},#{moduleId})")
    @Options(useGeneratedKeys = true)
    public Long savERoleModule(RoleModuleBack roleModuleBack) throws Exception;

    //删除
    @Delete("delete from role_module_back where id=#{id}")
    public Boolean delete(Long id) throws Exception;

    //查询总数
    @Select("select count(*) from role_module_back")
    public Integer getTotal() throws Exception;

    //查询角色的模块id列表
    @Select("select a.module_id as id,b.module_name, b.super_id from role_module_back a, module_back b where a.module_id=b.id and a.role_id=#{id}")
    public List<DomainModuleBackForLogin> getModuleOfRole(Long id) throws Exception;
}
