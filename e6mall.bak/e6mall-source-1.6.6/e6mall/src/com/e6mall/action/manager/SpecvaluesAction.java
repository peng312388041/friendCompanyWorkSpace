package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Specitem;
import com.e6mall.model.Specvalue;

public class SpecvaluesAction extends BaseAction {
	private static final long serialVersionUID = 3924680014596450574L;
	private String si;
	private Specitem specitem;
	private List list;
	private String[] checkbox;
	
	public String execute() throws Exception {
		specitem = sspecitem.findById(si);
		DetachedCriteria dc = DetachedCriteria.forClass(Specvalue.class);
		dc.add(Property.forName("specitem").eq(specitem));
		list = sspecvalue.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Specvalue specvalue = sspecvalue.findById(checkbox[i]);
			if (null != specvalue) {
				sspecvalue.delete(specvalue);
			}
		}
		return SUCCESS;
	}

	public String getSi() {
		return si;
	}

	public void setSi(String si) {
		this.si = si;
	}

	public Specitem getSpecitem() {
		return specitem;
	}

	public void setSpecitem(Specitem specitem) {
		this.specitem = specitem;
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
