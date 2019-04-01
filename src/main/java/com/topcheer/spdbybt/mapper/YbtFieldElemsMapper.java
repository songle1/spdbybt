package com.topcheer.spdbybt.mapper;

import com.topcheer.spdbybt.entity.YbtFieldElems;
import com.topcheer.spdbybt.entity.YbtModuleElems;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface YbtFieldElemsMapper {
    int deleteByPrimaryKey(String fieldid);

    int insert(YbtFieldElems record);

    int insertSelective(YbtFieldElems record);

    YbtFieldElems selectByPrimaryKey(String fieldid);

    int updateByPrimaryKeySelective(YbtFieldElems record);

    int updateByPrimaryKey(YbtFieldElems record);

    List<YbtFieldElems> getFieldElemList(YbtFieldElems ybtFieldElems);

    YbtFieldElems selectByFieldcname(String fieldcname);

    YbtFieldElems selectByFieldename(String fieldename);

    List<YbtFieldElems> getByInputType();
}