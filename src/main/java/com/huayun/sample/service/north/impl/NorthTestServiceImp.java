package com.huayun.sample.service.north.impl;

import java.util.List;
import java.util.Map;

import com.huayun.sample.service.north.intf.I_NorthTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayun.sample.dao.north.NorthTestMapper;


@Service
public class NorthTestServiceImp implements I_NorthTestService {
	
	@Autowired
	private NorthTestMapper northTestMapper;

	@Override
	public List<Map<String, Object>> getTestNorthData() {
		return northTestMapper.getTestNorthData();
	}

}
