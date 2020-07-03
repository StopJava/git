package com.it.ssm.service;

import com.it.ssm.domain.Permission;
import com.it.ssm.domain.Role;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-23 21:20
 **/
public interface IRolesService {
    List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(String id) throws Exception;

    List<Permission> findOtherPermissions(String roleId)throws Exception;

    void addPermissionToRole(String roleId, String[] permissionids)throws Exception;

    Role findByIdForAddPermission(String roleId);

    void deleteByIdAndAllRole(String roleId)throws Exception;
}
