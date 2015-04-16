package com.e6mall.action.manager;

import com.e6mall.model.Member;

public class MemberCreateAction extends BaseAction {
	private static final long serialVersionUID = -1546617973287870520L;
	private Member member = new Member();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		smember.save(member);
		return SUCCESS;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
