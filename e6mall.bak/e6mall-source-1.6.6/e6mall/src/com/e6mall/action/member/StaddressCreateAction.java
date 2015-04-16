package com.e6mall.action.member;

import java.util.List;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Staddress;
import com.e6mall.utils.Constants;

public class StaddressCreateAction extends BaseAction {
	private static final long serialVersionUID = -5802403669713188124L;
	private Staddress staddress = new Staddress();
	private List districtroot;

	public String execute() throws Exception {
		districtroot = sdistrict.findAllRoot();
		return SUCCESS;
	}
	
	public String create() throws Exception {
		if (null != staddress.getId() && !staddress.getId().equals("")) {
			Staddress std = sstaddress.findById(staddress.getId());
			std.setAddress(staddress.getAddress());
			std.setDistrict(staddress.getDistrict());
			std.setMobile(staddress.getMobile());
			std.setName(staddress.getName());
			std.setPostcode(staddress.getPostcode());
			std.setTelephone(staddress.getTelephone());
			std.setStatus(staddress.getStatus());
			sstaddress.merge(std);
		} else {
			staddress.setId(getUuid());
			staddress.setMember(getMsession());
			staddress.setStatus(Constants.NORMAL);
			sstaddress.save(staddress);
		}
		return SUCCESS;
	}

	public Staddress getStaddress() {
		return staddress;
	}

	public void setStaddress(Staddress staddress) {
		this.staddress = staddress;
	}

	public List getDistrictroot() {
		return districtroot;
	}

	public void setDistrictroot(List districtroot) {
		this.districtroot = districtroot;
	}
}
