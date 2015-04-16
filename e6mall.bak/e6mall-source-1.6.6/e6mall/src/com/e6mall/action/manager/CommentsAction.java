package com.e6mall.action.manager;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;

import com.e6mall.model.Comments;
import com.e6mall.utils.PaginationSupport;

public class CommentsAction extends BaseAction {
	private static final long serialVersionUID = -5511483979976097086L;
	private PaginationSupport ps;
	private int pagesize = 20;
	private int page = 1;
	private String keyword;
	private String[] checkbox;
	
	private String cm;
	private String status;

	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Comments.class);
		if(null != keyword)
			dc.add(Property.forName("content").like(keyword, MatchMode.ANYWHERE));
		dc.addOrder(Order.desc("cdate"));
		ps = scomments.findPageByCriteria(dc, pagesize, page);
		return SUCCESS;
	}
	
	public String update() throws Exception {
		if (null != cm && null != status) {
			Comments comments = scomments.findById(cm);
			comments.setStatus(status);
			scomments.merge(comments);
		}
		return SUCCESS;
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Comments comments = scomments.findById(checkbox[i]);
			if (null != comments)
				scomments.delete(comments);
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

	public String getCm() {
		return cm;
	}

	public void setCm(String cm) {
		this.cm = cm;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
