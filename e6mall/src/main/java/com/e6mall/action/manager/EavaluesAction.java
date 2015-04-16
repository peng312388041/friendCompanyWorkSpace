package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Eavalue;
import com.e6mall.model.Extattr;

public class EavaluesAction extends BaseAction {
	private static final long serialVersionUID = -2155161874597129768L;
	private String ea;
	private Extattr extattr;
	private List list;
	private String ev;
	
	public String execute() throws Exception {
		extattr = sextattr.findById(ea);
		DetachedCriteria dc = DetachedCriteria.forClass(Eavalue.class);
		dc.add(Property.forName("extattr").eq(extattr));
		dc.addOrder(Order.asc("csort"));
		list = seavalue.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		Eavalue eavalue = seavalue.findById(ev);
		if (null != eavalue)
			seavalue.delete(eavalue);
		return SUCCESS;
	}

	public String getEa() {
		return ea;
	}

	public void setEa(String ea) {
		this.ea = ea;
	}

	public Extattr getExtattr() {
		return extattr;
	}

	public void setExtattr(Extattr extattr) {
		this.extattr = extattr;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public String getEv() {
		return ev;
	}

	public void setEv(String ev) {
		this.ev = ev;
	}
}
