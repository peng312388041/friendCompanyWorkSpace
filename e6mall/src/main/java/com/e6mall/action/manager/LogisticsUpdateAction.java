package com.e6mall.action.manager;

import com.e6mall.model.Attachment;
import com.e6mall.model.Logistics;

public class LogisticsUpdateAction extends BaseUploadAction {
	private static final long serialVersionUID = -6907220288570571363L;
	private String ls;
	private Logistics logistics;

	public String execute() throws Exception {
		logistics = slogistics.findById(ls);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Logistics ul = slogistics.findById(logistics.getId());
		ul.setName(logistics.getName());
		ul.setIntro(logistics.getIntro());
		ul.setUrl(logistics.getUrl());
		ul.setPourl(logistics.getPourl());
		ul.setCsort(logistics.getCsort());
		Attachment attachment = upload();
		Attachment oimage = ul.getImage();
		if (null != attachment)
			ul.setImage(attachment);
		slogistics.merge(ul);
		if (null != attachment && null != oimage)
			sattachment.delete(oimage);
		return SUCCESS;
	}

	public String getLs() {
		return ls;
	}

	public void setLs(String ls) {
		this.ls = ls;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}
}
