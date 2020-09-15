package com.yetk.py.sys.service;

import java.util.List;
import java.util.Map;

import com.yetk.py.sys.vo.Node;
import com.yetk.py.sys.vo.SysMenu;


public interface SysMenuService {

	List<Map<String,Object>> findObjects();
	
	int deleteObject(Integer id);

	List<Node> findZtreeMenuNodes();

	int saveObject(SysMenu entity);
	
	int updateObject(SysMenu entity);

}
