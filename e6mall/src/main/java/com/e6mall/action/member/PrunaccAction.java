package com.e6mall.action.member;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Member;
import com.e6mall.model.Prunacc;
import com.e6mall.utils.PaginationSupport;

public class PrunaccAction extends BaseAction {
	private static final long serialVersionUID = -8524111630027949075L;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private Member member;

	public String execute() throws Exception {
		member = smember.findById(getMsession().getId());
		int startIndex = 0;
		startIndex = (page-1)*pagesize;
		DetachedCriteria dc = DetachedCriteria.forClass(Prunacc.class);
		dc.add(Property.forName("points").eq(member.getPoints()));
		ps = sprunacc.findPageByCriteria(dc, pagesize, startIndex);
		return SUCCESS;
	}

	public PaginationSupport getPs() {
		return ps;
	}

	public void setPs(PaginationSupport ps) {
		this.ps = ps;
	}

	public int getPagesize() {
		return pagesize;
	}

	public void setPagesize(int pagesize) {
		this.pagesize = pagesize;
	}

	public int getPage() {
		return page;
	}

	public void setPage(int page) {
		this.page = page;
	}

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}
}
