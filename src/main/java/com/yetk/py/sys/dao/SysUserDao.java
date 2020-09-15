package com.yetk.py.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yetk.py.sys.vo.SysUser;
import com.yetk.py.sys.vo.SysUserDeptVo;

@Mapper
public interface SysUserDao {
	
	int getRowCount( String username);
	
	List<SysUserDeptVo> findPageObjects(
		      @Param("username")String  username,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);

	int validById(
			@Param("id")Integer id,
			@Param("valid")Integer valid,
			@Param("modifiedUser")String modifiedUser);
	
	int insertObject(SysUser entity);

	SysUserDeptVo findObjectById(Integer id);

	int updateObject(SysUser entity);

}
