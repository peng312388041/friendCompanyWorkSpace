package com.e6mall.action.manager;

import com.e6mall.model.Attachment;
import com.e6mall.model.Logistics;

public class LogisticsCreateAction extends BaseUploadAction {
	private static final long serialVersionUID = -6123136668122513884L;
	private Logistics logistics = new Logistics();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		logistics.setId(getUuid());
		Attachment attachment = upload();
		logistics.setImage(attachment);
		slogistics.save(logistics);
		return SUCCESS;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
	}
}
