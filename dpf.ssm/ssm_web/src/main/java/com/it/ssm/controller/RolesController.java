package com.it.ssm.controller;

import com.it.ssm.domain.Permission;
import com.it.ssm.domain.Role;
import com.it.ssm.service.IRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-23 19:59
 **/
@Controller
@RequestMapping("/role")
public class RolesController {
    @Autowired
    private IRolesService rolesService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = rolesService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Role role)throws Exception{
        rolesService.save(role);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name = "id",required = true)String id)throws Exception{
        ModelAndView mv = new ModelAndView();
        Role role =rolesService.findById(id);
        mv.addObject("role",role);
        mv.setViewName("role-show");
        return mv;
    }
    @RequestMapping("/findRoleByIdAndAllPermission.do")
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(required = true,name = "id")String roleId)throws Exception{
        ModelAndView mv=new ModelAndView();
        Role role =rolesService.findByIdForAddPermission(roleId);
        List<Permission>otherPermissions = rolesService.findOtherPermissions(roleId);
        mv.addObject("role", role);
        mv.addObject("permissionList", otherPermissions);
        mv.setViewName("role-permission-add");
        return mv;
    }
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name="roleId",required = true)String roleId,@RequestParam(name = "ids",required = true)String []permissionids)throws Exception{
        rolesService.addPermissionToRole(roleId,  permissionids);
        return "redirect:findAll.do";
    }
    @RequestMapping("/deleteByIdAndAllRole.do")
    public String deleteByIdAndAllRole(@RequestParam(name="id",required = true)String roleId)throws Exception{
        rolesService.deleteByIdAndAllRole(roleId);
        return "redirect:findAll.do";
    }
}
