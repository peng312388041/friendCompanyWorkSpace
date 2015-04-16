package com.e6mall.action.manager;

import java.util.HashSet;
import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Brand;
import com.e6mall.model.Extattr;
import com.e6mall.model.Gstype;
import com.e6mall.model.Specitem;

public class GstypeCreateAction extends BaseAction {
	private static final long serialVersionUID = -8891633565834243505L;
	private List list;
	private List silist;
	private List ealist;
	private Gstype gstype = new Gstype();
	private String[] checkbox;
	private String[] sicheckbox;
	private String[] eacheckbox;

	public String execute() throws Exception {
		list = sbrand.findAll();
		silist = sspecitem.findAll();
		ealist = sextattr.findAll();
		return SUCCESS;
	}
	
	public String create() throws Exception {
		gstype.setId(getUuid());
		gstype = sgstype.merge(gstype);
		gstype.setBrands(new HashSet());
		if (null != checkbox && checkbox.length > 0) {
			for (int i=0; i<checkbox.length; i++) {
				Brand brand = sbrand.findById(checkbox[i]);
				gstype.getBrands().add(brand);
			}
		}
		gstype.setSpecitems(new HashSet());
		if (null != sicheckbox && sicheckbox.length > 0) {
			for (int i=0; i<sicheckbox.length; i++) {
				Specitem specitem = sspecitem.findById(sicheckbox[i]);
				gstype.getSpecitems().add(specitem);
			}
		}
		gstype.setExtattrs(new HashSet());
		if (null != eacheckbox && eacheckbox.length > 0) {
			for (int i=0; i<eacheckbox.length; i++) {
				Extattr extattr = sextattr.findById(eacheckbox[i]);
				gstype.getExtattrs().add(extattr);
			}
		}
		sgstype.merge(gstype);
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
