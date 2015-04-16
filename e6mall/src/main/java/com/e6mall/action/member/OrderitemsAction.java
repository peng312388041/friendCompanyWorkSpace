package com.e6mall.action.member;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Orderitem;
import com.e6mall.model.Orders;
import com.e6mall.utils.PaginationSupport;

public class OrderitemsAction extends BaseAction {
	private static final long serialVersionUID = 4927408896047700846L;
	private String os;
	private Orders orders;
	private PaginationSupport ps;
	private int pagesize = 20;
	private int page = 1;

	public String execute() throws Exception {
		orders = sorders.findById(os);
		DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
		dc.add(Property.forName("member").eq(getMsession()));
		dc.add(Property.forName("orders").eq(orders));
		ps = sorderitem.findPageByCriteria(dc, pagesize, page);
		return SUCCESS;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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
}
