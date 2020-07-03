package com.it.ssm.service;


import com.it.ssm.domain.Role;
import com.it.ssm.domain.Users;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-18 17:27
 **/
public interface IUserService extends UserDetailsService {
    //查询所有用户
    List<Users> findAll() throws Exception;
    //添加用户信息
    void Save(Users users)throws Exception;
    //查询用户信息
    Users findById(String id) throws Exception;
    //查询所有用户
    Users findUserById(String userId)throws Exception;
    //查询其他角色
    List<Role> findAllRole(String userId)throws Exception;
    //添加其他角色
    void addRoleByRidAndUid(String userid, String[] roleids);
}
