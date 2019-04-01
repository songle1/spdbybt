package com.topcheer.spdbybt.controller;

import com.topcheer.spdbybt.entity.User;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.topcheer.spdbybt.entity.Member;
import com.topcheer.spdbybt.service.IMember;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@MapperScan("com.topcheer.spdbybt.dao") //mapper扫描
public class LoginController{

    @Autowired
    IMember iMemberFunc;
    @RequestMapping(value = "/ybt")
    public String hello(){
        System.out.println("Hello");
        return "login";
    }

    @RequestMapping(value = "/logout")
    public String logout(){
        System.out.println("Hello");
        return "login";
    }

    @RequestMapping(value = "/login2",method = RequestMethod.GET)
    public String addUser1(String WorkerId,String UserPwd) {
        System.out.println("loginName is:"+WorkerId);
        System.out.println("loginPassword is:"+UserPwd);
        try {
            Member member = iMemberFunc.login(WorkerId, UserPwd);
            if(member == null){
                System.out.println("登录失败");
                return "login";
            }else {
                System.out.println("登录成功");
                return "index";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("登录异常");
        }
        return null;

    }


    @RequestMapping(value = "/login",method = RequestMethod.GET)
    public ModelAndView getUsers(String WorkerId,String UserPwd,String BankCode,HttpServletRequest request) {

        System.out.println("loginName is:"+WorkerId);
        System.out.println("loginPassword is:"+UserPwd);
        System.out.println("loginBankCode is:"+BankCode);

        ModelAndView view = new ModelAndView();

        try {
            Member member = iMemberFunc.login(WorkerId, UserPwd);
            if(member == null){
                System.out.println("登录失败");
                view.setViewName("login");
            }else {
                System.out.println("登录成功");
                request.getSession().setAttribute("operatorPerson",WorkerId);
                request.getSession().setAttribute("operatorbankcode",BankCode);
                view.setViewName("index");
                view.addObject("username",WorkerId);

            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("登录异常");
        }

        User user = new User();
        user.setId(1234234);
        user.setSex("男");
        user.setBankcode(BankCode);
        user.setUsername(WorkerId);
        user.setPassword("********");
        user.setAddress("AJKHSKJHKJ");
        view.addObject("user",user);

        return view;
    }
}
