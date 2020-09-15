package com.yetk.py.sys.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.yetk.py.sys.vo.Node;
import com.yetk.py.sys.vo.SysMenu;

@Mapper
public interface SysMenuDao {
	
	List<Map<String,Object>> findObjects();
	
	int getChildCount(Integer id);
	
	int deleteObject(Integer id);

	List<Node> findZtreeMenuNodes();

	int insertObject(SysMenu entity);

	int updateObject(SysMenu entity);


}
