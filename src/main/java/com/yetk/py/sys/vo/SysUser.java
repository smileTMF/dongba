package com.yetk.py.sys.vo;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysUser implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -8893553383814818759L;
	private Integer id;
	private String username;
	private String password;
	private String salt;//盐值
	private String email;
	private String mobile;
	private Integer valid=1;
      private Integer deptId;
	private Date createdTime;
	private Date modifiedTime;
	private String createdUser;
	private String modifiedUser;

}
