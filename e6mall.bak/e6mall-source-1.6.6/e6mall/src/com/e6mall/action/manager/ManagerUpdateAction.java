package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Manager;

public class ManagerUpdateAction extends BaseAction {
	private static final long serialVersionUID = -913235014750262235L;
	private String mg;
	private Manager manager;

	public String execute() throws Exception {
		manager = smanager.findById(mg);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Manager um = smanager.findById(manager.getId());
		if (null != manager.getPassword() && !manager.getPassword().equals("")) {
			um.setPassword(manager.getPassword());
		}
		um.setStatus(manager.getStatus());
		um.setEmail(manager.getEmail());
		um.setName(manager.getName());
		um.setCtype(manager.getCtype());
		um.setNickname(manager.getNickname());
		um.setIdcard(manager.getIdcard());
		smanager.merge(um);
		return SUCCESS;
	}

	public String getMg() {
		return mg;
	}

	public void setMg(String mg) {
		this.mg = mg;
	}

	public Manager getManager() {
		return manager;
	}

	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
