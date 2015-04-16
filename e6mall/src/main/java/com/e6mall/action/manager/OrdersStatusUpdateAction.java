package com.e6mall.action.manager;

import java.util.Iterator;

import com.e6mall.model.Goods;
import com.e6mall.model.Orderitem;
import com.e6mall.model.Orders;
import com.e6mall.model.Spec;
import com.e6mall.utils.COrders;
import com.e6mall.utils.alipay.ConfirmSendUrl;

public class OrdersStatusUpdateAction extends BaseAction {
	private static final long serialVersionUID = 1834916987973119213L;
	private String os;
	
	public String execute() throws Exception {
		Orders orders = sorders.findById(os);
		
		ConfirmSendUrl csu = new ConfirmSendUrl();
		String result = csu.Confirm(orders);//TODO 没有开通确认发货接口
		
		String status = "";
		status = orders.getStatus();
		if (status.equals(COrders.WAIT_SELLER_SEND_GOODS)) {
			orders.setStatus(COrders.WAIT_BUYER_CONFIRM_GOODS);
			sorders.merge(orders);
			
			Iterator itr = orders.getOrderitems().iterator();
			while(itr.hasNext()){
				Orderitem oi = (Orderitem)itr.next();
				Integer number = oi.getNumber();
				Spec spec = oi.getSpec();
				if (null != spec) {
					spec.setInventory(spec.getInventory() - number);
					sspec.merge(spec);
				} else {
					Goods goods = oi.getGoods();
					if ((goods.getInventory() - number) >= 0) {
						goods.setInventory(goods.getInventory() - number);
						sgoods.merge(goods);
					}
				}
			}
		}
		return SUCCESS;
	}
	
	public String close() throws Exception {
		Orders orders = sorders.findById(os);
		orders.setStatus(COrders.TRADE_CLOSED);
		sorders.merge(orders);
		return SUCCESS;
	}
	
	//设置为已付款，通常为线下付款
	public String paid() throws Exception {
		Orders orders = sorders.findById(os);
		orders.setStatus(COrders.WAIT_SELLER_SEND_GOODS);
		sorders.merge(orders);
		return SUCCESS;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
}
