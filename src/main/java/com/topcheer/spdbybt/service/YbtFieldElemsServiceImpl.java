package com.topcheer.spdbybt.service;

import com.topcheer.spdbybt.entity.YbtFieldElems;
import com.topcheer.spdbybt.entity.YbtModuleElems;
import com.topcheer.spdbybt.mapper.YbtFieldElemsMapper;
import com.topcheer.spdbybt.mapper.YbtModuleElemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class YbtFieldElemsServiceImpl implements YbtFieldElemsService {

    @Autowired
    private YbtFieldElemsMapper ybtFieldElemsMapper;

    @Override
    public List<YbtFieldElems> getFieldElemList(YbtFieldElems ybtFieldElems) throws Exception {

        return ybtFieldElemsMapper.getFieldElemList(ybtFieldElems);
    }


   /* @Override
    public YbtModuleElems getById(String atomtypeid){

        return ybtModuleElemsMapper.selectByPrimaryKey(atomtypeid);
    }

    @Override
    public YbtModuleElems getByName(String atomtypename){

        return ybtModuleElemsMapper.selectByAtomtypename(atomtypename);
    }*/
}
