package com.e6mall.action.manager;

import com.e6mall.model.Attachment;
import com.e6mall.model.Paymode;

public class PaymodeCreateAction extends BaseUploadAction {
	private static final long serialVersionUID = -1719513740257862169L;
	private Paymode paymode = new Paymode();

	public String execute() throws Exception {
		return SUCCESS;
	}
	
	public String create() throws Exception {
		paymode.setId(getUuid());
		Attachment attachment = upload();
		paymode.setImage(attachment);
		spaymode.save(paymode);
		return SUCCESS;
	}

	public Paymode getPaymode() {
		return paymode;
	}

	public void setPaymode(Paymode paymode) {
		this.paymode = paymode;
	}
}
