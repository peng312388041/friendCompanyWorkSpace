package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Eavalue;
import com.e6mall.model.Extattr;

public class EavalueCreateAction extends BaseAction {
	private static final long serialVersionUID = 4595366616348979265L;
	private String ea;
	private Extattr extattr;
	private Eavalue eavalue = new Eavalue();
	
	public String execute() throws Exception {
		extattr = sextattr.findById(ea);
		if (null != extattr) {
			eavalue.setId(getUuid());
			eavalue.setExtattr(extattr);
			seavalue.save(eavalue);
		}
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

	public Eavalue getEavalue() {
		return eavalue;
	}

	public void setEavalue(Eavalue eavalue) {
		this.eavalue = eavalue;
	}
}
