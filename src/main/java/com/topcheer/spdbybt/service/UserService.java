package com.topcheer.spdbybt.service;

import com.topcheer.spdbybt.mapper.UserMapper;
import com.topcheer.spdbybt.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zl on 2015/8/27.
 */

public interface UserService {

    /**
     * 根据接口查询所用的用户
     */
    public List<User> findAllUser();



    /**
     * 根据接口查询所用的用户
     */
    public List<User> getAll();
}