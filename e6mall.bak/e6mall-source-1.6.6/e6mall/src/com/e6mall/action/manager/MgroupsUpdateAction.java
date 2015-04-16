package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Mgroups;

public class MgroupsUpdateAction extends BaseAction {
	private static final long serialVersionUID = 8993891956330524266L;
	private String mg;
	private Mgroups mgroups;

	public String execute() throws Exception {
		mgroups = smgroups.findById(mg);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Mgroups um = smgroups.findById(mgroups.getId());
		um.setName(mgroups.getName());
		um.setRemarks(mgroups.getRemarks());
		smgroups.merge(um);
		return SUCCESS;
	}

	public String getMg() {
		return mg;
	}

	public void setMg(String mg) {
		this.mg = mg;
	}

	public Mgroups getMgroups() {
		return mgroups;
	}

	public void setMgroups(Mgroups mgroups) {
		this.mgroups = mgroups;
	}
}
