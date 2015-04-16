package com.e6mall.action.manager;

import org.hibernate.criterion.DetachedCriteria;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Logistics;
import com.e6mall.utils.PaginationSupport;

public class LogisticsAction extends BaseAction {
	private static final long serialVersionUID = 9033814980130168971L;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private String[] checkbox;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Logistics.class);
		ps = slogistics.findPageByCriteria(dc, pagesize, page);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Logistics logistics = slogistics.findById(checkbox[i]);
			if (null != logistics)
				slogistics.delete(logistics);
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
