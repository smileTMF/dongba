package com.yetk.py.sys.service;

import com.yetk.py.sys.common.bo.PageObject;
import com.yetk.py.sys.vo.SysLog;

public interface SysLogService {
	
	 PageObject<SysLog> findPageObjects(
			 String username,
			 Integer pageCurrent);

	 int deleteObjects(Integer ... ids) ;
}
