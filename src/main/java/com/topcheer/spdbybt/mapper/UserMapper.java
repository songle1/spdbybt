package com.topcheer.spdbybt.mapper;

import java.util.List;
import com.topcheer.spdbybt.entity.User;
import org.apache.ibatis.annotations.Mapper;
import tk.mybatis.mapper.common.BaseMapper;

@Mapper
public interface UserMapper extends BaseMapper<User>{

    public List<User> findAll();

    //public User findAll();

    List<User> getAll();

}
