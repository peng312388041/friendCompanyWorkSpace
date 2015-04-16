package com.e6mall.action.manager;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Member;
import com.e6mall.model.Staddress;

public class StaddressesAction extends BaseAction {
	private static final long serialVersionUID = 258066570351373259L;
	private String mb;
	private Member member;
	private String[] checkbox;

	public String execute() throws Exception {
		member = smember.findById(mb);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Staddress staddress = sstaddress.findById(checkbox[i]);
			sstaddress.delete(staddress);
		}
		return SUCCESS;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
