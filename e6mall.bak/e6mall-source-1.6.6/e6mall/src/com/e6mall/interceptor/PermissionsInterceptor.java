package com.e6mall.interceptor;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.PermissionsAware;
import com.e6mall.model.Manager;
import com.e6mall.model.Permission;
import com.e6mall.services.ISPermission;
import com.e6mall.utils.Notice;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class PermissionsInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = -4627867921460839284L;
	private Logger logger = Logger.getLogger(this.getClass());

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Object action = arg0.getAction();
		if (action instanceof PermissionsAware) {	//已实现权限接口
			String funccode = ((PermissionsAware)action).getFunccode();	//获得ACTION中的功能模块标识符
			String funcaction = ((PermissionsAware)action).getFuncaction();	//获得ACTION中的功能模块标识符
			ISPermission spermission = ((PermissionsAware)action).getSpermission();	//获得管理员业务
			logger.debug("功能模块funccode:"+funccode);
			Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
			logger.debug("管理员账号类型:"+manager.getCtype());
			if (manager.getCtype().equals("superadmin")) {
				logger.info("管理员账号类型:超级管理员");
				return arg0.invoke();
			}
			DetachedCriteria dc = DetachedCriteria.forClass(Permission.class);
			dc.add(Property.forName("manager").eq(manager));
			dc.add(Property.forName("code").eq(funccode));
			List list = spermission.findAllByCriteria(dc);
			Permission permission = null;
			if (null != list && list.size() > 0) {
				permission = (Permission)list.get(0);
				if (permission.getRead()==4 && funcaction.equals("read")) {
					logger.info("可读");
					return arg0.invoke();
				} else if (permission.getWrite()==2 && funcaction.equals("write")) {
					logger.info("可写");
					return arg0.invoke();
				} else if (permission.getDelete()==1 && funcaction.equals("delete")) {
					logger.info("可删");
					return arg0.invoke();
				} else {
					logger.info("权限不够");
					Notice notice = new Notice();
					notice.setStatus(false);
					notice.setCode("permission denied");
					notice.setTitle("提示");
					notice.setBody("权限不够");
					((PermissionsAware)action).setNotice(notice);
					return "notice";
				}
			} else {
				logger.info("没有该功能的权限设置");
				Notice notice = new Notice();
				notice.setStatus(false);
				notice.setCode("not permissions set");
				notice.setTitle("提示");
				notice.setBody("没有该功能的权限设置，默认拒绝");
				((PermissionsAware)action).setNotice(notice);
				return "notice";
			}
		} else {	//没在实现权限接口，不需要权限控制
			logger.info("没在实现权限接口，不需要权限控制");
			return arg0.invoke();
		}
	}

}
