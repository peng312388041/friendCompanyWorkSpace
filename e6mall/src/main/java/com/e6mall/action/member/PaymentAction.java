package com.e6mall.action.member;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.utils.alipay.PaymentUrl;

public class PaymentAction extends BaseAction {
	private static final long serialVersionUID = -4106588166663674795L;
	private String os;//订单
	private Orders orders;
	
	private String urlparam;

	public String execute() throws Exception {
		orders = sorders.findById(os);
		Paymode paymode = orders.getPaymode();
		
		if (null != paymode && (paymode.getPmtype().equals("alipay"))) {
			PaymentUrl payment = new PaymentUrl();
			String preUrl = "http://" + request.getHeader("host") + request.getContextPath();
			urlparam = payment.getUrlparam(orders, preUrl);
			if (!urlparam.equals(""))
				return SUCCESS;
		} else if (null != paymode && (paymode.getPmtype().equals("firstdata"))) {
			return "firstdata";
		} else if (null != paymode && (paymode.getPmtype().equals("other"))) {
			//notice.setStatus(false);
			//notice.setTitle("提示：");
			//notice.setCode("not online paymode");
			//notice.setBody("该支付方式暂不支持在线支付。");
			
			return "offline";
			//return "details";
		}
		
		notice.setStatus(false);
		notice.setTitle("提示：");
		notice.setCode("not implement paymode");
		notice.setBody("该支付方式暂不支持。");
		
		return "notice";
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

	public String getUrlparam() {
		return urlparam;
	}

	public void setUrlparam(String urlparam) {
		this.urlparam = urlparam;
	}
}
