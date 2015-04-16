package com.e6mall.action;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.e6mall.action.manager.IndexAction;
import com.e6mall.utils.Notice;

public class MloginAction extends BaseAction {
	private static final long serialVersionUID = -6328457661791955556L;
	final static Logger logger = Logger.getLogger(IndexAction.class.getName());
	private String url = "";
	private Notice notice;
	private String account;
	private String password;
	private String validateCode;

	public String execute() throws Exception {
		url = request.getHeader("referer");
		logger.info("待转向URL:" + url);
		return SUCCESS;
	}
	
	public String loggingin() throws Exception {
		if (null != url && StringUtils.isNotEmpty(url) && !url.endsWith("/mlogin.htm")) {
		} else {
			url = "/manager/index.htm";
		}
		notice = smanager.login(account, password, validateCode);
		if (notice.isStatus()) {
			logger.info("账号 " + account + " 成功登录。");
			return SUCCESS;
		} else {
			logger.warn("账户 " + account + " 尝试登录，登录失败。");
			return ERROR;
		}
	}
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String logout() throws Exception {
		session.clear();
		return SUCCESS;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
}
