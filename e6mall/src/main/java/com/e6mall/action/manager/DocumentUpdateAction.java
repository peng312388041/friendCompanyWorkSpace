package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Attachment;
import com.e6mall.model.Doccate;
import com.e6mall.model.Document;

public class DocumentUpdateAction extends BaseUploadAction {
	private static final long serialVersionUID = -2147127631817742868L;
	private List localelist;
	private List catelist;
	private String c;
	private Doccate doccate;
	private String d;
	private Document document;

	public String execute() throws Exception {
		localelist = slocale.findAll();
		catelist = sdoccate.findAllTree();
		document = sdocument.findById(d);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		if (!document.getId().equals("")) {
			Document udm = sdocument.findById(document.getId());
			udm.setBrief(document.getBrief());
			udm.setContent(document.getContent());
			udm.setCsort(document.getCsort());
			udm.setDoccate(document.getDoccate());
			udm.setLocale(document.getLocale());
			udm.setManager(getAsession());
			udm.setMarker(document.getMarker());
			udm.setTitle(document.getTitle());
			
			Attachment attachment = upload();
			Attachment oimage = udm.getImage();
			if (null != attachment)
				udm.setImage(attachment);
			sdocument.merge(udm);
			if (null != attachment && null != oimage)
				sattachment.delete(oimage);
		}
		return SUCCESS;
	}

	public List getLocalelist() {
		return localelist;
	}

	public void setLocalelist(List localelist) {
		this.localelist = localelist;
	}

	public List getCatelist() {
		return catelist;
	}

	public void setCatelist(List catelist) {
		this.catelist = catelist;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Doccate getDoccate() {
		return doccate;
	}

	public void setDoccate(Doccate doccate) {
		this.doccate = doccate;
	}

	public String getD() {
		return d;
	}

	public void setD(String d) {
		this.d = d;
	}

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
