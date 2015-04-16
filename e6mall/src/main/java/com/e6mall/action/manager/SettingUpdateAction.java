package com.e6mall.action.manager;

import java.io.PrintWriter;

import com.e6mall.model.Setting;

public class SettingUpdateAction extends BaseAction {
	private static final long serialVersionUID = -7190962557654526813L;
	private String st;
	private String pvalue;

	public String execute() throws Exception {
		try {
			Setting setting = ssetting.findById(st);
			setting.setValue(pvalue);
			ssetting.merge(setting);
			PrintWriter out = response.getWriter();   
		    out.print(pvalue);
		} catch (NullPointerException e) {
		}
		return null;
	}

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		this.st = st;
	}

	public String getPvalue() {
		return pvalue;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
}
