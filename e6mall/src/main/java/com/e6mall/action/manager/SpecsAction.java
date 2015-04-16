package com.e6mall.action.manager;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Property;
import org.hibernate.criterion.Restrictions;

import com.e6mall.action.manager.BaseAction;
import com.e6mall.model.Goods;
import com.e6mall.model.Spec;
import com.e6mall.model.Specitem;

public class SpecsAction extends BaseAction {
	private static final long serialVersionUID = 2693491936123617800L;
	private String gs;
	private Goods goods;
	private List list;
	private List silist;
	private String[] checkbox;

	public String execute() throws Exception {
		goods = sgoods.findById(gs);
		DetachedCriteria dc = DetachedCriteria.forClass(Spec.class);
		dc.add(Property.forName("goods").eq(goods));
		list = sspec.findAllByCriteria(dc);
		
		if (null != goods.getGstype()) {
			DetachedCriteria sdc = DetachedCriteria.forClass(Specitem.class);
			sdc.createCriteria("gstypes").add(Restrictions.eq("id", goods.getGstype().getId()));
			sdc.addOrder(Order.asc("name"));
			silist = sspecitem.findAllByCriteria(sdc);
			return SUCCESS;
		} else {
			notice.setStatus(false);
			notice.setCode("goods_haven't_gstype");
			notice.setTitle("提示：");
			notice.setBody("该商品没有设置商品类型，无法录入商品规格信息。");
			return ERROR;
		}
	}
	
	public String delete() throws Exception {
		for (int i=0; i<checkbox.length; i++) {
			Spec spec = sspec.findById(checkbox[i]);
			sspec.delete(spec);
		}
		return SUCCESS;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public Goods getGoods() {
		return goods;
	}

	public void setGoods(Goods goods) {
		this.goods = goods;
	}

	public List getList() {
		return list;
	}

	public void setList(List list) {
		this.list = list;
	}

	public List getSilist() {
		return silist;
	}

	public void setSilist(List silist) {
		this.silist = silist;
	}

	public String[] getCheckbox() {
		return checkbox;
	}

	public void setCheckbox(String[] checkbox) {
		this.checkbox = checkbox;
	}
}
