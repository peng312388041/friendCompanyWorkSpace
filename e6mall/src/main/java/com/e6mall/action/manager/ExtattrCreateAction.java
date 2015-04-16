package com.e6mall.action.manager;

import com.e6mall.model.Extattr;

public class ExtattrCreateAction extends BaseAction {
	private static final long serialVersionUID = -6092815732030842973L;
	private Extattr extattr = new Extattr();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		extattr.setId(getUuid());
		sextattr.save(extattr);
		return SUCCESS;
	}

	public Extattr getExtattr() {
		return extattr;
	}

	public void setExtattr(Extattr extattr) {
		this.extattr = extattr;
	}
}
