package com.yetk.py.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yetk.py.sys.common.bo.PageObject;
import com.yetk.py.sys.service.SysLogService;
import com.yetk.py.sys.vo.JsonResult;
import com.yetk.py.sys.vo.SysLog;

@Controller
@RequestMapping("/log/")	
public class SysLogController {
	
	@Autowired
	private SysLogService sysLogService;

	@RequestMapping("doFindPageObjects")
	@ResponseBody
	public JsonResult doFindPageObjects(String username,Integer pageCurrent){
//		 try {
			 PageObject<SysLog> pageObject=
						sysLogService.findPageObjects(username,pageCurrent);
					return new JsonResult(pageObject);
//		} catch (Throwable e) {
//			return new JsonResult(0,"fail",e.getMessage());
//		}
	}

	@RequestMapping("doDeleteObjects")
	@ResponseBody
	public JsonResult doDeleteObjects(Integer ... ids){//使用aop对数据进行过滤
		sysLogService.deleteObjects(ids);
		return new JsonResult("delete ok");
	}

}
