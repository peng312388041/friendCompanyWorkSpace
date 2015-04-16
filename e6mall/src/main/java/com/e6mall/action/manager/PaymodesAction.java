package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Paymode;

public class PaymodesAction extends BaseAction {
	private static final long serialVersionUID = 844686116734641074L;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		list = spaymode.findAll();
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Paymode paymode = spaymode.findById(checkbox[i]);
			spaymode.delete(paymode);
		}
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
