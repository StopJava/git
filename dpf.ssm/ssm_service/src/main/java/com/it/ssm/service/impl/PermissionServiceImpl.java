package com.it.ssm.service.impl;

import com.it.ssm.dao.IPermissionDao;
import com.it.ssm.domain.Permission;
import com.it.ssm.service.IPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-24 16:09
 **/
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {
    @Autowired
    private IPermissionDao permissionDao;
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    @Override
    public void save(Permission permission) throws Exception{
        permissionDao.save(permission);
    }

    @Override
    public Permission findById(String permissionid) throws Exception {
        return permissionDao.findById(permissionid);
    }

    @Override
    public void deletePermission(String permissionid) {
        permissionDao.deleteRole_Permission(permissionid);
        permissionDao.deletePermission(permissionid);
    }
}
