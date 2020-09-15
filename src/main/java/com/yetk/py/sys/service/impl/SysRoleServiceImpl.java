package com.yetk.py.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.yetk.py.sys.common.bo.PageObject;
import com.yetk.py.sys.common.exception.ServiceException;
import com.yetk.py.sys.dao.SysRoleDao;
import com.yetk.py.sys.dao.SysRoleMenuDao;
import com.yetk.py.sys.dao.SysUserRoleDao;
import com.yetk.py.sys.service.SysRoleService;
import com.yetk.py.sys.vo.CheckBox;
import com.yetk.py.sys.vo.SysRole;
import com.yetk.py.sys.vo.SysRoleMenuVo;

@Service
public class SysRoleServiceImpl implements SysRoleService{

	@Autowired
	private SysUserRoleDao sysUserRoleDao;

	@Autowired
	private SysRoleDao sysRoleDao;

	@Autowired
	private SysRoleMenuDao sysRoleMenuDao;

	@Override
	public PageObject<SysRole> findPageObjects(String name, Integer pageCurrent) {
		if(pageCurrent==null||pageCurrent<1)
			throw new IllegalArgumentException("当前页码值无效");
		//2.查询总记录数并进行校验
		int rowCount=sysRoleDao.getRowCount(name);
		if(rowCount==0)
			throw new ServiceException("没有找到对应记录");
		//3.查询当前页记录
		int pageSize=2;

		int startIndex=(pageCurrent-1)*pageSize;
		List<SysRole> records=
				sysRoleDao.findPageObjects(name,
						startIndex, pageSize);
		//4.对查询结果进行封装并返回
		PageObject<SysRole> pageObject =  new PageObject<>();
		pageObject.setPageSize(pageSize);
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		int temp = rowCount%pageObject.getPageSize()==0?rowCount/pageObject.getPageSize():(rowCount/pageObject.getPageSize())+1;
		pageObject.setPageCount(temp);
		return pageObject;
	}

	@Override
	public int saveObject(SysRole entity, Integer[] menuIds) {
		//1.参数有效性校验
		if(entity==null)
			throw new IllegalArgumentException("保存对象不能为空");
		if(StringUtils.isEmpty(entity.getName()))
			throw new IllegalArgumentException("角色名不允许为空");
		if(menuIds==null||menuIds.length==0)
			throw new ServiceException("必须为角色分配权限");
		//2.保存角色自身信息
		int rows=sysRoleDao.insertObject(entity);
		//3.保存角色菜单关系数据
		sysRoleMenuDao.insertObjects(entity.getId(), menuIds);
		//4.返回业务结果
		return rows;
	}

	@Override
	public int deleteObject(Integer id) {//删除一个角色需要修改三个表单的信息
		if(id==null||id<=0)
			throw new IllegalArgumentException("请先选择");
		sysRoleMenuDao.deleteObjectsByRoleId(id);//删除角色与权限的关系
		sysUserRoleDao.deleteObjectsByRoleId(id);//删除角色与用户的关系
		int rows=sysRoleDao.deleteObject(id);//删除角色表中的数据
		if(rows==0)
			throw new ServiceException("此记录可能已经不存在");
		//5.返回结果
		return rows;
	}

	@Override
	public int updateObject(SysRole entity, Integer[] menuIds) {
		if(entity==null)
	        throw new IllegalArgumentException("更新的对象不能为空");
	    	if(entity.getId()==null)
	    	throw new IllegalArgumentException("id的值不能为空");
	    	
	    	if(StringUtils.isEmpty(entity.getName()))
	    	throw new IllegalArgumentException("角色名不能为空");
	    	if(menuIds==null||menuIds.length==0)
	    	throw new IllegalArgumentException("必须为角色指定一个权限");
	    	
	    	//2.更新数据
	    	int rows=sysRoleDao.updateObject(entity);
	    	if(rows==0)
	        throw new ServiceException("对象可能已经不存在");
	    	sysRoleMenuDao.deleteObjectsByRoleId(entity.getId());
	    	sysRoleMenuDao.insertObjects(entity.getId(),menuIds);
	    	//3.返回结果
	    	return rows;
	}

	@Override
	public SysRoleMenuVo findObjectById(Integer id) {
	 	//1.合法性验证
    	if(id==null||id<=0)
    	throw new IllegalArgumentException("id的值不合法");
    	//2.执行查询
    	SysRoleMenuVo result=sysRoleDao.findObjectById(id);
  	//3.验证结果并返回
    	if(result==null)
    	throw new ServiceException("此记录已经不存在");
    	return result;

	}

	@Override
    public List<CheckBox> findObjects() {
     	return sysRoleDao.findObjects();
    }



}
