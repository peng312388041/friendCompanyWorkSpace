package com.e6mall.action.manager;

import com.e6mall.model.Attachment;
import com.e6mall.model.Brand;

public class BrandUpdateAction extends BaseUploadAction {
	private static final long serialVersionUID = -4657548979204381891L;
	private String bd;
	private Brand brand;

	public String execute() throws Exception {
		brand = sbrand.findById(bd);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Brand ubd = sbrand.findById(brand.getId());
		ubd.setName(brand.getName());
		ubd.setAlias(brand.getAlias());
		ubd.setIntro(brand.getIntro());
		ubd.setUrl(brand.getUrl());
		ubd.setCsort(brand.getCsort());
		Attachment attachment = upload();
		Attachment ologo = ubd.getLogo();
		if (null != attachment)
			ubd.setLogo(attachment);
		sbrand.merge(ubd);
		if (null != attachment && null != ologo)
			sattachment.delete(ologo);
		return SUCCESS;
	}

	public String getBd() {
		return bd;
	}

	public void setBd(String bd) {
		this.bd = bd;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
