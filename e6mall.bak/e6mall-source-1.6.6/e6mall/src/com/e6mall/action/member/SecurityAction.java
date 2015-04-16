package com.e6mall.action.member;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Member;

public class SecurityAction extends BaseAction {
	private static final long serialVersionUID = -1840003314657061429L;
	private Member member;

	public String execute() throws Exception {
		member = smember.findById(getMsession().getId());
		return SUCCESS;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
