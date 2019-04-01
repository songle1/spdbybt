/*
package com.topcheer.spdbybt.common;


import javax.security.auth.Subject;
import javax.servlet.http.HttpServletRequest;
import com.topcheer.spdbybt.entity.Member;

public class SessionUtils {
    private static final String USER_KEY = "SESSION_USER";

    */
/**
     * 获取session用户信息
     * 
     * @param request
     * @return
     *//*

    public static final Member getUser(HttpServletRequest request) {
*/
/*        Object user = request.getSession().getAttribute(USER_KEY);
        if (user != null) {
            return (Member) user;
        } else {
            return null;
        }*//*

        return getUser();
    }

    */
/**
     * 设置session用户信息
     * 
     * @param request
     * @param user
     *//*

    public static final void setUser(HttpServletRequest request, Member user) {
        request.getSession().setAttribute(USER_KEY, user);
    }



}*/
