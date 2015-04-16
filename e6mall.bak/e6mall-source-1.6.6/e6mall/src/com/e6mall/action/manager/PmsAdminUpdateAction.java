package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Permission;

public class PmsAdminUpdateAction extends BaseAction {
	private static final long serialVersionUID = -2999858463402799072L;
	private List permissionroot;
	private String pm;
	private Permission permission;

	public String execute() throws Exception {
		permissionroot = spermission.findAllRoot();
		permission = spermission.findById(pm);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Permission upm = spermission.findById(permission.getId());
		upm.setName(permission.getName());
		upm.setCode(permission.getCode());
		if (null != permission.getPermission() && !permission.getPermission().getId().equals("")) {
			upm.setPermission(permission.getPermission());
		} else {
			upm.setPermission(null);
		}
		spermission.merge(upm);
		return SUCCESS;
	}

	public List getPermissionroot() {
		return permissionroot;
	}

	public void setPermissionroot(List permissionroot) {
		this.permissionroot = permissionroot;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public Permission getPermission() {
		return permission;
	}

	public void setPermission(Permission permission) {
		this.permission = permission;
	}
}
