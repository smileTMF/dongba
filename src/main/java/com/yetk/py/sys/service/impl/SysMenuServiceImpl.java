package com.yetk.py.sys.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yetk.py.sys.common.exception.ServiceException;
import com.yetk.py.sys.dao.SysMenuDao;
import com.yetk.py.sys.service.SysMenuService;
import com.yetk.py.sys.vo.Node;
import com.yetk.py.sys.vo.SysMenu;

@Service
public class SysMenuServiceImpl implements SysMenuService{
	
	@Autowired
	private SysMenuDao menuDao;

	@Override
	public List<Map<String, Object>> findObjects() {
		
		return this.menuDao.findObjects();
	}

	@Override
	public int deleteObject(Integer id) {
		//删除菜单信息
		if(id == null || id < 1) {
			throw new IllegalArgumentException("参数不合法");
		}
		int temp = this.menuDao.getChildCount(id);
		if(temp > 0) {
			throw new ServiceException("存在子菜单不能直接删除");
		}
		return this.menuDao.deleteObject(id);
	}

	@Override
	public List<Node> findZtreeMenuNodes() {
		return this.menuDao.findZtreeMenuNodes();
	}

	@Override
	public int saveObject(SysMenu entity) {
			//1.合法验证
			if(entity==null) {
				throw new IllegalArgumentException("保存对象不能为空");
			}
			if(StringUtils.isEmpty(entity.getName())) {
				throw new IllegalArgumentException("菜单名不能为空");
			//2.保存数据
			}
			int  rows=menuDao.insertObject(entity);
			//3.返回数据
			return rows;
		}
	@Override
	public int updateObject(SysMenu entity) {
			//1.合法验证
			if(entity==null)
			throw new ServiceException("保存对象不能为空");
			if(StringUtils.isEmpty(entity.getName()))
			throw new ServiceException("菜单名不能为空");
			
			//2.更新数据
			int rows=menuDao.updateObject(entity);
			if(rows==0)
			throw new ServiceException("记录可能已经不存在");
			//3.返回数据
			return rows;
	}


}
