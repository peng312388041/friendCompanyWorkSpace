package com.e6mall.action.member;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Member;
import com.e6mall.utils.CMember;
import com.e6mall.utils.Notice;

public class PasswordAction extends BaseAction {
	private static final long serialVersionUID = -4326837009671086719L;
	private Notice notice = new Notice();
	private String password;

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String change() throws Exception {
		Member member = smember.findById(getMsession().getId());
		member.setCpassword(password);
		smember.merge(member);
		notice.setStatus(true);
		notice.setCode(CMember.NOTICE_CHOK_CODE);
		notice.setTitle(CMember.NOTICE_CHOK_TITLE);
		notice.setBody(CMember.NOTICE_CHOK_BODY);
		return SUCCESS;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}
