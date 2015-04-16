package com.e6mall.action.member;

import java.util.Iterator;
import java.util.List;

import org.apache.struts2.json.annotations.JSON;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Lsarea;
import com.e6mall.model.Orderitem;
import com.e6mall.model.Orders;
import com.e6mall.model.Staddress;

public class LsareaAjaxAction extends BaseAction {
	private static final long serialVersionUID = 7149637139110520447L;
	private String str;
	private Staddress staddress;
	private List lsareas;
	private Orders orders;
	
	public String execute() throws Exception {
		staddress = sstaddress.findById(str);
		if (null != staddress && null != staddress.getId() && null != staddress.getDistrict()) {
			DetachedCriteria dc = DetachedCriteria.forClass(Lsarea.class);
			dc.createCriteria("districts").add(Restrictions.eq("id", staddress.getDistrict().getId()));
			lsareas = slsarea.findAllByCriteria(dc);
		} else {
			DetachedCriteria dc2 = DetachedCriteria.forClass(Lsarea.class);
			dc2.add(Property.forName("status").eq("default"));//如果客户不在可选择的区域内，对应的物流区域为NULL，就查找系统内的默认物流区域
			lsareas = slsarea.findAllByCriteria(dc2);
		}
		
		orders = (Orders)session.get("orders");
		if (null != orders && null != orders.getOrderitems()) {
			Iterator it = orders.getOrderitems().iterator();
			
			Double weight = new Double(0);
			Double amount = new Double(0);
			while (it.hasNext()) {
				Orderitem oi = (Orderitem)it.next();
				if (null != oi.getSpec() && null != oi.getSpec().getWeight())
					weight += oi.getSpec().getWeight() * oi.getNumber();
				else if (null != oi.getGoods().getWeight())
					weight += oi.getGoods().getWeight() * oi.getNumber();
					
				amount += oi.getSubtotal();
				orders.setAmount(amount);
			}
			orders.setWeight(weight);
		}
		
		return SUCCESS;
	}
	
	@JSON(serialize = false)
	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	@JSON(serialize = false)
	public Staddress getStaddress() {
		return staddress;
	}

	public void setStaddress(Staddress staddress) {
		this.staddress = staddress;
	}

	public List getLsareas() {
		return lsareas;
	}

	public void setLsareas(List lsareas) {
		this.lsareas = lsareas;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
}
