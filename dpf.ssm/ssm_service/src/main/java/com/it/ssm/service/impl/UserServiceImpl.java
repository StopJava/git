package com.it.ssm.service.impl;

import com.it.ssm.dao.IUsersDao;
import com.it.ssm.domain.Role;
import com.it.ssm.domain.Users;
import com.it.ssm.service.IUserService;
import com.it.ssm.utils.PasswordEncoder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-18 17:27
 **/
@Service("UserService")
@Transactional
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUsersDao usersDao;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
        Users users =usersDao.findByUserName(username);
        User user = new User(users.getUsername(),users.getPassword(), users.getStatus() == 1,true,true,true,getAuthority(users.getRoles()));
        return user;
    }
    public List<SimpleGrantedAuthority> getAuthority(List<Role>roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role :roles) {
            list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
        }
        return list;
    }

    @Override
    public List<Users> findAll() throws Exception{
        return usersDao.findAll();
    }

    @Override
    public void Save(Users users) throws Exception {
        users.setPassword(PasswordEncoder.Encoder(users.getPassword()));
        usersDao.Save(users);
    }

    @Override
    public Users findById(String id) throws Exception{
        return usersDao.findById(id);
    }

    @Override
    public Users findUserById(String roleId) throws Exception{
        return usersDao.findUserById(roleId);
    }

    @Override
    public List<Role> findAllRole(String userId)throws Exception {
        return usersDao.findAllRole(userId);
    }

    @Override
    public void addRoleByRidAndUid(String userid, String[] roleids) {
        for(String roleid:roleids){
            usersDao.addRoleByRidAndUid(userid,roleid);
        }
    }
}
