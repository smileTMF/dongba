package com.yetk.py.sys.vo;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Node implements Serializable{

	/**
	 * ztree 需要的内容
	 */
	private static final long serialVersionUID = 8125805028367754609L;
	
	private Integer id;
	private String name ;
	private Integer parentId;
	
}
