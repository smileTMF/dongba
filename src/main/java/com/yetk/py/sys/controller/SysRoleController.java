package com.yetk.py.sys.controller;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yetk.py.sys.service.SysRoleService;
import com.yetk.py.sys.vo.JsonResult;
import com.yetk.py.sys.vo.SysRole;

@RestController
@RequestMapping("/role/")
public class SysRoleController {

	@Autowired
	private SysRoleService sysRoleService;

	@RequestMapping("doFindPageObjects")
	public JsonResult doFindPageObjects(
			String username,Integer pageCurrent) {
		System.out.println(username+":"+pageCurrent);
		return new JsonResult(sysRoleService.findPageObjects(username,pageCurrent));
	}

	@RequestMapping("doSaveObject")
	public JsonResult doSaveObject(
			SysRole entity,Integer[] menuIds){
		sysRoleService.saveObject(entity,menuIds);
		return new JsonResult("save ok");    
	}

	@RequestMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysRole entity,
	Integer[] menuIds){
			  sysRoleService.updateObject(entity,menuIds);
	 return new JsonResult("update ok");
	 }

	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		System.out.println(id+"..................");
		  sysRoleService.deleteObject(id);
		  return new JsonResult("delete ok");

	}
	@RequestMapping("doFindObjectById")
	 public JsonResult doFindObjectById(Integer id){
	    	return new JsonResult(sysRoleService.findObjectById(id));
	 }
	@RequestMapping("doFindRoles")
	 public JsonResult doFindRoles() {
		 return new JsonResult(sysRoleService.findObjects());
	 }

}

