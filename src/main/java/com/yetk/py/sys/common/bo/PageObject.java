package com.yetk.py.sys.common.bo;

import java.io.Serializable;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PageObject<T> implements Serializable{

	/**
	 * 分页的封装类
	 */
	private static final long serialVersionUID = 3464307284782291924L;
	private Integer pageCurrent=1;
    private Integer pageSize=10;
    private Integer rowCount=0;
    private Integer pageCount=0;
    private List<T> records;

}
