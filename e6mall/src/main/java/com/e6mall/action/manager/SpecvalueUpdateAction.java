package com.e6mall.action.manager;

import com.e6mall.model.Attachment;
import com.e6mall.model.Specvalue;

public class SpecvalueUpdateAction extends BaseUploadAction {
	private static final long serialVersionUID = -6912652299778880254L;
	private String sv;
	private Specvalue specvalue;
	private String si;//转向

	public String execute() throws Exception {
		specvalue = sspecvalue.findById(sv);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Specvalue usv = sspecvalue.findById(specvalue.getId());
		usv.setName(specvalue.getName());
		Attachment attachment = upload();
		Attachment oimage = usv.getImage();
		if (null != attachment)
			usv.setImage(attachment);
		sspecvalue.merge(usv);
		if (null != attachment && null != oimage)
			sattachment.delete(oimage);
		setSi(usv.getSpecitem().getId());
		return SUCCESS;
	}

	public String getSv() {
		return sv;
	}

	public void setSv(String sv) {
		this.sv = sv;
	}

	public Specvalue getSpecvalue() {
		return specvalue;
	}

	public void setSpecvalue(Specvalue specvalue) {
		this.specvalue = specvalue;
	}

	public String getSi() {
		return si;
	}

	public void setSi(String si) {
		this.si = si;
	}
}
