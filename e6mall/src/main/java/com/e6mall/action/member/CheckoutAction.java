package com.e6mall.action.member;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang.RandomStringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Property;

import com.e6mall.action.BaseAction;
import com.e6mall.model.Lsarea;
import com.e6mall.model.Orderitem;
import com.e6mall.model.Orders;
import com.e6mall.model.Paymode;
import com.e6mall.model.Staddress;
import com.e6mall.utils.COrders;

public class CheckoutAction extends BaseAction {
	private static final long serialVersionUID = -7022458098977117098L;
	private String str;
	private String la;
	private String pm;
	private Orders orders = new Orders();
	private String os;//转向

	public String execute() throws Exception {
		Staddress staddress = sstaddress.findById(str);
		Lsarea lsarea = slsarea.findById(la);//
		Paymode paymode = spaymode.findById(pm);
		if (null != staddress && null != lsarea && null != paymode) {
			orders.setId(getUuid());
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");//年月日小时分秒毫秒
			String code = sdf.format(new Date()) + RandomStringUtils.random(3, "ABCDEFGHIJKLMNOPQRSTUVWXYZ");
			System.out.println(code);
			orders.setCode(code);
			orders.setSubject("");
			orders.setBody("");
			orders.setStatus(COrders.WAIT_BUYER_PAY);
			orders.setMember(getMsession());
			orders.setCtime(getTimestamp());
			orders.setAmount(new Double(0));
			orders.setStaddress(staddress);
			orders.setLsarea(lsarea);
			orders.setPaymode(paymode);
			orders.setBaojia(new Double(0));
			orders.setInvoicetitle("");
			orders.setDuty(new Double(0));
			orders.setDiscount(new Double(0));
			orders.setActamount(orders.getAmount());
			orders.setLogicost(new Double(0));
			orders.setWeight(new Double(0));
			orders.setPaycost(new Double(0));
			orders = sorders.merge(orders);
			
			DetachedCriteria dc = DetachedCriteria.forClass(Orderitem.class);
			dc.add(Property.forName("member").eq(getMsession()));
			dc.add(Property.forName("orders").isNull());
			List list = sorderitem.findAllByCriteria(dc);
			Double weight = new Double(0);
			Double amount = new Double(0);
			for (int i=0; i<list.size(); i++) {
				Orderitem oi = (Orderitem)list.get(i);
				oi.setOrders(orders);
				sorderitem.merge(oi);
				//将免费送货的商品排除,no表示非免费送货商品
				if (null != oi.getGoods().getFreeshipping() && oi.getGoods().getFreeshipping().equals("no")) {
					if (null != oi.getSpec() && null != oi.getSpec().getWeight())
						weight += oi.getSpec().getWeight() * oi.getNumber();
					else if (null != oi.getGoods().getWeight())
						weight += oi.getGoods().getWeight() * oi.getNumber();
				}
					
				amount += oi.getSubtotal();
				orders.setSubject(oi.getGoods().getName()+"...");	//设置订单主题
				orders.setBody(oi.getGoods().getName()+"...");			//设置订单描述
			}
			//更新商品总重量
			orders.setLogicost(lsarea.getLogicost(weight));
			orders.setWeight(weight);
			orders.setAmount(amount);
			orders.setActamount(amount);
			orders.setPaycost((paymode.getRate() / 100) * amount);//TODO 还是要在模型里处理，要减去免费额度
			sorders.merge(orders);
			
			setOs(orders.getId());
			return SUCCESS;
		} else {
			return ERROR;
		}
	}

	public String getStr() {
		return str;
	}

	public void setStr(String str) {
		this.str = str;
	}

	public String getLa() {
		return la;
	}

	public void setLa(String la) {
		this.la = la;
	}

	public String getPm() {
		return pm;
	}

	public void setPm(String pm) {
		this.pm = pm;
	}

	public Orders getOrders() {
		return orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}

	public String getOs() {
		return os;
	}

	public void setOs(String os) {
		this.os = os;
	}
}
