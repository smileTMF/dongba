package com.yetk.py.sys.service;

import java.util.List;

import com.yetk.py.sys.common.bo.PageObject;
import com.yetk.py.sys.vo.CheckBox;
import com.yetk.py.sys.vo.SysRole;
import com.yetk.py.sys.vo.SysRoleMenuVo;

public interface SysRoleService {
	
	 PageObject<SysRole> findPageObjects(
			 String name,Integer pageCurrent);
	 
	 int saveObject(SysRole entity,Integer[]menuIds);
	 
	 int deleteObject(Integer id);
	 
	 int updateObject(SysRole entity,Integer[] menuIds);

	 SysRoleMenuVo findObjectById(Integer id) ;

	  List<CheckBox> findObjects();
}
