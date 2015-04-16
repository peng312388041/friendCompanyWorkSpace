package com.e6mall.action;

import org.apache.commons.mail.HtmlEmail;

import com.e6mall.model.Member;
import com.e6mall.model.Setting;
import com.e6mall.utils.Notice;
import com.opensymphony.xwork2.ActionContext;

public class PasswordFindAction extends BaseAction {
	private static final long serialVersionUID = -6978034687041837958L;
	private String validateCode;
	private String account;
	private String email;

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String find() throws Exception {
		String verifyCode = (String) ActionContext.getContext().getSession().get("fp_VerifyCode");
		if (null != verifyCode && verifyCode.equals(validateCode)) {
			
		} else {
			notice.setStatus(false);
			notice.setCode("validateCode error");
			notice.setTitle("错误");
			notice.setBody("验证码错误");
		}
		return SUCCESS;
	}
	
	private Notice sendmail(Member member) throws Exception {
		Notice notice = new Notice();
		HtmlEmail email = new HtmlEmail();
		Setting smtp_server = ssetting.findByProperty("smtp_server");
		Setting smtp_user = ssetting.findByProperty("smtp_user");
		Setting smtp_password = ssetting.findByProperty("smtp_password");
		email.setHostName(smtp_server.getValue());
		email.setAuthentication(smtp_user.getValue(), smtp_password.getValue());
		email.addTo(member.getEmail(), member.getName());
		email.setFrom(smtp_user.getValue(), "E6mall电子商务系统");
		email.setSubject("找回密码");
		email.setHtmlMsg("<html><a href=\"http://localhost:8080/e6mall/activate.action?a="+member.getActivation()+"\">点击确认修改邮箱</a></html>");
		email.setTextMsg("您的邮箱不支持HTML邮件，您可以在浏览器中浏览以下网址：http://localhost:8080/e6mall/emailupdate.action?a="+member.getActivation()+" ，完成邮箱验证操作。");
		email.send();
		return notice;
	}
}
