package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Disjunction;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Category;
import com.e6mall.model.Goods;
import com.e6mall.utils.PaginationSupport;

public class GoodsAction extends BaseAction {
	private static final long serialVersionUID = -8099669990505849065L;
	private String od = "";
	private String sc = "desc";
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private String c;
	private Category category;
	private String keyword;
	private String[] checkbox;
	private List catelist;

	public String execute() throws Exception {
		catelist = scategory.findAllTree();
		DetachedCriteria dc = DetachedCriteria.forClass(Goods.class);
		if(null != keyword)
			dc.add(Property.forName("name").like(keyword, MatchMode.ANYWHERE));
		if (null != c && !c.equals("")) {
			category = scategory.findById(c);
			if (null != category) {
				Disjunction dis = Restrictions.disjunction();
				dis.add(Property.forName("category").eq(category));
				dc.createAlias("category", "c");
				dis.add(Restrictions.like("c.nodepath", category.getId(), MatchMode.ANYWHERE));
				dc.add(dis);
			}
		}
		if (!od.equals("")) {
			if (sc.equals("asc")) {
				dc.addOrder(Property.forName(od).asc());
			} else {
				dc.addOrder(Property.forName(od).desc());
			}
		} else {
			dc.addOrder(Order.desc("ctime"));
			dc.addOrder(Order.desc("utime"));
			dc.addOrder(Order.asc("csort"));
		}
		try {
			ps = sgoods.findPageByCriteria(dc, pagesize, page);
		}catch(Exception e){	//如果自定义排序字段错误，将重新构建查询语句。
			dc = DetachedCriteria.forClass(Goods.class);
			if(null != keyword)
				dc.add(Property.forName("name").like(keyword, MatchMode.ANYWHERE));
			if (null != c && !c.equals("")) {
				category = scategory.findById(c);
				if (null != category)
					dc.add(Property.forName("category").eq(category));
			}
			ps = sgoods.findPageByCriteria(dc, pagesize, page);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Goods goods = sgoods.findById(checkbox[i]);
			sgoods.delete(goods);
		}
		return SUCCESS;
	}

	public String getOd() {
		return od;
	}

	public void setOd(String od) {
		this.od = od;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
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
