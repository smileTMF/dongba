package com.yetk.py.sys.common.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yetk.py.sys.vo.JsonResult;
@ControllerAdvice
public class GlobalExceptionHandler {
	@ExceptionHandler(RuntimeException.class)
	@ResponseBody
	public JsonResult doHandleRuntimeException(
			RuntimeException e){
//    	e.printStackTrace();//也可以写日志
	    return new JsonResult(0,e.getMessage(),e.getMessage());//封装
   }
}
