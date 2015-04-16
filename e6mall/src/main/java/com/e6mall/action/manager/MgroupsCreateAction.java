package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Mgroups;

public class MgroupsCreateAction extends BaseAction {
	private static final long serialVersionUID = -3647604298329617209L;
	private Mgroups mgroups = new Mgroups();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		mgroups.setId(getUuid());
		smgroups.merge(mgroups);
		return SUCCESS;
	}

	public Mgroups getMgroups() {
		return mgroups;
	}

	public void setMgroups(Mgroups mgroups) {
		this.mgroups = mgroups;
	}
}
