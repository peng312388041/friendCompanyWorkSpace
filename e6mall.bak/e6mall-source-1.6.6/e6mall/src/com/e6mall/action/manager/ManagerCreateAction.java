package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Manager;

public class ManagerCreateAction extends BaseAction {
	private static final long serialVersionUID = -1845035593513151395L;
	private Manager manager = new Manager();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		manager.setId(getUuid());
		manager.setLogincount(0);
		manager.setCtime(getTimestamp());
		smanager.save(manager);
		return SUCCESS;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
