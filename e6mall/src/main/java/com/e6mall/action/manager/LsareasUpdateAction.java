package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Lsarea;

public class LsareasUpdateAction extends BaseAction {
	private static final long serialVersionUID = 8437341050040486352L;
	private List<Lsarea> lsarea;
	private String ls;//转向

	public String execute() throws Exception {
		for (int i=0; i<lsarea.size(); i++) {
			Lsarea lsa = (Lsarea)lsarea.get(i);
			if (null != lsa.getId()) {
				Lsarea uls = slsarea.findById(lsa.getId());
				uls.setWfirst(lsa.getWfirst());
				uls.setWfcost(lsa.getWfcost());
				uls.setWappend(lsa.getWappend());
				uls.setWacost(lsa.getWacost());
				uls.setCod(lsa.getCod());
				slsarea.merge(uls);
				setLs(uls.getLogistics().getId());
			}
		}
		return SUCCESS;
	}

	public List<Lsarea> getLsarea() {
		return lsarea;
	}

	public void setLsarea(List<Lsarea> lsarea) {
		this.lsarea = lsarea;
	}

	public String getLs() {
		return ls;
	}

	public void setLs(String ls) {
		this.ls = ls;
	}
}
