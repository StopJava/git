package com.it.ssm.dao;


import com.it.ssm.domain.Permission;
import com.it.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-18 23:16
 **/
public interface IRoleDao {
    @Select("select * from role where id in(select roleid from user_role where userid = #{userid})")
    @Results({
            @Result(id=true,column = "id",property = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.it.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    List<Role> findRoleByUserid(String userid)throws Exception;
    @Select("select * from role")
    List<Role> findAll()throws Exception;
    @Insert("insert into role(roleName,roleDesc)values(#{roleName},#{roleDesc})")
    void save(Role role)throws Exception;
    @Select("select * from role where id =#{id}")
    @Results({
            @Result(id=true,column="id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many=@Many(select = "com.it.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findByid(String id)throws Exception;
    @Select("select * from permission where id not in(select permissionid from role_permission where roleid=#{roleId})")
    List<Permission> findOtherPermissions(String roleId);
    @Insert("insert into role_permission(roleid,permissionid) values(#{roleId},#{permissionid}) ")
    void addPermissionToRole(@Param("roleId") String roleId,@Param("permissionid")String permissionid)throws Exception;
    @Select("select * from role where id =#{roleId}")
    @Results({
            @Result(id=true,column="id",property = "id"),
            @Result(column = "roleName",property = "roleName"),
            @Result(column = "roleDesc",property = "roleDesc"),
            @Result(column = "id",property = "permissions",javaType = java.util.List.class,many=@Many(select = "com.it.ssm.dao.IPermissionDao.findPermissionByRoleId"))
    })
    Role findByIdForAddPermission(String roleId);
    @Delete("delete from role where id = #{roleId}")
    void deleteRole(String roleId);
    @Delete("delete from user_role where roleid = #{roleId}")
    void deleteUser_role(String roleId);
    @Delete("delete from role_permission where roleid = #{roleId}")
    void deleteRole_Permission(String roleId);
}
