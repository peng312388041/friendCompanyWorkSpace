package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import com.e6mall.model.Logistics;
import com.e6mall.model.Lsarea;
import com.e6mall.utils.PaginationSupport;

public class LsareasAction extends BaseAction {
	private static final long serialVersionUID = 6784816975988245444L;
	private String ls;
	private Logistics logistics;
	private PaginationSupport ps;
	private int pagesize = 20;
	private int page = 1;
	private String la;
	private List districtroot;

	public String execute() throws Exception {
		logistics = slogistics.findById(ls);
		districtroot = sdistrict.findAllRoot();
		DetachedCriteria dc = DetachedCriteria.forClass(Lsarea.class);
		dc.createCriteria("logistics").add(Restrictions.eq("id", ls));
		ps = slsarea.findPageByCriteria(dc, pagesize, page);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		Lsarea lsarea = slsarea.findById(la);
		if (null != lsarea) {
			slsarea.delete(lsarea);
		}
		return SUCCESS;
	}

	public String getLs() {
		return ls;
	}

	public void setLs(String ls) {
		this.ls = ls;
	}

	public Logistics getLogistics() {
		return logistics;
	}

	public void setLogistics(Logistics logistics) {
		this.logistics = logistics;
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

	public String getLa() {
		return la;
	}

	public void setLa(String la) {
		this.la = la;
	}

	public List getDistrictroot() {
		return districtroot;
	}

	public void setDistrictroot(List districtroot) {
		this.districtroot = districtroot;
	}
}
