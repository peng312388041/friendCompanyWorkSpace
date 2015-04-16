package com.e6mall.action.member;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Orderitem;

public class CartUpdateAction extends BaseAction {
	private static final long serialVersionUID = -8908244753091538412L;
	private Orderitem orderitem;

	public String execute() throws Exception {
		Orderitem oi = sorderitem.findById(orderitem.getId());
		oi.setNumber(orderitem.getNumber());
		oi.setSubtotal(oi.getUnitprice() * orderitem.getNumber());
		//打折：小计-折扣/100*小计
		oi.setActsum(oi.getSubtotal() - (oi.getDiscount() / 100 * oi.getSubtotal()));
		sorderitem.merge(oi);
		return SUCCESS;
	}
	
	public String delorderitem() throws Exception {
		Orderitem oi = sorderitem.findById(orderitem.getId());
		sorderitem.delete(oi);
		return SUCCESS;
	}

	public Orderitem getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(Orderitem orderitem) {
		this.orderitem = orderitem;
	}
}
