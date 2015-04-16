package com.e6mall.action.manager;

import java.io.PrintWriter;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Extattr;

public class ExtattrUpdateAction extends BaseAction {
	private static final long serialVersionUID = 7721235720061292814L;
	private String ea;
	private Extattr extattr;
	private String pvalue = "";

	public String execute() throws Exception {
		extattr = sextattr.findById(ea);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Extattr uea = sextattr.findById(extattr.getId());
		uea.setName(extattr.getName());
		uea.setAlias(extattr.getAlias());
		uea.setViewtype(extattr.getViewtype());
		uea.setDisplay(extattr.getDisplay());
		uea.setCsort(extattr.getCsort());
		sextattr.merge(uea);
		return SUCCESS;
	}
	
	public String updateDisplay() throws Exception {
		Extattr uea = sextattr.findById(ea);
		PrintWriter out = response.getWriter();
		if (pvalue.equals("yes") || pvalue.equals("no")) {
			uea.setDisplay(pvalue);
			sextattr.merge(uea);
			out.print(pvalue);
		} else {
			out.print("错误");
		}
		return null;
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

	public String getPvalue() {
		return pvalue;
	}

	public void setPvalue(String pvalue) {
		this.pvalue = pvalue;
	}
}
