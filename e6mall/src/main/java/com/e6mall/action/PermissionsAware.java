package com.e6mall.action;

import com.e6mall.services.ISManager;
import com.e6mall.services.ISPermission;
import com.e6mall.utils.Notice;

/*
 * 操作权限检查接口
 */
public interface PermissionsAware {
	public String getFunccode();	//功能模块标识符
	public void setFunccode(String funccode);
	public String getFuncaction();	//功能操作类型
	public void setFuncaction(String funcaction);
	public String getFuncname();	//功能模块名称
	public void setFuncname(String funcname);
	public Notice getNotice();
	public void setNotice(Notice notice);	//返回消息
	public ISManager getSmanager();	//管理员业务
	public void setSmanager(ISManager smanager);
	public ISPermission getSpermission();
	public void setSpermission(ISPermission spermission);
}
