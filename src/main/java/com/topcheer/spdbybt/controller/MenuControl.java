package com.topcheer.spdbybt.controller;

import com.topcheer.spdbybt.entity.Menu;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController/**自动返回的是json格式数据***/
@MapperScan("com.topcheer.spdbybt.dao") //mapper扫描
public class MenuControl {

    @RequestMapping(value = "/menuinit",method = RequestMethod.POST)
    public List menuinit(String resourceType) {
        System.out.println("resourceType is:"+resourceType);
//        try {
        //Member member = iMemberFunc.login(WorkerId, UserPwd);
//            if(member == null){
//                System.out.println("登录失败");
//                return "login";
//            }else {
//                System.out.println("登录成功");
//                return "index";
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            System.out.println(e.getMessage());
//            System.out.println("登录异常");
//        }
        List menuList = new ArrayList();
        if ("YEWUMOKUAI".equals(resourceType)) {
            Menu m1 = new Menu("", false, 0, 1, "", ""
                    , 2, 3, "保险产品管理", 0, "");
            Menu m2 = new Menu("/insPrdList", false, 0, 3, "", ""
                    , 3, 7, "产品信息维护", 0, "");
            Menu m3 = new Menu("/templateList", false, 0, 3, "", ""
                    , 3, 8, "产品库维护", 0, "");
            Menu m4 = new Menu("/templateList", false, 0, 3, "", ""
                    , 3, 9, "产品数据字典", 0, "");

            Menu m5 = new Menu("", false, 0, 1, "", ""
                    , 2, 4, "机构管理", 0, "");
            Menu m6 = new Menu("/templateList", false, 0, 4, "", ""
                    , 3, 10, "银行机构信息维护", 0, "");
            Menu m7 = new Menu("/templateList", false, 0, 4, "", ""
                    , 3, 11, "保险机构信息维护", 0, "");
            Menu m8 = new Menu("/templateList", false, 0, 4, "", ""
                    , 3, 12, "单位签约", 0, "");


            Menu m13 = new Menu("", false, 0, 1, "", ""
                    , 2, 6, "查询统计", 0, "");
            Menu m14 = new Menu("/templateList", false, 0, 6, "", ""
                    , 3, 16, "交易明细查询", 0, "");
            Menu m15 = new Menu("/templateList", false, 0, 6, "", ""
                    , 3, 17, "批量扣款查询", 0, "");
            Menu m16 = new Menu("/templateList", false, 0, 6, "", ""
                    , 3, 18, "对账清算查询", 0, "");




            Menu m9 = new Menu("", false, 0, 1, "", ""
                    , 2, 5, "系统报表", 0, "");
            Menu m10 = new Menu("/xsbb", false, 0, 5, "", ""
                    , 3, 13, "销售报表", 0, "");
            Menu m11 = new Menu("/jgbb", false, 0, 5, "", ""
                    , 3, 14, "监管报表", 0, "");
            Menu m12 = new Menu("/ywbb", false, 0, 5, "", ""
                    , 3, 15, "业务报表", 0, "");
            menuList.add(m1);
            menuList.add(m2);
            menuList.add(m3);
            menuList.add(m4);
            menuList.add(m5);
            menuList.add(m6);
            menuList.add(m7);
            menuList.add(m8);
            menuList.add(m9);
            menuList.add(m10);
            menuList.add(m11);
            menuList.add(m12);

            menuList.add(m13);
            menuList.add(m14);
            menuList.add(m15);
            menuList.add(m16);

            System.out.println(m1.getResourceName());
        } else if ("XITONGMOKUAI".equals(resourceType)) {
            Menu m1 = new Menu("", false, 0, 1, "", ""
                    , 2, 2, "用户信息管理", 0, "");
            Menu m2 = new Menu("/getUserList", false, 0, 2, "", ""
                    , 3, 10, "用户信息维护", 0, "");
            Menu m3 = new Menu("/bxcp", false, 0, 2, "", ""
                    , 3, 11, "用户组信息维护", 0, "");
            Menu m4 = new Menu("/bxcp", false, 0, 2, "", ""
                    , 3, 12, "用户信息复核", 0, "");



            Menu m5 = new Menu("", false, 0, 1, "", ""
                    , 2, 3, "数据字典管理", 0, "");
            Menu m6 = new Menu("/sysElementList", false, 0, 3, "", ""
                    , 3, 13, "数据模块设置", 0, "");
            Menu m7 = new Menu("/fieldElementList", false, 0, 3, "", ""
                    , 3, 14, "数据字段元素设置", 0, "");
            Menu m8 = new Menu("/dataElementList", false, 0, 3, "", ""
                    , 3, 15, "数据字典设置", 0, "");
            Menu m9 = new Menu("/bxcp", false, 0, 3, "", ""
                    , 3, 16, "要素字典设置", 0, "");


            Menu m10 = new Menu("", false, 0, 1, "", ""
                    , 2, 4, "定时任务管理", 0, "");
            Menu m11 = new Menu("/sjzd", false, 0, 4, "", ""
                    , 3, 17, "任务查询", 0, "");
            Menu m12 = new Menu("/bxcp", false, 0, 4, "", ""
                    , 3, 18, "任务设置", 0, "");
            Menu m13 = new Menu("", false, 0, 1, "", ""
                    , 2, 5, "日初日终管理", 0, "");
            Menu m14 = new Menu("/sjzd", false, 0, 5, "", ""
                    , 3, 19, "日初", 0, "");
            Menu m15 = new Menu("/bxcp", false, 0, 5, "", ""
                    , 3, 20, "日终", 0, "");
            menuList.add(m1);
            menuList.add(m2);
            menuList.add(m3);
            menuList.add(m4);
            menuList.add(m5);
            menuList.add(m6);
            menuList.add(m7);
            menuList.add(m8);
            menuList.add(m9);
            menuList.add(m10);
            menuList.add(m11);
            menuList.add(m12);
            menuList.add(m13);
            menuList.add(m14);
            menuList.add(m15);
            System.out.println(m1.getResourceName());
        } else {
            Menu m1 = new Menu("", false, 0, 1, "", ""
                    , 2, 3, "公告管理", 0, "");
            menuList.add(m1);
            System.out.println(m1.getResourceName());
        }

        return menuList;
    }
}
