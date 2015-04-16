package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Permission;

public class PmsAdminAction extends BaseAction {
	private static final long serialVersionUID = -1093219191758982409L;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		list = spermission.findAllRoot();
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Permission permission = spermission.findById(checkbox[i]);
			if (null != permission)
				spermission.delete(permission);
		}
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
