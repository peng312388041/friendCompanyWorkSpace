package com.e6mall.action.manager;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Member;
import com.e6mall.utils.PaginationSupport;

public class MembersAction extends BaseAction {
	private static final long serialVersionUID = 6904305339111226742L;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private String keyword;
	private String[] checkbox;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Member.class);
		if(null != keyword && !keyword.equals(""))
			dc.add(Property.forName("account").like(keyword));
		ps = smember.findPageByCriteria(dc, pagesize, page);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Member member = smember.findById(checkbox[i]);
			if (null != member)
				smember.delete(member);
		}
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

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
