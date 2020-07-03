package com.it.ssm.dao;

import com.it.ssm.domain.Permission;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-23 17:14
 **/
public interface IPermissionDao {
    @Select("select * from permission where id in(select permissionId from role_permission where roleId=#{id})")
    List<Permission> findPermissionByRoleId(String id) throws Exception;
    @Select("select * from permission")
    List<Permission> findAll()throws Exception;
    @Insert("insert into permission(permissionName,url)values(#{permissionName},#{url})")
    void save(Permission permission)throws Exception;
    @Select("select * from permission where id =#{permissionid}")
    Permission findById(String permissionid);
    @Delete("delete from role_permission where permissionid=#{permissionid}")
    void deleteRole_Permission(String permissionid);
    @Delete("delete from permission where id=#{permissionid}")
    void deletePermission(String permissionid);
}
