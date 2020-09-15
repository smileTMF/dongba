package com.yetk.py.sys.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.yetk.py.sys.vo.SysLog;

@Mapper
public interface SysLogDao {
	
	/**
	 * 条件查询，页面需要实现分页
	 * @param username
	 * @return
	 */
	int getRowCount(@Param("username") String username);
	/**
	 * 
	 * @param username 基于查询的分页查询的条件
	 * @param startIndex 开始的条数
	 * @param pageSize 查询的条数
	 * @return
	 */
	List<SysLog> findPageObjects(//这个就是基于分页的查询了
		      @Param("username")String  username,
		      @Param("startIndex")Integer startIndex,
		      @Param("pageSize")Integer pageSize);
	
	/**
	 * 一定要保证参数合法之后再传到dao，不然会报错
	 * @param ids
	 * @return
	 */
	int deleteObjects(@Param("ids")Integer ... ids);



}
