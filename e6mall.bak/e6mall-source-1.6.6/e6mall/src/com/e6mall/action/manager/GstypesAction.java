package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Gstype;

public class GstypesAction extends BaseAction {
	private static final long serialVersionUID = -2919177837901751384L;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Gstype.class);
		list = sgstype.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Gstype gstype = sgstype.findById(checkbox[i]);
			sgstype.delete(gstype);
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
