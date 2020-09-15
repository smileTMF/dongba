package com.yetk.py.sys.vo;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysRoleMenuVo {//为什么需要当前类信息，因为在页面中需要多个表的混合数据，为了提高系统的可维护可扩展，为那个页面专门添加的一个vo实体的类对象
	//主要有role的信息，和权限的的id信息
	private Integer id;
	private String name;
	private String note;
	/**角色对应的菜单id，这里即为权限信息*/
	private List<Integer> menuIds;

}
