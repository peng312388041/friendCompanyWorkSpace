package com.e6mall.action.member;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Orders;
import com.e6mall.utils.COrders;
import com.e6mall.utils.PaginationSupport;

public class OrdersAction extends BaseAction {
	private static final long serialVersionUID = 1707526188501125175L;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	
	private String os;
	private Orders orders;

	public String execute() throws Exception {
		int startIndex = 0;
		startIndex = (page-1)*pagesize;
		DetachedCriteria dc = DetachedCriteria.forClass(Orders.class);
		dc.add(Property.forName("member").eq(getMsession()));
		dc.addOrder(Order.desc("ctime"));
		ps = sorders.findPageByCriteria(dc, pagesize, startIndex);
		return SUCCESS;
	}
	
	public String view() throws Exception {
		orders = sorders.findById(os);
		return SUCCESS;
	}
	
	public String delivered() throws Exception {
		orders = sorders.findById(os);
		orders.setStatus(COrders.TRADE_FINISHED);
		sorders.merge(orders);
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
}
