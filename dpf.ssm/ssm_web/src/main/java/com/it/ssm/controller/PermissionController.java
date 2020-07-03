package com.it.ssm.controller;

import com.it.ssm.domain.Permission;
import com.it.ssm.service.IPermissionService;
import com.sun.org.apache.xpath.internal.operations.Mod;
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
 * @create:2020-06-24 16:03
 **/
@Controller
@RequestMapping("/permission")
public class PermissionController {
    @Autowired
    private IPermissionService permissionService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Permission>permissionList = permissionService.findAll();
        mv.addObject("permissionList",permissionList);
        mv.setViewName("permission-list");
        return mv;
    }
    @RequestMapping("/save.do")
    public String save(Permission permission)throws Exception{
        permissionService.save(permission);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById.do")
    public ModelAndView findById(@RequestParam(name="id",required = true)String permissionid)throws Exception{
        ModelAndView mv = new ModelAndView();
        Permission permission=permissionService.findById(permissionid);
        mv.addObject("permission",permission);
        mv.setViewName("permission-show");
        return mv;
    }
    @RequestMapping("/deletePermission.do")
    public String deletePermission(@RequestParam(name="id",required = true)String permissionid)throws Exception{
        permissionService.deletePermission(permissionid);
        return "redirect:findAll.do";
    }
}
