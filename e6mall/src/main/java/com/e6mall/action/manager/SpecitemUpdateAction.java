package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Specitem;

public class SpecitemUpdateAction extends BaseAction {
	private static final long serialVersionUID = 8749576590133113044L;
	private String si;
	private Specitem specitem;

	public String execute() throws Exception {
		specitem = sspecitem.findById(si);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Specitem usi = sspecitem.findById(specitem.getId());
		usi.setName(specitem.getName());
		usi.setRemark(specitem.getRemark());
		usi.setDtype(specitem.getDtype());
		usi.setDstyle(specitem.getDstyle());
		sspecitem.merge(usi);
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
}
