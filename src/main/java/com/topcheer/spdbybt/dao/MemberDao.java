package com.topcheer.spdbybt.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import com.topcheer.spdbybt.entity.Member;
import org.apache.ibatis.annotations.Select;

//@Mapper
public interface MemberDao {
    @Select("select * from Member where name = #{name}")
    Member selectMemberByName(@Param("name")String name)throws Exception;
}
