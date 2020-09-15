package com.yetk.py.sys.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yetk.py.sys.common.bo.PageObject;
import com.yetk.py.sys.common.exception.ServiceException;
import com.yetk.py.sys.dao.SysLogDao;
import com.yetk.py.sys.service.SysLogService;
import com.yetk.py.sys.vo.SysLog;
@Service
public class SysLogServiceImpl implements SysLogService{

	@Autowired
	private SysLogDao logDao;
	
	//1.验证参数合法性
	  //1.1验证pageCurrent的合法性，
	  //不合法抛出IllegalArgumentException异常

	@Override
	public PageObject<SysLog> findPageObjects(String username, Integer pageCurrent) {
		System.out.println(pageCurrent);
		if(pageCurrent <= 0) {
			throw new IllegalArgumentException("当前页码不正确");
		}
		int rowCount = logDao.getRowCount(username);
		if(rowCount==0) {
	          throw new ServiceException("系统没有查到对应记录。。。。。。");
		}
		PageObject<SysLog> pageObject=new PageObject<>();//这个里面定义了pagesize不在重复定义
		int startIndex=(pageCurrent-1)*(pageObject.getPageSize());
		List<SysLog> records = logDao.findPageObjects(username, startIndex, pageObject.getPageSize());
		pageObject.setPageCurrent(pageCurrent);
		pageObject.setRowCount(rowCount);
		pageObject.setRecords(records);
		pageObject.setPageCount(rowCount%pageObject.getPageSize()==0?rowCount/pageObject.getPageSize():rowCount/pageObject.getPageSize()+1);
		
		return pageObject;
		
	}

	@Override
	public int deleteObjects(Integer... ids) {
		//一定要进行进行业务判断
		if(ids.length<1){
			throw new IllegalArgumentException("参数不能为空");
		}
		int row = this.logDao.deleteObjects(ids);//dao操作可以使用try catch包裹，任然有出现错误的可能，此时的异常为系统故障，需要专业人员进行调试
		if(row == 0) {
			throw new ServiceException("记录不存在");
		}
		return row;
	}

}
