package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Specitem;

public class SpecitemCreateAction extends BaseAction {
	private static final long serialVersionUID = 3344568235625544761L;
	private Specitem specitem = new Specitem();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		specitem.setId(getUuid());
		sspecitem.save(specitem);
		return SUCCESS;
	}

	public Specitem getSpecitem() {
		return specitem;
	}

	public void setSpecitem(Specitem specitem) {
		this.specitem = specitem;
	}
}
