package com.e6mall.action.manager;

import java.util.HashSet;
import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Gstype;
import com.e6mall.model.Specitem;

public class GstypeSpecitemUpdateAction extends BaseAction {
	private static final long serialVersionUID = -1829701346600379754L;
	private String ge;
	private Gstype gstype;
	private List list;
	private String[] checkbox;

	public String execute() throws Exception {
		gstype = sgstype.findById(ge);
		list = sspecitem.findAll();
		return SUCCESS;
	}
	
	public String update() throws Exception {
		gstype = sgstype.findById(ge);
		gstype.setSpecitems(new HashSet());
		for (int i=0; i<checkbox.length; i++) {
			Specitem specitem = sspecitem.findById(checkbox[i]);
			gstype.getSpecitems().add(specitem);
		}
		sgstype.merge(gstype);
		return SUCCESS;
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
