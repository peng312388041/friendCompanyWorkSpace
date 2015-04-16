package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Groups;

public class GroupsUpdateAction extends BaseAction {
	private static final long serialVersionUID = -6214402688940090339L;
	private String gs;
	private Groups groups;

	public String execute() throws Exception {
		groups = sgroups.findById(gs);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Groups ug = sgroups.findById(groups.getId());
		ug.setName(groups.getName());
		ug.setDiscount(groups.getDiscount());
		ug.setIsdefault(groups.getIsdefault());
		ug.setRequirepoints(groups.getRequirepoints());
		ug.setRemarks(groups.getRemarks());
		sgroups.merge(ug);
		return SUCCESS;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}
}
