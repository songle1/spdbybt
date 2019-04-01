package com.topcheer.spdbybt.mapper;

import com.topcheer.spdbybt.entity.SysElem;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface SysElemMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(SysElem record);

    int insertSelective(SysElem record);

    SysElem selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(SysElem record);

    int updateByPrimaryKey(SysElem record);

    List<SysElem> getSysElemList(SysElem sysElem);
}