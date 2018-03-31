package com.huayun.sample;

import com.huayun.sample.service.north.intf.I_NorthTestService;
import com.huayun.sample.service.south.intf.I_SouthTestService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SampleApplicationTests {

	@Autowired
	private I_NorthTestService northTestService;

	@Autowired
	private I_SouthTestService southTestService;

	@Test
	public void testDB(){
		/*北数据库*/
		List<Map<String,Object>> northResult = northTestService.getTestNorthData();
		System.out.println("north start.......");
		System.out.println(northResult);
		System.out.println("north end.......");

		/*南数据库*/
		List<Map<String,Object>> southResult = southTestService.getTestSouthData();
		System.out.println("south start.......");
		System.out.println(southResult);
		System.out.println("south end.......");


	}


	@Test
	public void contextLoads() {
	}

}
