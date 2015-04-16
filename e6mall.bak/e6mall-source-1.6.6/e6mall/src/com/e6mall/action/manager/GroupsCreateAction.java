package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Groups;

public class GroupsCreateAction extends BaseAction {
	private static final long serialVersionUID = -7164511111530801035L;
	private Groups groups = new Groups();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		groups.setId(getUuid());
		sgroups.save(groups);
		return SUCCESS;
	}

	public Groups getGroups() {
		return groups;
	}

	public void setGroups(Groups groups) {
		this.groups = groups;
	}
}
