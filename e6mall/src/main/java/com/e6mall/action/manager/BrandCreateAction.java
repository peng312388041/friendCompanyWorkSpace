package com.e6mall.action.manager;

import com.e6mall.model.Attachment;
import com.e6mall.model.Brand;

public class BrandCreateAction extends BaseUploadAction {
	private static final long serialVersionUID = -9208576050533190761L;
	private Brand brand = new Brand();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		brand.setId(getUuid());
		Attachment attachment = upload();
		brand.setLogo(attachment);
		sbrand.save(brand);
		return SUCCESS;
	}

	public Brand getBrand() {
		return brand;
	}

	public void setBrand(Brand brand) {
		this.brand = brand;
	}
}
