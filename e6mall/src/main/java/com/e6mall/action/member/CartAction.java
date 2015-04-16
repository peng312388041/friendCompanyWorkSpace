package com.e6mall.action.member;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Orderitem;
import com.e6mall.utils.PaginationSupport;

public class CartAction extends BaseAction {
	private static final long serialVersionUID = 1096921577211513190L;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private String[] checkbox;

	public String execute() throws Exception {
		int startIndex = 0;
		startIndex = (page-1)*pagesize;
		DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
		dc.add(Property.forName("member").eq(getMsession()));
		dc.add(Property.forName("orders").isNull());
		ps = sorderitem.findPageByCriteria(dc, pagesize, startIndex);
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

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
