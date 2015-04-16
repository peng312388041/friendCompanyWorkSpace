package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Doccate;
import com.e6mall.model.Document;
import com.e6mall.utils.PaginationSupport;

public class DocumentsAction extends BaseAction {
	private static final long serialVersionUID = -1518007251233211832L;
	private PaginationSupport ps;
	private int pagesize = 20;
	private int page = 1;
	private String c;
	private Doccate doccate;
	private String keyword;
	private String[] checkbox;
	private List catelist;

	public String execute() throws Exception {
		catelist = sdoccate.findAllTree();
		DetachedCriteria dc = DetachedCriteria.forClass(Document.class);
		if(null != keyword)
			dc.add(Property.forName("title").like(keyword, MatchMode.ANYWHERE));
		if (null != c && !c.equals("")) {
			doccate = sdoccate.findById(c);
			if (null != doccate)
				dc.add(Property.forName("doccate").eq(doccate));
		}
		dc.addOrder(Order.desc("cdate"));
		ps = sdocument.findPageByCriteria(dc, pagesize, page);
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Document doc = sdocument.findById(checkbox[i]);
			if (null != doc)
				sdocument.delete(doc);
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

	public String getC() {
		return c;
	}

	public void setC(String c) {
		this.c = c;
	}

	public Doccate getDoccate() {
		return doccate;
	}

	public void setDoccate(Doccate doccate) {
		this.doccate = doccate;
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

	public List getCatelist() {
		return catelist;
	}

	public void setCatelist(List catelist) {
		this.catelist = catelist;
	}
}
