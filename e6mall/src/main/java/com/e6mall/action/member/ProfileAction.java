package com.e6mall.action.member;

import java.util.List;

import com.e6mall.action.manager.BaseUploadAction;
import com.e6mall.model.Attachment;
import com.e6mall.model.Member;

public class ProfileAction extends BaseUploadAction {
	private static final long serialVersionUID = 3229810347477162110L;
	private List districtroot;
	private Member member;

	public String execute() throws Exception {
		member = smember.findById(getMsession().getId());
		return SUCCESS;
	}
	
	public String edit() throws Exception {
		member = smember.findById(getMsession().getId());
		districtroot = sdistrict.findAllRoot();
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Member um = smember.findById(getMsession().getId());
		um.setAddress(member.getAddress());
		if (null != member.getDistrict())
			um.setDistrict(member.getDistrict());
		um.setIdcard(member.getIdcard());
		//um.setMobile(member.getMobile());		//手机将作为登录凭证
		um.setMsn(member.getMsn());
		//um.setName(member.getName());
		um.setNickname(member.getNickname());
		um.setPostcode(member.getPostcode());
		um.setQq(member.getQq());
		um.setTelephone(member.getTelephone());
		Attachment attachment = upload();
		Attachment oimage = um.getImage();
		if (null != attachment)
			um.setImage(attachment);
		smember.merge(um);
		if (null != attachment && null != oimage)
			sattachment.delete(oimage);
		return SUCCESS;
	}

	public List getDistrictroot() {
		return districtroot;
	}

	public void setDistrictroot(List districtroot) {
		this.districtroot = districtroot;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
