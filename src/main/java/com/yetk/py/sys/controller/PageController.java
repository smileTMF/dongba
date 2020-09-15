package com.yetk.py.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PageController {
	
	@RequestMapping("doIndexUI")
	public String doIndexUI(){
		return "starter";
	}
	//下面的请求都是ajax请求，并且页面只进行局部刷新
	@RequestMapping("log/log_list")
	public String doLogUI() {
		return "sys/log_list";
	}
	@RequestMapping("doPageUI")
	public String doPageUI() {
		return "common/page";
	}
	@RequestMapping("menu/menu_list")
	public String doMenuUI() {
		return "sys/menu_list";
	}
	@RequestMapping("{module}/{moduleUI}")//拦截了对应结构的请求
	public String doModuleUI(@PathVariable String moduleUI) {
			return "sys/"+moduleUI;
	}

}
