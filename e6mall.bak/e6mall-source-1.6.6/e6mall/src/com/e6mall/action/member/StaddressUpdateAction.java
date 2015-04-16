package com.e6mall.action.member;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Staddress;

public class StaddressUpdateAction extends BaseAction {
	private static final long serialVersionUID = -3366379141791134007L;
	private String str;
	private Staddress staddress;

	public String execute() throws Exception {
		staddress = sstaddress.findById(str);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Staddress ustr = sstaddress.findById(staddress.getId());
		if (null != ustr) {
			ustr.setAddress(staddress.getAddress());
			ustr.setPostcode(staddress.getPostcode());
			ustr.setTelephone(staddress.getTelephone());
			ustr.setMobile(staddress.getMobile());
			ustr.setName(staddress.getName());
			sstaddress.merge(ustr);
		}
		return SUCCESS;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Staddress getStaddress() {
		return staddress;
	}

	public void setStaddress(Staddress staddress) {
		this.staddress = staddress;
	}
}
