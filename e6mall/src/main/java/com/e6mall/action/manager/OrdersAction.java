package com.e6mall.action.manager;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Orders;
import com.e6mall.utils.PaginationSupport;

public class OrdersAction extends BaseAction {
	private static final long serialVersionUID = -8927704307776250257L;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private String[] checkbox;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Orders.class);
		dc.addOrder(Order.desc("status"));
		dc.addOrder(Order.desc("ctime"));
		ps = sorders.findPageByCriteria(dc, pagesize, page);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Orders orders = sorders.findById(checkbox[i]);
			if (null != orders)
				sorders.delete(orders);
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

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
