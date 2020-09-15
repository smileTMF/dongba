package com.yetk;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.yetk.py.sys.common.bo.PageObject;
import com.yetk.py.sys.service.SysLogService;
import com.yetk.py.sys.vo.SysLog;

@SpringBootTest
class CgbDbApplicationTests {
	
	@Autowired
	private SysLogService service;

	@Test
	void contextLoads() {
		
		PageObject<SysLog> test = this.service.findPageObjects(null, 1);
		System.out.println(test);
	}

}
