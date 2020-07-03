package com.it.ssm.dao;

import com.it.ssm.domain.Role;
import com.it.ssm.domain.Users;
import org.apache.ibatis.annotations.*;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-18 19:03
 **/
public interface IUsersDao {
    @Select("select * from users where username = #{username}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.it.ssm.dao.IRoleDao.findRoleByUserid"))
    })
    Users findByUserName(String username) throws UsernameNotFoundException;
    @Select("select * from users")
    List<Users> findAll()throws Exception;
    @Insert("insert into users(email,username,password,phoneNum,status)values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void Save(Users users)throws Exception;
    @Select("select * from users where id = #{id}")
    @Results({
            @Result(id = true,column = "id",property = "id"),
            @Result(property = "email",column = "email"),
            @Result(property = "username",column = "username"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.it.ssm.dao.IRoleDao.findRoleByUserid"))
    })
    Users findById(String id) throws Exception;
    @Select("select * from users where id =#{userId}")
    Users findUserById(String userId)throws Exception;
    @Select("select * from role where id not in(select roleid from user_role where userid=#{userId})")
    List<Role> findAllRole(String userId)throws Exception;
    @Insert("insert into user_role (userid,roleid)values(#{userid},#{roleid})")
    void addRoleByRidAndUid(@Param("userid") String userid,@Param("roleid") String roleid);
}
