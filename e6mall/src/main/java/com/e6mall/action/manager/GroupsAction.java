package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;

public class GroupsAction extends BaseAction {
	private static final long serialVersionUID = 8597188110112659133L;
	private List list;
	private String gs;

	public String execute() throws Exception {
		list = sgroups.findAll();
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		sgroups.delete(gs);
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}
}
