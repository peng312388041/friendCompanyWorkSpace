package com.e6mall.action.member;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.District;
import com.e6mall.model.Lsarea;
import com.e6mall.model.Orderitem;
import com.e6mall.model.Staddress;
import com.e6mall.utils.PaginationSupport;

public class FreightSelAction extends BaseAction {
	private static final long serialVersionUID = -3023888036738736683L;
	private String str;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private List list;
	
	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
		dc.add(Property.forName("member").eq(getMsession()));
		dc.add(Property.forName("orders").isNull());
		ps = sorderitem.findPageByCriteria(dc, pagesize, page);
		
		Staddress staddress = sstaddress.findById(str);
		if (null != staddress) {
			District district = staddress.getDistrict();
			
			DetachedCriteria adc = DetachedCriteria.forClass(Lsarea.class);
			adc.add(Property.forName("district").eq(district));
			list = slsarea.findAllByCriteria(adc);
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

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}
}
