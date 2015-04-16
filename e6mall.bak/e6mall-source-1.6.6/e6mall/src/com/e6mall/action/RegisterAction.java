package com.e6mall.action;

import org.apache.commons.mail.HtmlEmail;

import com.e6mall.model.Config;
import com.e6mall.model.Member;
import com.e6mall.model.Setting;
import com.e6mall.utils.Notice;

public class RegisterAction extends BaseAction {
	private static final long serialVersionUID = 5291242583321987938L;
	private Notice notice = new Notice();
	private Member member = new Member();
	private String validateCode;

	public String execute() throws Exception {
		GlobalChcontent(map);
		return SUCCESS;
	}
	
	public String registering() throws Exception {
		//是否禁止注册
		Config funcRegister = sconfig.findByProperty("funcRegister");
		if (null != funcRegister && null != funcRegister.getValue() && funcRegister.getValue().equals("enable")) {
			notice.setStatus(false);
			notice.setCode("Register_Disabled");
			notice.setTitle("提示：");
			notice.setBody("系统关闭了新用户注册，请稍候再试，或联系管理员。");
			return ERROR;
		}
		notice = smember.register(member, validateCode);
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
		email.setSubject("请激活您的账户");
		email.setHtmlMsg("<html><a href=\"http://localhost:8080/e6mall/activate.action?a="+member.getActivation()+"\">点击确认修改邮箱</a></html>");
		email.setTextMsg("您的邮箱不支持HTML邮件，您可以在浏览器中浏览以下网址：http://localhost:8080/e6mall/emailupdate.action?a="+member.getActivation()+" ，完成邮箱验证操作。");
		email.send();
		return notice;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String getValidateCode() {
		return validateCode;
	}

	public void setValidateCode(String validateCode) {
		this.validateCode = validateCode;
	}
}
