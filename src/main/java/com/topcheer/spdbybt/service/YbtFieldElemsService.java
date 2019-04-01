package com.topcheer.spdbybt.service;

import com.topcheer.spdbybt.entity.YbtFieldElems;

import java.util.List;

public interface YbtFieldElemsService {

    List<YbtFieldElems> getFieldElemList(YbtFieldElems fieldElem) throws Exception;

    /*YbtFieldElems getById(String atomtypeid);

    YbtFieldElems getByName(String atomtypename);*/
}
