package com.topcheer.spdbybt.service;

import com.topcheer.spdbybt.entity.YbtElemsOptions;
import com.topcheer.spdbybt.entity.YbtFieldElems;
import com.topcheer.spdbybt.mapper.YbtElemsOptionsMapper;
import com.topcheer.spdbybt.mapper.YbtFieldElemsMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class YbtElemsOptionsServiceImpl implements YbtElemsOptionsService {

    @Autowired
    private YbtElemsOptionsMapper ybtElemsOptionsMapper;

    @Override
    public List<YbtElemsOptions> getElemsOptionsList(YbtElemsOptions ybtElemsOptions) {

        return ybtElemsOptionsMapper.getElemsOptionsList(ybtElemsOptions);
    }


}
