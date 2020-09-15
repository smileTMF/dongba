package com.yetk.py.sys.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.yetk.py.sys.service.SysMenuService;
import com.yetk.py.sys.vo.JsonResult;
import com.yetk.py.sys.vo.SysMenu;

@RestController
@RequestMapping("/menu/")
public class SysMenuController {
	
	@Autowired
	private SysMenuService sysMenuService;
	
	@RequestMapping("doFindObjects")
	public JsonResult doFindObjects() {
		return new  JsonResult(sysMenuService.findObjects());
	}

	@RequestMapping("doDeleteObject")
	public JsonResult doDeleteObject(Integer id) {
		return new JsonResult(this.sysMenuService.deleteObject(id));
	}
	@RequestMapping("doFindZtreeMenuNodes")
	public JsonResult doFindZtreeMenuNodes(Integer id) {
		return new JsonResult(
				sysMenuService.findZtreeMenuNodes());
	}
	@PostMapping("doSaveObject")
	public JsonResult doSaveObject(SysMenu entity){
		sysMenuService.saveObject(entity);
		return new JsonResult("save ok");
	}

	@PostMapping("doUpdateObject")
	public JsonResult doUpdateObject(SysMenu entity){
		sysMenuService.updateObject(entity);
		return new JsonResult("update ok");
	}

}
