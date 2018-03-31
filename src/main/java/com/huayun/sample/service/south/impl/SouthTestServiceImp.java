package com.huayun.sample.service.south.impl;

import com.huayun.sample.dao.south.SouthTestMapper;
import com.huayun.sample.service.south.intf.I_SouthTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SouthTestServiceImp implements I_SouthTestService {

    @Autowired
    private SouthTestMapper southTestMapper;

    @Override
    public List<Map<String, Object>> getTestSouthData() {
        return southTestMapper.getTestSouthData();
    }

}
