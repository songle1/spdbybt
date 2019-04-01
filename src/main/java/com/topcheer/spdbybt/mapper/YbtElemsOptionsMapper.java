package com.topcheer.spdbybt.mapper;

import com.topcheer.spdbybt.entity.YbtElemsOptions;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface YbtElemsOptionsMapper {


    int deleteByPrimaryKey(YbtElemsOptions ybtElemsOptions);

    int insert(YbtElemsOptions record);

    int insertSelective(YbtElemsOptions record);

    YbtElemsOptions selectByPrimaryKey(YbtElemsOptions ybtElemsOptions);

    int updateByPrimaryKeySelective(YbtElemsOptions record);

    int updateByPrimaryKey(YbtElemsOptions record);

    List<YbtElemsOptions> getElemsOptionsList(YbtElemsOptions ybtElemsOptions);
}