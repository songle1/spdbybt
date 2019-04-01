package com.topcheer.spdbybt.mapper;

import com.topcheer.spdbybt.entity.YbtModuleElems;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YbtModuleElemsMapper {
    int deleteByPrimaryKey(String atomtypeid);

    int insert(YbtModuleElems record);

    int insertSelective(YbtModuleElems record);

    YbtModuleElems selectByPrimaryKey(String atomtypeid);

    int updateByPrimaryKeySelective(YbtModuleElems record);

    int updateByPrimaryKey(YbtModuleElems record);

    List<YbtModuleElems> getSysElemList(YbtModuleElems sysElem);

    YbtModuleElems selectByAtomtypename(String atomtypeid);

}