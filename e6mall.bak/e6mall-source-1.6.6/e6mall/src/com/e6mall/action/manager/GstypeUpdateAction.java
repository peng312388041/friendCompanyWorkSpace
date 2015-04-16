package com.e6mall.action.manager;

import java.util.HashSet;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Brand;
import com.e6mall.model.Extattr;
import com.e6mall.model.Gstype;
import com.e6mall.model.Specitem;

public class GstypeUpdateAction extends BaseAction {
	private static final long serialVersionUID = -603883545066651910L;
	private List list;
	private List silist;
	private List ealist;
	private String ge;
	private Gstype gstype;
	private String[] checkbox;
	private String[] sicheckbox;
	private String[] eacheckbox;

	
	public String execute() throws Exception {
		gstype = sgstype.findById(ge);
		DetachedCriteria bdc = DetachedCriteria.forClass(Brand.class);
		bdc.addOrder(Order.asc("alias"));
		list = sbrand.findAllByCriteria(bdc);
		DetachedCriteria sdc = DetachedCriteria.forClass(Specitem.class);
		sdc.addOrder(Order.asc("remark"));
		silist = sspecitem.findAllByCriteria(sdc);
		DetachedCriteria edc = DetachedCriteria.forClass(Extattr.class);
		edc.addOrder(Order.asc("alias"));
		ealist = sextattr.findAllByCriteria(edc);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Gstype ugt = sgstype.findById(gstype.getId());
		ugt.setName(gstype.getName());
		ugt.setAlias(gstype.getAlias());
		ugt = sgstype.merge(ugt);
		ugt.setBrands(new HashSet());
		if (null != checkbox && checkbox.length > 0) {
			for (int i=0; i<checkbox.length; i++) {
				Brand brand = sbrand.findById(checkbox[i]);
				ugt.getBrands().add(brand);
			}
		}
		ugt.setSpecitems(new HashSet());
		if (null != sicheckbox && sicheckbox.length > 0) {
			for (int i=0; i<sicheckbox.length; i++) {
				Specitem specitem = sspecitem.findById(sicheckbox[i]);
				ugt.getSpecitems().add(specitem);
			}
		}
		ugt.setExtattrs(new HashSet());
		if (null != eacheckbox && eacheckbox.length > 0) {
			for (int i=0; i<eacheckbox.length; i++) {
				Extattr extattr = sextattr.findById(eacheckbox[i]);
				ugt.getExtattrs().add(extattr);
			}
		}
		sgstype.merge(ugt);
		return SUCCESS;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List getSilist() {
		return silist;
	}

	public void setSilist(List silist) {
		this.silist = silist;
	}

	public List getEalist() {
		return ealist;
	}

	public void setEalist(List ealist) {
		this.ealist = ealist;
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

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}

	public String[] getSicheckbox() {
		return sicheckbox;
	}

	public void setSicheckbox(String[] sicheckbox) {
		this.sicheckbox = sicheckbox;
	}

	public String[] getEacheckbox() {
		return eacheckbox;
	}

	public void setEacheckbox(String[] eacheckbox) {
		this.eacheckbox = eacheckbox;
	}
}
