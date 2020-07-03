package com.it.ssm.service;

import com.it.ssm.domain.Permission;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-24 16:05
 **/
public interface IPermissionService {
    List<Permission> findAll()throws Exception;

    void save(Permission permission)throws Exception;

    Permission findById(String permissionid)throws Exception;

    void deletePermission(String permissionid);
}
