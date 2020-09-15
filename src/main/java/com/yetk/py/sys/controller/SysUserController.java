package com.yetk.py.sys.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yetk.py.sys.service.SysUserService;
import com.yetk.py.sys.vo.JsonResult;
import com.yetk.py.sys.vo.SysUser;

@RequestMapping("/user/")
@RestController
public class SysUserController {
	  @Autowired
	  private SysUserService sysUserService;


	  @RequestMapping("doFindPageObjects")
	  public JsonResult doFindPageObjects(
	  			 String username,Integer pageCurrent) {
	  		 return new JsonResult(
	  			sysUserService.findPageObjects(username,
	  					pageCurrent));
	  	 }
	  @RequestMapping("doValidById")
	  public JsonResult doValidById(Integer id,Integer valid){
	  		        sysUserService.validById(id,valid);		
	  return new JsonResult("update ok");
	  }
		@RequestMapping("doSaveObject")
		public JsonResult doSaveObject(
				SysUser entity,
				Integer[] roleIds){
			sysUserService.saveObject(entity,roleIds);
			return new JsonResult("save ok");
		}

		@RequestMapping("doFindObjectById")
		public JsonResult doFindObjectById(
				Integer id){
			Map<String,Object> map=
			sysUserService.findObjectById(id);
			return new JsonResult(map);
		}
		@RequestMapping("doUpdateObject")
		public JsonResult doUpdateObject(
		    SysUser entity,Integer[] roleIds){
			sysUserService.updateObject(entity,roleIds);
			return new JsonResult("update ok");
		}

}
