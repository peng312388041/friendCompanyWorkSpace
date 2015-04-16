package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.model.Attachment;
import com.e6mall.model.Doccate;
import com.e6mall.model.Document;

public class DocumentCreateAction extends BaseUploadAction {
	private static final long serialVersionUID = 4441440574722828123L;
	private List localelist;
	private List catelist;
	private String c;
	private Doccate doccate;
	private Document document = new Document();

	public String execute() throws Exception {
		localelist = slocale.findAll();
		catelist = sdoccate.findAllTree();
		if (null != c && !c.equals(""))
			doccate = sdoccate.findById(c);
		return SUCCESS;
	}
	
	public String create() throws Exception {
		document.setId(getUuid());
		document.setCdate(getTimestamp());
		document.setManager(getAsession());
		document.setVistor(0);
		Attachment attachment = upload();
		document.setImage(attachment);
		sdocument.save(document);
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

	public Document getDocument() {
		return document;
	}

	public void setDocument(Document document) {
		this.document = document;
	}
}
