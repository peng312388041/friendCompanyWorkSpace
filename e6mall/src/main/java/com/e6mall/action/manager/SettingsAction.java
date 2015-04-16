package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Setting;

public class SettingsAction extends BaseAction {
	private static final long serialVersionUID = -7451032612451759670L;
	private List list;
	private String[] checkbox;
	private String pm;

	public String execute() throws Exception {
		list = ssetting.findAll();
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Setting setting = ssetting.findById(checkbox[i]);
			if (null != setting) {
				ssetting.delete(setting);
			}
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

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}
}
