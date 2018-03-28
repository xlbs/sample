package com.huayun.sample.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huayun.sample.north.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private TestService testService;
	
	@RequestMapping("/queryTest")
	@ResponseBody
	public Object test(@RequestParam(value="deviceNo") String deviceNo){
		return testService.getStationInfoByDeviceNo(deviceNo);
	}
	
	@RequestMapping("/dbSearch")
	@ResponseBody
	public Object test(){
		return testService.getDepartments();
	}
	
	@RequestMapping("/helloword")
	@ResponseBody
	public Object helloword(){
		return "hello word!";
	}
}
