package com.topcheer.spdbybt.service;

import com.topcheer.spdbybt.service.IMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.topcheer.spdbybt.common.StringUtil;
import com.topcheer.spdbybt.entity.Member;
import com.topcheer.spdbybt.dao.MemberDao;

@Service
public class MemberImpl implements IMember {
    @Autowired
    private MemberDao mDao;

    public Member login(String name, String password) throws Exception {
         System.out.println(name + password);
        if (StringUtil.isNullOrZero(name)) {
            System.out.println("登录名不能为空");
            return null;
        }
        if (StringUtil.isNullOrZero(password)) {
            System.out.println("密码不能为空");
            return null;
        }
        Member member = mDao.selectMemberByName(name);
        System.out.println("==========name="+name);
        if (member == null)
            System.out.println("登录名错误");
        if (member != null&&member.getName().equals(name)&&!password.equals(member.getPassword())) {
            System.out.println("密码错误");
            return null;
        }
        return member;
    }
}
