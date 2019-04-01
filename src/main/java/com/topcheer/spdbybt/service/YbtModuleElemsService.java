package com.topcheer.spdbybt.service;

import com.topcheer.spdbybt.entity.SysElem;
import com.topcheer.spdbybt.entity.YbtModuleElems;

import java.util.List;

public interface YbtModuleElemsService {

    List<YbtModuleElems> getSysElemList(YbtModuleElems sysElem) throws Exception;

    YbtModuleElems getById(String atomtypeid);

    YbtModuleElems getByName(String atomtypename);
}
