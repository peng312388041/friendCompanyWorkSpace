package com.e6mall.action.manager;

import com.e6mall.model.Member;
import com.e6mall.utils.Notice;

public class MemberPasswordAction extends BaseAction {
	private static final long serialVersionUID = 2803783894393820588L;
	private String mb;
	private Member member;
	private String password;
	private Notice notice = new Notice();

	public String execute() throws Exception {
		member = smember.findById(mb);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Member um = smember.findById(mb);
		if (null != password && !password.equals("")) {
			um.setCpassword(password);//明文密码在模型内转换加密密码
			notice.setStatus(true);
			notice.setCode("success");
			notice.setTitle("密码设置成功");
			notice.setBody("密码设置成功。");
			smember.merge(um);
		} else {
			notice.setStatus(false);
			notice.setCode("member_password_null");
			notice.setTitle("密码不允许为空");
			notice.setBody("基于安全原因，不允许设置密码为空，请填写合适的密码。");
		}
		return "notice";
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}
}
