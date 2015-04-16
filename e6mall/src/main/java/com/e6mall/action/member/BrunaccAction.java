package com.e6mall.action.member;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Brunacc;

public class BrunaccAction extends BaseAction {
	private static final long serialVersionUID = 9037312733692061875L;
	private String bra;
	private Brunacc brunacc;

	public String execute() throws Exception {
		brunacc = sbrunacc.findById(bra);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		Brunacc brunacc = sbrunacc.findById(bra);
		if (null != brunacc) {
			sbrunacc.delete(brunacc);
		}
		return SUCCESS;
	}

	public String getBra() {
		return bra;
	}

	public void setBra(String bra) {
		this.bra = bra;
	}

	public Brunacc getBrunacc() {
		return brunacc;
	}

	public void setBrunacc(Brunacc brunacc) {
		this.brunacc = brunacc;
	}
}
