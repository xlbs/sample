package com.huayun.sample.north.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huayun.sample.north.dao.TestMapper;


@Service
public class TestServiceImpl implements TestService {
	
	@Autowired
	private TestMapper testMapper;

	@Override
	public Map<String, Object> getStationInfoByDeviceNo(String DeviceNo) {		
		return testMapper.getStationInfoByDeviceNo(DeviceNo);
	}

	@Override
	public List<Map<String, Object>> getDepartments() {
		// TODO Auto-generated method stub
		return testMapper.getDepartments();
	}

}
