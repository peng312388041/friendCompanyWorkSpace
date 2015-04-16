package com.e6mall.action;

import java.util.Iterator;

import com.e6mall.model.Orderitem;
import com.e6mall.model.Orders;

public class ScartUpdateAction extends BaseAction {
	private static final long serialVersionUID = -6541128249857721707L;
	private Orderitem orderitem;

	public String execute() throws Exception {
		Orders orders = (Orders)session.get("orders");
		if (null != orders) {
			Iterator itr = orders.getOrderitems().iterator();
			while(itr.hasNext()){
				Orderitem oi = (Orderitem)itr.next();
				if (oi.getId().equals(orderitem.getId())) {
					//orders.getOrderitems().remove(oi);
					oi.setNumber(orderitem.getNumber());
					oi.setSubtotal(oi.getUnitprice() * orderitem.getNumber());
					//打折：小计-折扣/100*小计
					oi.setActsum(oi.getSubtotal() - (oi.getDiscount() / 100 * oi.getSubtotal()));
					orders.getOrderitems().add(oi);
					session.put("orders", orders);
				}
			}
		}
		return SUCCESS;
	}
	
	public String delorderitem() throws Exception {
		Orders orders = (Orders)session.get("orders");
		if (null != orders) {
			Iterator itr = orders.getOrderitems().iterator();
			while(itr.hasNext()){
				Orderitem oi = (Orderitem)itr.next();
				if (oi.getId().equals(orderitem.getId())) {
					itr.remove();
					orders.getOrderitems().remove(oi);
					System.out.println("删除订单条目："+oi.getGoods().getName());
					session.put("orders", orders);
				}
			}
		}
		return SUCCESS;
	}
	
	/*
	 * 清空购物车
	 */
	public String clear() throws Exception {
		session.remove("orders");
		return SUCCESS;
	}

	public Orderitem getOrderitem() {
		return orderitem;
	}

	public void setOrderitem(Orderitem orderitem) {
		this.orderitem = orderitem;
	}
}
