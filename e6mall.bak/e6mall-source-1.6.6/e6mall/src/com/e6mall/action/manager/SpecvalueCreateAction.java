package com.e6mall.action.manager;

import com.e6mall.model.Attachment;
import com.e6mall.model.Specitem;
import com.e6mall.model.Specvalue;

public class SpecvalueCreateAction extends BaseUploadAction {
	private static final long serialVersionUID = -810488010621392911L;
	private String si;
	private Specitem specitem;
	private Specvalue specvalue = new Specvalue();

	public String execute() throws Exception {
		specitem = sspecitem.findById(si);
		return SUCCESS;
	}
	
	public String create() throws Exception {
		specitem = sspecitem.findById(si);
		if (null != specitem) {
			specvalue.setId(getUuid());
			specvalue.setSpecitem(specitem);
			Attachment attachment = upload();
			specvalue.setImage(attachment);
			sspecvalue.save(specvalue);
		}
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

	public Specvalue getSpecvalue() {
		return specvalue;
	}

	public void setSpecvalue(Specvalue specvalue) {
		this.specvalue = specvalue;
	}
}
