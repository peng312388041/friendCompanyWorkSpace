package com.e6mall.action.manager;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.model.District;
import com.e6mall.model.Orderitem;
import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.utils.Notice;
import com.e6mall.utils.PaginationSupport;

public class OrdersUpdateAction extends BaseAction {
	private static final long serialVersionUID = -8144178724484955666L;
	private Notice notice = new Notice();
	private String os;
	private Orders orders;
	private PaginationSupport ps;
	private int pagesize = 20;
	private int page = 1;
	private List lsarealist = new ArrayList();
	private List paymodelist;

	public String execute() throws Exception {
		orders = sorders.findById(os);
		DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
		dc.add(Property.forName("orders").eq(orders));
		ps = sorderitem.findPageByCriteria(dc, pagesize, page);
		
		District district = orders.getStaddress().getDistrict();
		if (null != district && null != district.getLsareas()) {
			lsarealist.addAll(district.getLsareas());
		}

		paymodelist = spaymode.findAll();
		
		return SUCCESS;
	}
	
	public String update() throws Exception {
		Orders uos = sorders.findById(orders.getId());
		if (null != uos) {
			uos.setAmount(orders.getAmount());
			uos.setLsarea(orders.getLsarea());
			uos.setLogicost(orders.getLogicost());
			uos.setPaycost(orders.getPaycost());
			uos.setWeight(orders.getWeight());
			uos.setInvoicetitle(orders.getInvoicetitle());
			uos.setDuty(orders.getDuty());
			uos.setDiscount(orders.getDiscount());
			uos.setActamount(orders.getActamount());
			uos.setPaymode(orders.getPaymode());
			Paymode pm = spaymode.findById(uos.getPaymode().getId());
			if (pm.getPmtype().equals("other")) {//线下支付
				uos.setStatus(orders.getStatus());
			}
			sorders.merge(uos);
			setOs(uos.getId());
			return SUCCESS;
		}
		notice.setStatus(false);
		notice.setCode("orders not exist");
		notice.setTitle("错误");
		notice.setBody("非法请求或该订单不存在");
		return ERROR;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
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

	public List getLsarealist() {
		return lsarealist;
	}

	public void setLsarealist(List lsarealist) {
		this.lsarealist = lsarealist;
	}

	public List getPaymodelist() {
		return paymodelist;
	}

	public void setPaymodelist(List paymodelist) {
		this.paymodelist = paymodelist;
	}
}
