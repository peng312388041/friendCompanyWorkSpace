package com.e6mall.action.manager;

import java.util.Date;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.model.Brunacc;
import com.e6mall.utils.PaginationSupport;

public class PayinGetoutAction extends BaseAction {
	private static final long serialVersionUID = 3065662145730395148L;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private Date min;
	private Date max;
	
	private String bra;
	private Brunacc brunacc = new Brunacc();
	
	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Brunacc.class);
		if (null != min && null != max)
			dc.add(Property.forName("ctime").between(min, max));
		ps = sbrunacc.findPageByCriteria(dc, pagesize, page);
		return SUCCESS;
	}
	
	public String view() throws Exception {
		brunacc = sbrunacc.findById(bra);
		return SUCCESS;
	}
	
	public String audit() throws Exception {
		Brunacc ubrun = sbrunacc.findById(brunacc.getId());
		ubrun.setMremarks(brunacc.getMremarks());
		ubrun.setStatus(brunacc.getStatus());
		ubrun.setManager(getAsession());
		sbrunacc.merge(ubrun);
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

	public Date getMin() {
		return min;
	}

	public void setMin(Date min) {
		this.min = min;
	}

	public Date getMax() {
		return max;
	}

	public void setMax(Date max) {
		this.max = max;
	}

	public String getBra() {
		return bra;
	}

	public void setBra(String bra) {
		this.bra = bra;
	}

	public Brunacc getBrunacc() {
		return brunacc;
	}

	public void setBrunacc(Brunacc brunacc) {
		this.brunacc = brunacc;
	}
}
