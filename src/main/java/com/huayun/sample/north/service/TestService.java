package com.huayun.sample.north.service;

import java.util.List;
import java.util.Map;

public interface TestService {
	public Map<String,Object> getStationInfoByDeviceNo(String DeviceNo);
	public List<Map<String,Object>> getDepartments();
}
