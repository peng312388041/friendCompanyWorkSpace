package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Doccate;

public class DoccatesAction extends BaseAction {
	private static final long serialVersionUID = -5052343538519368870L;
	private String pc;
	private Doccate pdoccate;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Doccate.class);
		if (null != pc && !pc.equals("")) {
			pdoccate = sdoccate.findById(pc);
			dc.add(Property.forName("doccate").eq(pdoccate));
		} else {
			dc.add(Property.forName("doccate").isNull());
		}
		list = sdoccate.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Doccate doccate = sdoccate.findById(checkbox[i]);
			sdoccate.delete(doccate);
		}
		return SUCCESS;
	}

	public String getPc() {
		return pc;
	}

	public void setPc(String pc) {
		this.pc = pc;
	}

	public Doccate getPdoccate() {
		return pdoccate;
	}

	public void setPdoccate(Doccate pdoccate) {
		this.pdoccate = pdoccate;
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
