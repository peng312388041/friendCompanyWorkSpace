package com.e6mall.action.member;

import com.e6mall.action.BaseAction;

public class FreightSetAction extends BaseAction {
	private static final long serialVersionUID = 7218880390276112450L;
	private String str;
	private String ft;

	public String execute() throws Exception {
		System.out.println("str:"+str);
		System.out.println("ft:"+ft);
		return SUCCESS;
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getFt() {
		return ft;
	}

	public void setFt(String ft) {
		this.ft = ft;
	}
}
