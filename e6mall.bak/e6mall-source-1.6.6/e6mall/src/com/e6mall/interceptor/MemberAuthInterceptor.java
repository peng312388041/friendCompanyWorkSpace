package com.e6mall.interceptor;

import org.apache.log4j.Logger;

import com.e6mall.model.Member;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.AbstractInterceptor;

public class MemberAuthInterceptor extends AbstractInterceptor {
	private static final long serialVersionUID = 7086773816999065732L;
	private Logger logger = Logger.getLogger(this.getClass());
	private String name;

	@Override
	public String intercept(ActionInvocation arg0) throws Exception {
		Member member = (Member)ActionContext.getContext().getSession().get("member");
		if (null != member && null != member.getId() && !member.getId().equals("")) {
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
