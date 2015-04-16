package com.e6mall.action.manager;

import java.util.List;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Member;

public class MemberUpdateAction extends BaseAction {
	private static final long serialVersionUID = -4025246843895266120L;
	private List groupslist;
	private String mb;
	private Member member;

	public String execute() throws Exception {
		groupslist = sgroups.findAll();
		member = smember.findById(mb);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Member um = smember.findById(member.getId());
		if (null != member.getPassword() && !member.getPassword().equals("")) {
			um.setPassword(member.getPassword());
		}
		//um.setStatus(member.getStatus());
		um.setEmail(member.getEmail());
		um.setName(member.getName());
		if (null != member.getGroups().getId() && !member.getGroups().getId().equals("")) {
			um.setGroups(member.getGroups());
		}
		um.setNickname(member.getNickname());
		um.setIdcard(member.getIdcard());
		um.setQq(member.getQq());
		um.setMsn(member.getMsn());
		um.setStatus(member.getStatus());
		smember.merge(um);
		return SUCCESS;
	}

	public List getGroupslist() {
		return groupslist;
	}

	public void setGroupslist(List groupslist) {
		this.groupslist = groupslist;
	}

	public String getMb() {
		return mb;
	}

	public void setMb(String mb) {
		this.mb = mb;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
