package com.e6mall.action;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;

import com.e6mall.model.Config;
import com.e6mall.utils.Notice;

public class LoginAction extends BaseAction {
	private static final long serialVersionUID = -8080971851916350575L;
	private final static Logger logger=Logger.getLogger(LoginAction.class);
	private String url;
	private Notice notice = new Notice();
	private String account;
	private String password;
	private String validateCode;

	public String execute() throws Exception {
		GlobalChcontent(map);
		url = (String)session.get("url");
		/*if (null != url && !url.equals("")) {
		} else if (url.equals("my_scart.htm")) {
		} else {
			url = "/member/index.htm";
		}*/
		//url = request.getHeader("referer");
        logger.info("待转向URL:" + url);
		return SUCCESS;
	}
	
	/*
	 * url: 页面上传过来的转向URL
	 */
	public String loggingin() throws Exception {
		//是否禁止登录
		Config funcLogin = sconfig.findByProperty("funcLogin");
		if (null != funcLogin && null != funcLogin.getValue() && funcLogin.getValue().equals("enable")) {
			notice.setStatus(false);
			notice.setCode("Login_Disabled");
			notice.setTitle("提示：");
			notice.setBody("系统关闭了用户登录，请稍候再试，或联系管理员。");
			return ERROR;
		}
		
		url = (String)session.get("url");
		if (StringUtils.isNotEmpty(url)) {
			if (!url.equals("my_scart.htm")) {
				
			}
		} else {
			url = "/member/index.htm";
		}
		notice = smember.login(account, password, validateCode);
		if (notice.isStatus())
			return SUCCESS;
		else
			return ERROR;
	}
	
	public String logout() throws Exception {
		session.clear();
		return SUCCESS;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
