package com.yetk.py.sys.service;

import java.util.Map;

import com.yetk.py.sys.common.bo.PageObject;
import com.yetk.py.sys.vo.SysUser;
import com.yetk.py.sys.vo.SysUserDeptVo;

public interface SysUserService {

	PageObject<SysUserDeptVo> findPageObjects(String username,Integer pageCurrent);
	
	int validById(Integer id,Integer valid);

	int saveObject(SysUser entity,Integer[]roleIds);
	
	Map<String,Object> findObjectById(Integer userId) ;
	
	int updateObject(SysUser entity,Integer[] roleIds);


}
