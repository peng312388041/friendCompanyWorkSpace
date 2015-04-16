package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Eavalue;

public class EavaluesUpdateAction extends BaseAction {
	private static final long serialVersionUID = 4788146808513649483L;
	private List<Eavalue> eavalue;
	private String ea;//转向
	
	public String execute() throws Exception {
		for (int i=0; i<eavalue.size(); i++) {
			Eavalue evae = (Eavalue)eavalue.get(i);
			if (null != evae.getId()) {
				Eavalue uev = seavalue.findById(evae.getId());
				uev.setValue(evae.getValue());
				uev.setCsort(evae.getCsort());
				seavalue.merge(uev);
			}
		}
		return SUCCESS;
	}

	public List<Eavalue> getEavalue() {
		return eavalue;
	}

	public void setEavalue(List<Eavalue> eavalue) {
		this.eavalue = eavalue;
	}

	public String getEa() {
		return ea;
	}

	public void setEa(String ea) {
		this.ea = ea;
	}
}
