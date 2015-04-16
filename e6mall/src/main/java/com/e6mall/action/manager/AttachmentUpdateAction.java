package com.e6mall.action.manager;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Attachment;

public class AttachmentUpdateAction extends BaseAction {
	private static final long serialVersionUID = 962502724640738488L;
	private String am;
	private Attachment attachment;
	private String gs;//转向商品
	private String doc;//转向文章

	public String execute() throws Exception {
		attachment = sattachment.findById(am);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Attachment ua = sattachment.findById(attachment.getId());
		ua.setDetails(attachment.getDetails());
		ua.setUrl(attachment.getUrl());
		if (null != attachment.getStatus() && (attachment.getStatus().equals("default") || attachment.getStatus().equals("normal"))) {
			ua.setStatus(attachment.getStatus());
		}
		ua.setSort(attachment.getSort());
		sattachment.merge(ua);
		//转向
		if (null != ua.getDocument()) {
			setDoc(ua.getDocument().getId());
			return "document";
		} else {
			setGs(ua.getGoods().getId());
			return SUCCESS;
		}
	}

	public String getAm() {
		return am;
	}

	public void setAm(String am) {
		this.am = am;
	}

	public Attachment getAttachment() {
		return attachment;
	}

	public void setAttachment(Attachment attachment) {
		this.attachment = attachment;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getDoc() {
		return doc;
	}

	public void setDoc(String doc) {
		this.doc = doc;
	}
}
