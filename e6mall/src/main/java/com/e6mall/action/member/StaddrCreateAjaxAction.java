package com.e6mall.action.member;

import org.apache.struts2.json.annotations.JSON;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Staddress;
import com.e6mall.utils.Constants;
import com.mysql.jdbc.StringUtils;

public class StaddrCreateAjaxAction extends BaseAction {
	private static final long serialVersionUID = 6883686583140225858L;
	private Staddress staddress = new Staddress();
	private String result = "error";

	public String execute() throws Exception {
		if (!StringUtils.isNullOrEmpty(staddress.getAddress())
				&& !StringUtils.isNullOrEmpty(staddress.getName())
				&& !StringUtils.isNullOrEmpty(staddress.getTelephone())
				//&& null != staddress.getDistrict()) {	//可不选择地区
				) {
			staddress.setId(getUuid());
			staddress.setMember(getMsession());
			staddress.setStatus(Constants.NORMAL);
			sstaddress.save(staddress);
			result = "success";
		}
		return SUCCESS;
	}

	@JSON(serialize = false)
	public Staddress getStaddress() {
		return staddress;
	}

	public void setStaddress(Staddress staddress) {
		this.staddress = staddress;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
