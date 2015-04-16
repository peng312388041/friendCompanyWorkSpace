package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Specitem;

public class SpecitemsAction extends BaseAction {
	private static final long serialVersionUID = 1919340915068386144L;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Specitem.class);
		list = sspecitem.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Specitem specitem = sspecitem.findById(checkbox[i]);
			if (null != specitem)
				sspecitem.delete(specitem);
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
