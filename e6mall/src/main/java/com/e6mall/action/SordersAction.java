package com.e6mall.action;

import java.util.List;

import com.e6mall.model.Member;

public class SordersAction extends BaseAction {
	private static final long serialVersionUID = -5711993706707364694L;
	private Member member;
	private List districtroot;	//可选择的顶级地区
	
	private List freightList;
	private List paymodeList;
	private List staddressList;

	public String execute() throws Exception {
		GlobalChcontent(map);
		if (null != this.getMsession()) {
			member = smember.findById(this.getMsession().getId());
			districtroot = sdistrict.findAllRoot();
			paymodeList = spaymode.findAll();
			return SUCCESS;
		} else {
			return "login";
		}
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List getDistrictroot() {
		return districtroot;
	}

	public void setDistrictroot(List districtroot) {
		this.districtroot = districtroot;
	}

	public List getFreightList() {
		return freightList;
	}

	public void setFreightList(List freightList) {
		this.freightList = freightList;
	}

	public List getPaymodeList() {
		return paymodeList;
	}

	public void setPaymodeList(List paymodeList) {
		this.paymodeList = paymodeList;
	}

	public List getStaddressList() {
		return staddressList;
	}

	public void setStaddressList(List staddressList) {
		this.staddressList = staddressList;
	}
}
