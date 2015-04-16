package com.e6mall.action.member;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Member;
import com.e6mall.model.Orderitem;
import com.e6mall.utils.Notice;
import com.e6mall.utils.PaginationSupport;

public class StaddressSelAction extends BaseAction {
	private static final long serialVersionUID = -1005270366323881607L;
	private Notice notice = new Notice();
	private PaginationSupport ps;
	private int pagesize = 12;
	private int page = 1;
	private Member member;
	private List districtroot;
	
	public String execute() throws Exception {
		DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
		dc.add(Property.forName("member").eq(getMsession()));
		dc.add(Property.forName("orders").isNull());
		ps = sorderitem.findPageByCriteria(dc, pagesize, page);
		if (null != ps.getItems() && ps.getItems().size()>0) {
			member = smember.findById(this.getMsession().getId());
			districtroot = sdistrict.findAllRoot();
			return SUCCESS;
		} else {
			notice.setStatus(false);
			notice.setCode("cart is null");
			notice.setTitle("提示：");
			notice.setBody("购物车中没有商品。");
			return "notice";
		}
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
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

	public Member getMember() {
		return member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	public List getDistrictroot() {
		return districtroot;
	}

	public void setDistrictroot(List districtroot) {
		this.districtroot = districtroot;
	}
}
