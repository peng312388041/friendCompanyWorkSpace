package com.e6mall.action.member;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Staddress;
import com.e6mall.utils.Constants;

public class StaddressSetAction extends BaseAction {
	private static final long serialVersionUID = 4207669956049310455L;
	private String str;
	private Staddress staddress = new Staddress();

	public String execute() throws Exception {
		if (null != str && !str.equals("")) {
			staddress = sstaddress.findById(str);
			if (null != staddress) {
				setStr(staddress.getId());//转向
				return SUCCESS;
			} else {
				return ERROR;
			}
		} else if (null != staddress.getAddress() && !staddress.getAddress().equals("")) {
			staddress.setId(getUuid());
			staddress.setMember(getMsession());
			staddress.setStatus(Constants.NORMAL);
			staddress = sstaddress.merge(staddress);
			setStr(staddress.getId());//转向
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public Staddress getStaddress() {
		return staddress;
	}

	public void setStaddress(Staddress staddress) {
		this.staddress = staddress;
	}
}
