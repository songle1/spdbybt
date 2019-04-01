package com.topcheer.spdbybt.service;

import com.topcheer.spdbybt.entity.YbtModuleElems;
import com.topcheer.spdbybt.mapper.SysElemMapper;
import com.topcheer.spdbybt.mapper.YbtModuleElemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class YbtModuleElemsServiceImpl implements YbtModuleElemsService {

    @Autowired
    private YbtModuleElemsMapper ybtModuleElemsMapper;

    @Override
    public List<YbtModuleElems> getSysElemList(YbtModuleElems sysElem) throws Exception {

        return ybtModuleElemsMapper.getSysElemList(sysElem);
    }


    @Override
    public YbtModuleElems getById(String atomtypeid){

        return ybtModuleElemsMapper.selectByPrimaryKey(atomtypeid);
    }

    @Override
    public YbtModuleElems getByName(String atomtypename){

        return ybtModuleElemsMapper.selectByAtomtypename(atomtypename);
    }
}
