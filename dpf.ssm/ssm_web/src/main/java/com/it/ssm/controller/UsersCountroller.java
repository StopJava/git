package com.it.ssm.controller;

import com.it.ssm.domain.Role;
import com.it.ssm.domain.Users;
import com.it.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @program:dpf.ssm
 * @description:
 * @autor:dpf
 * @create:2020-06-22 14:58
 **/
@Controller
@RequestMapping("/user")
public class UsersCountroller {
    @Autowired
    IUserService userService;
    @RequestMapping("/findAll.do")
    public ModelAndView findAll()throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Users> usersList = userService.findAll();
        mv.addObject("userList",usersList);
        mv.setViewName("user-list");
        return mv;
    }
    @RequestMapping("/save.do")
    @PreAuthorize("authentication.principal.username='tom'")
    public String save(Users users)throws Exception{
        userService.Save(users);
        return "redirect:findAll.do";
    }
    @RequestMapping("/findById")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    public ModelAndView findById(String id) throws Exception{
        ModelAndView mv =new ModelAndView();
        Users user =userService.findById(id);
        mv.addObject("user",user);
        mv.setViewName("user-show");
        return mv;
    }
    //查询其余角色
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name="id",required = true)String userId)throws Exception{
        ModelAndView mv=new ModelAndView();
        Users users =userService.findUserById(userId);
        List<Role>otherroles=userService.findAllRole(userId);
        mv.addObject("users",users);
        mv.addObject("roles",otherroles);
        mv.setViewName("user-role-add");
        return mv;
    }
    //添加角色
    @RequestMapping("/addRoleByRidAndUid.do")
    public String addRoleByRidAndUid(@RequestParam(name="userId",required = true)String userid,@RequestParam(name="ids",required = true)String []roleids)throws Exception{
        userService.addRoleByRidAndUid(userid,roleids);
        return "redirect:findAll.do";
    }
}
