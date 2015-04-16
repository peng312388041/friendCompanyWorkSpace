package com.e6mall.interceptor;

import org.apache.log4j.Logger;

import com.e6mall.model.Manager;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class ManagerAuthInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 2139640528536784511L;
	private Logger logger = Logger.getLogger(this.getClass());
	private String name;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Manager manager = (Manager)ActionContext.getContext().getSession().get("manager");
		if (null != manager && null != manager.getId() && !manager.getId().equals("")) {
			logger.debug("MemberAuth拦截器：已登录");
			return arg0.invoke();
		} else {
			logger.debug("MemberAuth拦截器：未登录");
			return "notauth";
		}
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
