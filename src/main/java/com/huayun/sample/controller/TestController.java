package com.huayun.sample.controller;

import com.huayun.sample.service.south.intf.I_SouthTestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.huayun.sample.service.north.intf.I_NorthTestService;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@Autowired
	private I_NorthTestService northTestService;

	@Autowired
	private I_SouthTestService southTestService;
	
	@RequestMapping("/northData")
	@ResponseBody
	public Object northDataTest(){
		return northTestService.getTestNorthData();
	}

	@RequestMapping("/southData")
	@ResponseBody
	public Object southDataTest(){
		return southTestService.getTestSouthData();
	}
	
	@RequestMapping("/helloword")
	@ResponseBody
	public Object helloword(){
		return "hello word!";
	}


}
