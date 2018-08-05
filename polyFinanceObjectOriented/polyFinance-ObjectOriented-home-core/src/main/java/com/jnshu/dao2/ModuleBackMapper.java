package com.jnshu.dao2;

import com.jnshu.Domain2.DomainModuleBack;
import com.jnshu.entity.ModuleBack;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ModuleBackMapper {

    //新增
    @Insert("insert into module_back( create_at,create_by, update_at,update_by,module_name,super_id,module_type,module_url,menu_id) values (#{createAt},#{createBy}, #{updateAt},#{updateBy},#{moduleName},#{superId},#{moduleType},#{moduleUrl},#{menuId})")
    @Options(useGeneratedKeys = true)
    Integer saveModuleBack(ModuleBack moduleBack) throws Exception;

    //删除
    @Delete("delete from module_back where id = #{id}")
    Boolean deleteModuleBack(Long id) throws Exception;

    //更新
    @Update("update module_back set create_at=#{createAt}, create_by=#{createBy}, update_at=#{updateAt},update_by=#{updateBy},module_name=#{moduleName},super_id=#{superId},module_type=#{moduleType},module_url=#{moduleUrl},menu_id=#{menuId} where id=#{id}")
    Boolean updateModuleBack(ModuleBack moduleBack) throws Exception;

    //查找-list。内连接。
//    @Select("select a.id,a.create_at,b.login_name as createBy,a.update_at,b.login_name as updateBy,a.module_name,a.super_id,a.module_type, a.module_url, a.menu_id  from module_back a, user_back b where a.create_by=b.id or a.update_by=b.id")
    @Select("select distinct a.id,a.create_at,b.login_name as create_by,a.update_at,b.login_name as update_by,a.module_name,a.super_id,a.module_type, a.module_url, a.menu_id  from module_back a inner join  user_back b on a.create_by=b.id or a.update_by=b.id")
    List<DomainModuleBack> getAll() throws Exception;

    //查找-通过id查详情。
    @Select("select * from module_back where id=#{id}")
//    @Select("select id,module_name,super_id,module_type,module_url,menu_id from module_back where id=#{id}")
    ModuleBack getById(Long id) throws Exception;


}
