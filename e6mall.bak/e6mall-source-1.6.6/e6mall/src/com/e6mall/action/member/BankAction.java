package com.e6mall.action.member;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Bank;
import com.e6mall.model.Member;
import com.e6mall.model.Points;
import com.e6mall.utils.CMember;
import com.e6mall.utils.Notice;

public class BankAction extends BaseAction {
	private static final long serialVersionUID = 7479188563507438763L;
	private Notice notice = new Notice();
	private Member member;

	public String execute() throws Exception {
		member = smember.findById(getMsession().getId());
		return SUCCESS;
	}
	
	public String openaccount() throws Exception {
		member = smember.findById(getMsession().getId());
		if (null != member.getBank()) {
			notice.setStatus(false);
			notice.setCode(CMember.NOTICE_BANK_EXIST_CODE);
			notice.setTitle(CMember.NOTICE_BANK_EXIST_TITLE);
			notice.setBody(CMember.NOTICE_BANK_EXIST_BODY);
			return ERROR;
		} else {
			Bank bank = sbank.openaccount();
			member.setBank(bank);
			Points points = spoints.openaccount();
			member.setPoints(points);
			member = smember.merge(member);
			return SUCCESS;
		}
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
}
