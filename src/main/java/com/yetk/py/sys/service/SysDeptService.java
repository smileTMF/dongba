package com.yetk.py.sys.service;

import java.util.List;
import java.util.Map;

import com.yetk.py.sys.vo.Node;
import com.yetk.py.sys.vo.SysDept;

public interface SysDeptService {
	 List<Map<String,Object>> findObjects();
	 List<Node> findZTreeNodes();
	 int saveObject(SysDept entity);
	 int updateObject(SysDept entity);
	 int deleteObject(Integer id);
}
