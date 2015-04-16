package com.e6mall.action;

import java.math.BigDecimal;
import java.util.Iterator;

import com.e6mall.model.Goods;
import com.e6mall.model.Orderitem;
import com.e6mall.model.Orders;
import com.e6mall.model.Spec;
import com.e6mall.model.Specvalue;
import com.e6mall.utils.COrders;
import com.e6mall.utils.Constants;
import com.e6mall.utils.Notice;

public class AddtocartAction extends BaseAction {
	private static final long serialVersionUID = 1835512713821597953L;
	private Notice notice = new Notice();
	private String gs;	//商品
	private String sc;	//商品规格
	private Integer num;	//商品数量

	public String execute() throws Exception {
		Goods goods = sgoods.findById(gs);	//购买的商品
		if (null != goods) {
			Orderitem oi = new Orderitem();	//新订单条目
			oi.setId(getUuid());
			oi.setGoods(goods);
			oi.setMember(getMsession());
			Double unitprice = new Double(0);
			if (null != sc && !sc.equals("")) {	//可选的商品规格
				Spec spec = sspec.findById(sc);
				Iterator it = spec.getSpecvalues().iterator();
				while (it.hasNext()) {
					Specvalue sv = (Specvalue)it.next();
					System.out.println(sv.getSpecitem().getName()+":"+sv.getName());
				}
				unitprice = spec.getPrice();	//商品规格的价格
				oi.setSpec(spec);
			} else {
				unitprice = goods.getPrice();	//使用默认单价
			}
			if (null == unitprice || unitprice <= 0) {	//商品没有单价
				notice.setCode(COrders.NOTICE_NOPRICE_CODE);
				notice.setStatus(false);
				notice.setTitle(COrders.NOTICE_NOPRICE_TITLE);
				notice.setBody(COrders.NOTICE_NOPRICE_BODY);
				return ERROR;
			}
			oi.setUnitprice(unitprice);
			oi.setNumber(num);

			BigDecimal b = new BigDecimal(unitprice * num);
			Double d = b.setScale(2,BigDecimal.ROUND_HALF_UP).doubleValue();
			
			oi.setSubtotal(d);	//TODO 需改进模型设计，移入模型操作
			oi.setDiscount(new Double(0));
			oi.setActsum(oi.getSubtotal());
			oi.setIspay(COrders.NO);
			oi.setStatus(Constants.NORMAL);
			oi.setCtime(getTimestamp());

			Orders orders = (Orders)session.get("orders");
			System.out.println("取得订单Session。");
			if (null == orders) {
				orders = new Orders();
				System.out.println("订单Session是空的，新建一个");
			}
			orders.getOrderitems().add(oi);
			System.out.println("加入订单，"+oi.getGoods().getName());
			session.put("orders", orders);
			return SUCCESS;
		}
		return SUCCESS;
	}

	public Notice getNotice() {
		return notice;
	}

	public void setNotice(Notice notice) {
		this.notice = notice;
	}

	public String getGs() {
		return gs;
	}

	public void setGs(String gs) {
		this.gs = gs;
	}

	public String getSc() {
		return sc;
	}

	public void setSc(String sc) {
		this.sc = sc;
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}
}
