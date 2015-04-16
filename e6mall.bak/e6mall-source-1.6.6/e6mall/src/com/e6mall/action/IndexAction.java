package com.e6mall.action;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.model.Category;
import com.e6mall.model.Goods;
import com.e6mall.utils.PaginationSupport;

public class IndexAction extends BaseAction {
	private static final long serialVersionUID = -3388537486076681798L;
	private List catelist;
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private String c;
	private Category category;
	private String keyword;

	public String execute() throws Exception {
		System.out.println(getDefLocale().getName());
		catelist = scategory.findAllTree(getDefLocale());
		int startIndex = 0;
		startIndex = (page-1)*pagesize;
		DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
		if(null != c && !c.equals("")) {
			category = scategory.findById(c);
			if (null != category) {
				Disjunction dis = Restrictions.disjunction();
				dis.add(Property.forName("category").eq(category));
				dc.createAlias("category", "c");
				dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
				dc.add(dis);
			}
		}
		if(null != keyword)
			dc.add(Property.forName("name").like(keyword, MatchMode.ANYWHERE));
		ps = sgoods.findPageByCriteria(dc, pagesize, startIndex);
		return SUCCESS;
	}

	public List getCatelist() {
		return catelist;
	}

	public void setCatelist(List catelist) {
		this.catelist = catelist;
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

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getKeyword() {
		return keyword;
	}

	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
}
