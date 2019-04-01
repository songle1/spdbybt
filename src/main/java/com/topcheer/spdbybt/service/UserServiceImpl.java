package com.topcheer.spdbybt.service;

import java.util.List;
import java.util.Map;

import com.topcheer.spdbybt.entity.User;
import com.topcheer.spdbybt.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import  com.topcheer.spdbybt.service.UserService;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;


    public List<User> findAllUser() {
        List<User> list = userMapper.findAll();
        return list;
    }

    public List<User> getAll() {
        List<User> list = userMapper.getAll();
        return list;
    }

}