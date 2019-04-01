package com.topcheer.spdbybt.controller;

import com.topcheer.spdbybt.entity.Member;
import com.topcheer.spdbybt.service.IMember;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@MapperScan("com.topcheer.spdbybt.dao") //mapper扫描
public class InsPrdController {

    @Autowired
    IMember iMemberFunc;




    @RequestMapping(value = "/insPrdList",method = RequestMethod.GET)
    public String addUser1(String WorkerId,String UserPwd) {
        System.out.println("insPrdList start:");
        try {
            Member member = iMemberFunc.login(WorkerId, UserPwd);
            if(member == null){
                System.out.println("登录失败");
                return "/insPrd/insPrdList";
            }else {
                System.out.println("登录成功");
                return "house_list";
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            System.out.println(e.getMessage());
            System.out.println("登录异常");
        }
        return null;

    }

    @RequestMapping(value = "/templateList",method = RequestMethod.GET)
    public String getTemplateList(String WorkereId,String UserPwd) {
        System.out.println("templateList start:");
        return "house_list";

    }


    @RequestMapping(value = "/insPrdEdit",method = RequestMethod.GET)
    public String insPrdEdit(String WorkereId,String UserPwd) {
        System.out.println("insPrdEdit start:");
        return "/insPrd/insPrdEdit";

    }
}
