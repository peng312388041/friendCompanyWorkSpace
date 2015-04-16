package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;

public class MgroupsAction extends BaseAction {
	private static final long serialVersionUID = 7173172224827963766L;
	private List list;
	private String mg;

	public String execute() throws Exception {
		list = smgroups.findAll();
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		smgroups.delete(mg);
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getMg() {
		return mg;
	}

	public void setMg(String mg) {
		this.mg = mg;
	}
}
