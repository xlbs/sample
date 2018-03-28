package com.huayun.sample.north.dao;

import java.util.List;
import java.util.Map;


public interface TestMapper {
	public Map<String,Object> getStationInfoByDeviceNo(String DeviceNo);
	
	public List<Map<String,Object>> getDepartments();
}
