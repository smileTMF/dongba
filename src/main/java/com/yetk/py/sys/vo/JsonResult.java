package com.yetk.py.sys.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class JsonResult implements Serializable{
	
	/**
	 * 返回的json的内容的封装的类
	 */
	private static final long serialVersionUID = 1447081072838120817L;
	private int state=1;//1表示SUCCESS,0表示ERROR
	/**状态信息*/
	private String message="ok";
	/**正确数据*/
	private Object data;
	
	public JsonResult (Object data) {
		this.data = data;
	}

}
