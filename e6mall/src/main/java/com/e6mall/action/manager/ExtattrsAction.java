package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Restrictions;

import com.e6mall.model.Extattr;
import com.e6mall.model.Gstype;

public class ExtattrsAction extends BaseAction {
	private static final long serialVersionUID = 7089690007006689290L;
	private List list;
	private String[] checkbox;
	private String ge;
	private Gstype gstype;
	
	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Extattr.class);
		if (null != ge && !ge.equals("")) {
			dc.createCriteria("gstypes").add(Restrictions.eq("id", ge));
			gstype = sgstype.findById(ge);
		}
		dc.addOrder(Order.asc("alias"));
		list = sextattr.findAllByCriteria(dc);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Extattr extattr = sextattr.findById(checkbox[i]);
			if (null != extattr)
				sextattr.delete(extattr);
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

	public String getGe() {
		return ge;
	}

	public void setGe(String ge) {
		this.ge = ge;
	}

	public Gstype getGstype() {
		return gstype;
	}

	public void setGstype(Gstype gstype) {
		this.gstype = gstype;
	}
}
