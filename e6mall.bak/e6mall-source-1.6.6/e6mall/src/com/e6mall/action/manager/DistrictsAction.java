package com.e6mall.action.manager;

import java.util.List;

public class DistrictsAction extends BaseAction {
	private static final long serialVersionUID = -1060035352162720990L;
	private List list;

	public String execute() throws Exception {
		list = sdistrict.findAllRoot();
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
