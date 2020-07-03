package com.it.ssm.service.impl;

import com.it.ssm.dao.IRoleDao;
import com.it.ssm.domain.Permission;
import com.it.ssm.domain.Role;
import com.it.ssm.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-23 21:21
 **/
@Service
@Transactional
public class RolesServiceimpl implements IRolesService {
    @Autowired
    private IRoleDao roleDao;
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }

    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    @Override
    public Role findById(String id) throws Exception {
        return roleDao.findByid(id);
    }

    @Override
    public List<Permission> findOtherPermissions(String roleId) throws Exception {
        return roleDao.findOtherPermissions(roleId);
    }

    @Override
    public void addPermissionToRole(String roleId, String[] permissionids) throws Exception {
       for(String permissionid:permissionids) {
           roleDao.addPermissionToRole(roleId, permissionid);
       }
    }

    @Override
    public Role findByIdForAddPermission(String roleId) {
        return roleDao.findByIdForAddPermission(roleId);
    }

    @Override
    public void deleteByIdAndAllRole(String roleId) throws Exception {
         roleDao.deleteRole_Permission(roleId);
         roleDao.deleteUser_role(roleId);
         roleDao.deleteRole(roleId);
    }
}
